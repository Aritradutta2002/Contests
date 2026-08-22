<# : batch trampoline
@echo off
set "SCRIPT_ROOT=%~dp0"
powershell.exe -NoProfile -ExecutionPolicy Bypass -Command "iex ((Get-Content -Raw '%~f0') -replace '(?s)^.*?#\>','')"
pause
goto :eof
: end batch / begin PowerShell #>

# ============================================================
#  LeetCode Problem Fetcher (by link or title)
#  Double-click this .bat and enter one of:
#   - Full URL        (e.g. https://leetcode.com/problems/two-sum/)
#   - Problem number  (e.g. 1 or 0001)
#   - Problem slug    (e.g. two-sum)
#   - Problem title   (e.g. "Two Sum")
#
#  It will:
#   1. Resolve the input to a titleSlug via LeetCode GraphQL
#   2. Generate the Java solution stub
#   3. Generate the JUnit 5 test file with real assertions
#   4. Build & test the leetcode module with mvn clean install
# ============================================================

Set-StrictMode -Version Latest
$ErrorActionPreference = 'Stop'

# Repo root = directory of this .bat file
$ROOT = $env:SCRIPT_ROOT.TrimEnd('\')

# ── Helper: normalise title to filename token ──────────────────
function ConvertTo-FileName {
    param([string]$Title)
    $tokens = ($Title -replace '[^a-zA-Z0-9 ]', ' ') -split '\s+' | Where-Object { $_ -ne '' }
    return ($tokens -join '_')
}

# ── Helper: zero-pad problem number to 4 digits ───────────────
function Format-ProblemNumber {
    param([int]$Num)
    if ($Num -lt 10)   { return "000$Num" }
    if ($Num -lt 100)  { return "00$Num" }
    if ($Num -lt 1000) { return "0$Num" }
    return "$Num"
}

# ── Helper: escape HTML entities ───────────────────────────────
function ConvertFrom-HtmlEntities {
    param([string]$Text)
    $Text = $Text -replace '&lt;', '<'
    $Text = $Text -replace '&gt;', '>'
    $Text = $Text -replace '&amp;', '&'
    $Text = $Text -replace '&quot;', '"'
    $Text = $Text -replace '&#39;', "'"
    $Text = $Text -replace '&nbsp;', ' '
    return $Text
}

# ── Helper: strip HTML tags ────────────────────────────────────
function Strip-Html {
    param([string]$Html)
    $text = $Html -replace '<br\s*/?>', "`n"
    $text = $text -replace '<p>', "`n"
    $text = $text -replace '</p>', ''
    $text = $text -replace '<li>', "`n - "
    $text = $text -replace '<[^>]+>', ''
    $text = ConvertFrom-HtmlEntities $text
    $text = ($text -replace "(\r?\n){3,}", "`n`n").Trim()
    return $text
}

# ── Helper: convert LeetCode type to Java type ────────────────
function ConvertFrom-LCType {
    param([string]$LCType)
    switch ($LCType) {
        'integer'                { return 'int' }
        'integer[]'              { return 'int[]' }
        'integer[][]'            { return 'int[][]' }
        'long'                   { return 'long' }
        'long[]'                 { return 'long[]' }
        'double'                 { return 'double' }
        'double[]'               { return 'double[]' }
        'float'                  { return 'float' }
        'boolean'                { return 'boolean' }
        'boolean[]'              { return 'boolean[]' }
        'string'                 { return 'String' }
        'string[]'               { return 'String[]' }
        'string[][]'             { return 'String[][]' }
        'character'              { return 'char' }
        'character[]'            { return 'char[]' }
        'list<integer>'          { return 'List<Integer>' }
        'list<long>'             { return 'List<Long>' }
        'list<string>'           { return 'List<String>' }
        'list<boolean>'          { return 'List<Boolean>' }
        'list<list<integer>>'    { return 'List<List<Integer>>' }
        'list<list<string>>'     { return 'List<List<String>>' }
        'TreeNode'               { return 'TreeNode' }
        'ListNode'               { return 'ListNode' }
        'void'                   { return 'void' }
        default                  { return $LCType }
    }
}

# ── Helper: convert raw LeetCode value to Java literal ────────
function ConvertTo-JavaLiteral {
    param([string]$RawValue, [string]$JavaType)
    $val = $RawValue.Trim()
    if ($val -eq 'null') { return 'null' }

    switch -Exact ($JavaType) {
        'int'       { return $val }
        'long'      { return "${val}L" }
        'double'    { return $val }
        'float'     { return "${val}f" }
        'boolean'   { return $val.ToLower() }
        'char'      {
            $c = $val.Trim('"', "'")
            return "'$c'"
        }
        'String'    {
            if (-not $val.StartsWith('"')) { return "`"$val`"" }
            return $val
        }
        'int[]'     {
            $inner = $val.TrimStart('[').TrimEnd(']')
            return "new int[]{$inner}"
        }
        'long[]'    {
            $inner = $val.TrimStart('[').TrimEnd(']')
            if ($inner.Trim() -eq '') { return 'new long[]{}' }
            $nums = ($inner -split ',') | ForEach-Object { "$($_.Trim())L" }
            return "new long[]{$($nums -join ', ')}"
        }
        'double[]'  {
            $inner = $val.TrimStart('[').TrimEnd(']')
            return "new double[]{$inner}"
        }
        'boolean[]' {
            $inner = $val.TrimStart('[').TrimEnd(']').ToLower()
            return "new boolean[]{$inner}"
        }
        'char[]'    {
            $inner = $val.TrimStart('[').TrimEnd(']')
            if ($inner.Trim() -eq '') { return 'new char[]{}' }
            $chars = ($inner -split ',') | ForEach-Object {
                $c = $_.Trim().Trim('"', "'")
                "'$c'"
            }
            return "new char[]{$($chars -join ', ')}"
        }
        'String[]'  {
            $inner = $val.TrimStart('[').TrimEnd(']')
            return "new String[]{$inner}"
        }
        'int[][]'   {
            if ($val -eq '[]') { return 'new int[][]{}' }
            $inner = $val.Substring(1, $val.Length - 2)
            $inner = $inner -replace '\[', '{' -replace '\]', '}'
            return "new int[][]{$inner}"
        }
        'String[][]' {
            if ($val -eq '[]') { return 'new String[][]{}' }
            $inner = $val.Substring(1, $val.Length - 2)
            $inner = $inner -replace '\[', '{' -replace '\]', '}'
            return "new String[][]{$inner}"
        }
        'List<Integer>' {
            $inner = $val.TrimStart('[').TrimEnd(']')
            if ($inner.Trim() -eq '') { return 'List.of()' }
            return "List.of($inner)"
        }
        'List<Long>' {
            $inner = $val.TrimStart('[').TrimEnd(']')
            if ($inner.Trim() -eq '') { return 'List.of()' }
            $nums = ($inner -split ',') | ForEach-Object { "$($_.Trim())L" }
            return "List.of($($nums -join ', '))"
        }
        'List<String>' {
            $inner = $val.TrimStart('[').TrimEnd(']')
            if ($inner.Trim() -eq '') { return 'List.of()' }
            return "List.of($inner)"
        }
        'List<Boolean>' {
            $inner = $val.TrimStart('[').TrimEnd(']').ToLower()
            if ($inner.Trim() -eq '') { return 'List.of()' }
            return "List.of($inner)"
        }
        'List<List<Integer>>' {
            if ($val -eq '[]') { return 'List.of()' }
            $items = [regex]::Matches($val, '\[([^\[\]]*)\]') | ForEach-Object {
                $csv = $_.Groups[1].Value
                if ($csv.Trim() -eq '') { 'List.of()' } else { "List.of($csv)" }
            }
            return "List.of($($items -join ', '))"
        }
        'List<List<String>>' {
            if ($val -eq '[]') { return 'List.of()' }
            $items = [regex]::Matches($val, '\[([^\[\]]*)\]') | ForEach-Object {
                $csv = $_.Groups[1].Value
                if ($csv.Trim() -eq '') { 'List.of()' } else { "List.of($csv)" }
            }
            return "List.of($($items -join ', '))"
        }
        default     { return "/* UNSUPPORTED($JavaType): $val */" }
    }
}

# ── Helper: pick assertion method based on return type ─────────
function Get-AssertionCall {
    param([string]$JavaType, [string]$ActualExpr, [string]$ExpectedExpr)
    switch -Regex ($JavaType) {
        '^double$'     { return "assertEquals($ExpectedExpr, $ActualExpr, 1e-5);" }
        '^float$'      { return "assertEquals($ExpectedExpr, $ActualExpr, 1e-5f);" }
        '^int\[\]$'    { return "assertArrayEquals($ExpectedExpr, $ActualExpr);" }
        '^long\[\]$'   { return "assertArrayEquals($ExpectedExpr, $ActualExpr);" }
        '^double\[\]$' { return "assertArrayEquals($ExpectedExpr, $ActualExpr, 1e-5);" }
        '^boolean\[\]$'{ return "assertArrayEquals($ExpectedExpr, $ActualExpr);" }
        '^char\[\]$'   { return "assertArrayEquals($ExpectedExpr, $ActualExpr);" }
        '^String\[\]$' { return "assertArrayEquals($ExpectedExpr, $ActualExpr);" }
        '^int\[\]\[\]$'{ return "assertArrayEquals($ExpectedExpr, $ActualExpr);" }
        '^String\[\]\[\]$' { return "assertArrayEquals($ExpectedExpr, $ActualExpr);" }
        '\[\]\[\]$'    { return "assertArrayEquals($ExpectedExpr, $ActualExpr);" }
        '\[\]$'        { return "assertArrayEquals($ExpectedExpr, $ActualExpr);" }
        default      { return "assertEquals($ExpectedExpr, $ActualExpr);" }
    }
}

# ── Helper: extract expected outputs from HTML description ────
function Extract-ExpectedOutputs {
    param([string]$Html)
    $outputs = @()
    $pattern = '(?i)<strong>\s*Output\s*:?\s*</strong>\s*(?:<span[^>]*>\s*)?(.+?)(?:</span>|</p>|</pre>|</div>|\r?\n)'
    $ms = [regex]::Matches($Html, $pattern, [System.Text.RegularExpressions.RegexOptions]::Multiline)
    foreach ($m in $ms) {
        $raw = $m.Groups[1].Value.Trim()
        $raw = $raw -replace '<[^>]+>', ''
        $raw = ConvertFrom-HtmlEntities $raw
        if ($raw -ne '') { $outputs += $raw }
    }
    return ,$outputs
}

# ── Helper: check if type is unsupported (TreeNode, etc.) ─────
function Test-UnsupportedType {
    param([string]$JavaType)
    return ($JavaType -eq 'TreeNode' -or $JavaType -eq 'ListNode' -or
            $JavaType -match 'Node' -or $JavaType -eq 'void')
}

# ── Helper: convert user input to a titleSlug ──────────────────
# Strategy:
#  1) URL       -> extract slug from /problems/<slug>/
#  2) Number    -> page through problemsetQuestionListV2 (limit 100, skip N)
#                   until we find a problem with that questionFrontendId
#  3) Slug      -> use directly (later validated by the question fetch)
#  4) Title     -> page through problemsetQuestionListV2 and find a
#                   case-insensitive title match. If multiple, return
#                   the closest match and list the rest.
function Resolve-TitleSlug {
    param([string]$UserInput)
    $UserInput = $UserInput.Trim()

    # 1) Full URL
    if ($UserInput -match 'leetcode\.com/problems/([^/?#]+)') {
        return $Matches[1]
    }

    # If input begins with a number followed by "." (e.g. "2958. Length of..."),
    # strip the leading number prefix so we can match by title.
    if ($UserInput -match '^(\d+)\.?\s+(.+)$') {
        $UserInput = $Matches[2].Trim()
    }

    $headers = @{ 'Content-Type' = 'application/json'; 'Referer' = 'https://leetcode.com' }

    # 2) Pure integer (after possibly stripping a prefix)
    if ($UserInput -match '^\d+$') {
        $queryNum = [int]$UserInput
        return Search-ById -Id $queryNum -Headers $headers
    }

    # 3) Already looks like a slug
    if ($UserInput -match '^[a-z0-9][a-z0-9-]*$') {
        return $UserInput
    }

    # 4) Title search (page through the full list)
    return Search-ByTitle -Title $UserInput -Headers $headers
}

# ── Helper: find a problem by questionFrontendId via paginated search ──
function Search-ById {
    param([int]$Id, [hashtable]$Headers)
    $pageSize = 100
    $skip     = 0
    while ($skip -lt 5000) {
        $body = ('{{ "query": "query {{ problemsetQuestionListV2(limit: {0}, skip: {1}) {{ questions {{ questionFrontendId title titleSlug }} }} }}" }}' -f $pageSize, $skip)
        $bytes = [System.Text.Encoding]::UTF8.GetBytes($body)
        try {
            $resp = Invoke-RestMethod -Uri 'https://leetcode.com/graphql' -Method Post `
                -Body $bytes -Headers $Headers -UseBasicParsing
        } catch {
            Write-Host "  ERROR: paginated search failed." -ForegroundColor Red
            return $null
        }
        $page = @($resp.data.problemsetQuestionListV2.questions)
        if ($page.Count -eq 0) { break }
        foreach ($q in $page) {
            if ([int]$q.questionFrontendId -eq $Id) { return $q.titleSlug }
        }
        $skip += $pageSize
        if ($page.Count -lt $pageSize) { break }
    }
    Write-Host "  ERROR: no problem found with id $Id." -ForegroundColor Red
    return $null
}

# ── Helper: find a problem by (case-insensitive) title match ───
function Search-ByTitle {
    param([string]$Title, [hashtable]$Headers)
    $pageSize   = 100
    $skip       = 0
    $exactMatch = $null
    $weakMatch  = $null
    $searchKey  = ($Title.ToLower() -replace '[^a-z0-9 ]', ' ').Trim() -replace '\s+', ' '

    while ($skip -lt 5000) {
        $body = ('{{ "query": "query {{ problemsetQuestionListV2(limit: {0}, skip: {1}) {{ questions {{ questionFrontendId title titleSlug }} }} }}" }}' -f $pageSize, $skip)
        $bytes = [System.Text.Encoding]::UTF8.GetBytes($body)
        try {
            $resp = Invoke-RestMethod -Uri 'https://leetcode.com/graphql' -Method Post `
                -Body $bytes -Headers $Headers -UseBasicParsing
        } catch {
            Write-Host "  ERROR: paginated search failed." -ForegroundColor Red
            return $null
        }
        $page = @($resp.data.problemsetQuestionListV2.questions)
        if ($page.Count -eq 0) { break }
        $found = $false
        foreach ($q in $page) {
            $tNorm = ($q.title.ToLower() -replace '[^a-z0-9 ]', ' ').Trim() -replace '\s+', ' '
            if ($tNorm -eq $searchKey) {
                $exactMatch = $q
                $found = $true
                break
            }
            if (-not $weakMatch -and $tNorm -like "*$searchKey*") {
                $weakMatch = $q
            }
        }
        if ($found) { break }
        $skip += $pageSize
        if ($page.Count -lt $pageSize) { break }
    }
    if ($exactMatch) { return $exactMatch.titleSlug }
    if ($weakMatch)  { return $weakMatch.titleSlug }
    Write-Host "  ERROR: no problem found matching '$Title'." -ForegroundColor Red
    return $null
}

# ────────────────────────────────────────────────────────────────
#  STEP 1 ─ Prompt the user
# ────────────────────────────────────────────────────────────────
Write-Host "==========================================" -ForegroundColor Cyan
Write-Host " LeetCode Problem Fetcher (by link/title)" -ForegroundColor Cyan
Write-Host "==========================================" -ForegroundColor Cyan
Write-Host ""
Write-Host "Enter one of:" -ForegroundColor White
Write-Host "  - Full URL   (e.g. https://leetcode.com/problems/two-sum/)"
Write-Host "  - Slug       (e.g. two-sum)"
Write-Host "  - Number     (e.g. 1)"
Write-Host "  - Title      (e.g. Two Sum)"
Write-Host ""

$userInput = Read-Host "Problem link / number / slug / title"
if ([string]::IsNullOrWhiteSpace($userInput)) {
    Write-Host "No input provided. Exiting." -ForegroundColor Yellow
    return
}

# ────────────────────────────────────────────────────────────────
#  STEP 2 ─ Resolve input and fetch problem details
# ────────────────────────────────────────────────────────────────
Write-Host ""
Write-Host "[1/4] Resolving problem..." -ForegroundColor Cyan

$titleSlug = Resolve-TitleSlug $userInput
if (-not $titleSlug) { return }

Write-Host ""
Write-Host "[2/4] Fetching problem details for slug '$titleSlug'..." -ForegroundColor Cyan

$detailQueryBody = '{"query":"query questionData($titleSlug: String!) { question(titleSlug: $titleSlug) { questionFrontendId title content codeSnippets { lang langSlug code } exampleTestcases metaData difficulty } }","variables":{"titleSlug":"' + $titleSlug + '"}}'
$detailBytes = [System.Text.Encoding]::UTF8.GetBytes($detailQueryBody)
$headers = @{ 'Content-Type' = 'application/json'; 'Referer' = 'https://leetcode.com' }

try {
    $detailResp = Invoke-RestMethod -Uri 'https://leetcode.com/graphql' `
        -Method Post -Body $detailBytes -Headers $headers -UseBasicParsing
} catch {
    Write-Host "ERROR: Failed to fetch problem details." -ForegroundColor Red
    Write-Host $_.Exception.Message
    return
}

$question = $detailResp.data.question
if (-not $question) {
    Write-Host "ERROR: LeetCode returned no data for '$titleSlug'." -ForegroundColor Red
    return
}

$problemNum   = [int]$question.questionFrontendId
$problemTitle = $question.title
$difficulty   = $question.difficulty

Write-Host "  Problem # : $problemNum" -ForegroundColor Green
Write-Host "  Title     : $problemTitle" -ForegroundColor Green
Write-Host "  Difficulty: $difficulty" -ForegroundColor Green

$javaSnippet = ($question.codeSnippets | Where-Object { $_.langSlug -eq 'java' }).code
if (-not $javaSnippet) {
    Write-Host "WARNING: No Java code snippet found. Generating minimal stub." -ForegroundColor Yellow
    $javaSnippet = "// No Java snippet available on LeetCode for this problem."
}

$descriptionHtml = $question.content
$descriptionText = Strip-Html $descriptionHtml

# Build the Javadoc description block. Keep ALL non-empty lines so the
# problem statement, examples, and constraints survive intact. Prefix
# every line with " * " so it renders correctly inside /** ... */.
$descLines = $descriptionText -split "`n"
$nonEmptyDescLines = @($descLines | Where-Object { $_.Trim() -ne '' })
if ($nonEmptyDescLines.Count -gt 0) {
    $shortDesc = ($nonEmptyDescLines | ForEach-Object { " * $_" }) -join "`n"
} else {
    $shortDesc = " * (No description available.)"
}

$exampleTests = $question.exampleTestcases

# ────────────────────────────────────────────────────────────────
#  STEP 3 ─ Build file/class names and generate files
# ────────────────────────────────────────────────────────────────
Write-Host ""
Write-Host "[3/4] Generating files..." -ForegroundColor Cyan

$paddedNum  = Format-ProblemNumber $problemNum
$titleToken = ConvertTo-FileName $problemTitle
$className  = "LC${paddedNum}_${titleToken}"

$srcDir  = Join-Path $ROOT "leetcode\src\main\java\com\leetcode"
$testDir = Join-Path $ROOT "leetcode\src\test\java\com\leetcode"

$srcFile  = Join-Path $srcDir  "${className}.java"
$testFile = Join-Path $testDir "${className}_Test.java"

if (Test-Path $srcFile) {
    Write-Host "  Solution file already exists: $srcFile" -ForegroundColor Yellow
    $overwrite = Read-Host "  Overwrite? (y/N)"
    if ($overwrite -ne 'y' -and $overwrite -ne 'Y') {
        Write-Host "  Skipping generation." -ForegroundColor Yellow
        return
    }
}

# ── 3a  Solution stub ──────────────────────────────────────────
$snippetBody = $javaSnippet
if ($snippetBody -match '(?s)class\s+Solution\s*\{(.+)\}\s*$') {
    $snippetBody = $Matches[1].Trim()
}

# Inject the marker into every empty method body. The Maven workflow excludes
# only the paired test while this throw is present.
$methodPattern = '((?:public|private|protected)\s+(?:static\s+)?)([\w<>\[\],]+)\s+(\w+\s*\([^)]*\))(\s*throws\s+[\w\s,]+)?\s*\{\s*\}'
$snippetBody = [regex]::Replace($snippetBody, $methodPattern, [System.Text.RegularExpressions.MatchEvaluator]{
    param([System.Text.RegularExpressions.Match]$m)
    $sig = "$($m.Groups[1].Value)$($m.Groups[2].Value) $($m.Groups[3].Value)$($m.Groups[4].Value)"
    return "$sig { throw new UnsupportedOperationException(`"Not implemented yet.`"); }"
})

$solutionContent = @"
package com.leetcode;
import java.util.*;
import java.io.*;

/**
 * $problemNum. $problemTitle
 *
$shortDesc
 */
public class $className {
    $snippetBody
}
"@

if (-not (Test-Path $srcDir)) { New-Item -ItemType Directory -Path $srcDir -Force | Out-Null }

# WriteAllText defaults to UTF-8 WITHOUT BOM (Out-File -Encoding utf8 adds a
# BOM, which javac rejects as "illegal character: '﻿'").
[System.IO.File]::WriteAllText($srcFile, $solutionContent)
Write-Host "  Created: $srcFile" -ForegroundColor Green

# ── 3b  JUnit test file ────────────────────────────────────────
$testCaseLines = @()
if ($exampleTests) {
    $testCaseLines = @( ($exampleTests -split "`n") | Where-Object { $_.Trim() -ne '' } )
}

$methodName = "solve"
$paramCount = 1
$paramTypes = @()
$returnType = "int"
$returnJavaType = "int"
$paramJavaTypes = @()
$unsupported = $false

try {
    $meta = $question.metaData | ConvertFrom-Json
    if ($meta.name) { $methodName = $meta.name }
    if ($meta.params) {
        $paramCount = $meta.params.Count
        $paramTypes = @( $meta.params | ForEach-Object { $_.type } )
        $paramJavaTypes = @( $paramTypes | ForEach-Object { ConvertFrom-LCType $_ } )
    }
    if ($meta.return) {
        $returnType = $meta.return.type
        $returnJavaType = ConvertFrom-LCType $returnType
    }
    foreach ($pt in $paramJavaTypes) {
        if (Test-UnsupportedType $pt) { $unsupported = $true; break }
    }
    if (Test-UnsupportedType $returnJavaType) { $unsupported = $true }
} catch {
    if ($javaSnippet -match 'public\s+\S+\s+(\w+)\s*\(') {
        $methodName = $Matches[1]
    }
    $unsupported = $true
}

$expectedOutputs = Extract-ExpectedOutputs $descriptionHtml

Write-Host "  Method   : $methodName" -ForegroundColor DarkGray
Write-Host "  Params   : $paramCount ($($paramJavaTypes -join ', '))" -ForegroundColor DarkGray
Write-Host "  Returns  : $returnJavaType" -ForegroundColor DarkGray
Write-Host "  Examples : $($expectedOutputs.Count) outputs parsed" -ForegroundColor DarkGray

$testMethods = ""
$testIndex = 1

if (-not $unsupported -and $testCaseLines.Count -gt 0 -and $paramCount -gt 0 -and $expectedOutputs.Count -gt 0) {
    $i = 0
    $outputIdx = 0
    while ($i -lt $testCaseLines.Count -and $outputIdx -lt $expectedOutputs.Count) {
        $javaParams = @()
        $paramDecls = @()
        $allParamsOk = $true

        for ($p = 0; $p -lt $paramCount -and ($i + $p) -lt $testCaseLines.Count; $p++) {
            $rawVal = $testCaseLines[$i + $p]
            if ($p -lt $paramJavaTypes.Count) {
                $jt = $paramJavaTypes[$p]
            } else {
                $jt = 'int'
            }
            $javaLit = ConvertTo-JavaLiteral $rawVal $jt
            if ($javaLit -match 'UNSUPPORTED') { $allParamsOk = $false; break }
            $javaParams += $javaLit
            $paramDecls += "        $jt param$($p + 1) = $javaLit;"
        }

        $rawExpected = $expectedOutputs[$outputIdx]
        $expectedLit = ConvertTo-JavaLiteral $rawExpected $returnJavaType

        if ($allParamsOk -and $expectedLit -notmatch 'UNSUPPORTED') {
            $paramDeclBlock = $paramDecls -join "`n"
            $paramCallArgs = @()
            for ($p = 0; $p -lt $paramCount; $p++) {
                $paramCallArgs += "param$($p + 1)"
            }
            $callArgs = $paramCallArgs -join ', '
            $expectedDecl = "        $returnJavaType expected = $expectedLit;"
            $actualDecl   = "        $returnJavaType actual = solver.$methodName($callArgs);"
            $assertion    = Get-AssertionCall $returnJavaType 'actual' 'expected'

            $testMethods += @"

    @Test
    public void testExample$testIndex() {
$paramDeclBlock
$expectedDecl
$actualDecl
        $assertion
    }

"@
        } else {
            $paramComments = @()
            for ($p = 0; $p -lt $paramCount -and ($i + $p) -lt $testCaseLines.Count; $p++) {
                $paramComments += "        // Input param $($p + 1): $($testCaseLines[$i + $p])"
            }
            $paramCommentBlock = $paramComments -join "`n"
            $testMethods += @"

    @Test
    public void testExample$testIndex() {
        // Example $testIndex (unsupported type - fill in manually)
$paramCommentBlock
        // Expected output: $rawExpected
        // TODO: call solver.$methodName(...)
    }

"@
        }

        $testIndex++
        $i += $paramCount
        $outputIdx++
    }
} else {
    if ($testCaseLines.Count -gt 0 -and $paramCount -gt 0) {
        $i = 0
        $outputIdx = 0
        while ($i -lt $testCaseLines.Count) {
            $paramComments = @()
            for ($p = 0; $p -lt $paramCount -and ($i + $p) -lt $testCaseLines.Count; $p++) {
                $paramComments += "        // Input param $($p + 1): $($testCaseLines[$i + $p])"
            }
            $paramCommentBlock = $paramComments -join "`n"
            $expComment = ""
            if ($outputIdx -lt $expectedOutputs.Count) {
                $expComment = "`n        // Expected output: $($expectedOutputs[$outputIdx])"
            }
            $testMethods += @"

    @Test
    public void testExample$testIndex() {
$paramCommentBlock$expComment
        // TODO: call solver.$methodName(...)
    }

"@
            $testIndex++
            $i += $paramCount
            $outputIdx++
        }
    } else {
        for ($t = 1; $t -le 3; $t++) {
            $testMethods += @"

    @Test
    public void testExample$t() {
        // Example $t - TODO: fill in from LeetCode examples
        // solver.$methodName(...)
    }

"@
        }
    }
}

$testContent = @"
package com.leetcode;

import java.util.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ${className}_Test {

    private final $className solver = new ${className}();
$testMethods}
"@

if (-not (Test-Path $testDir)) { New-Item -ItemType Directory -Path $testDir -Force | Out-Null }

[System.IO.File]::WriteAllText($testFile, $testContent)
Write-Host "  Created: $testFile" -ForegroundColor Green

# ────────────────────────────────────────────────────────────────
#  STEP 4 ─ Build & test the entire leetcode module with Maven
# ────────────────────────────────────────────────────────────────
Write-Host ""
Write-Host "[4/4] Running mvn clean install for the leetcode module..." -ForegroundColor Cyan

$excludeFile = Join-Path ([System.IO.Path]::GetTempPath()) "contest-unimplemented-tests-$([guid]::NewGuid()).txt"
& (Join-Path $ROOT 'skip-unimplemented-tests.ps1') `
    -ModuleRoot (Join-Path $ROOT 'leetcode') `
    -ExcludesFile $excludeFile

# Resolve Maven: PATH first, then MAVEN_HOME / M2_HOME, then common install
# dirs. A double-clicked .bat inherits Explorer's environment, which is stale
# if Maven was added to PATH after the last sign-in.
$mvnExe = $null
$mvnCmdInfo = Get-Command mvn -ErrorAction SilentlyContinue
if ($mvnCmdInfo) { $mvnExe = $mvnCmdInfo.Source }
if (-not $mvnExe -and $env:MAVEN_HOME) {
    $cand = Join-Path $env:MAVEN_HOME 'bin\mvn.cmd'
    if (Test-Path $cand) { $mvnExe = $cand }
}
if (-not $mvnExe -and $env:M2_HOME) {
    $cand = Join-Path $env:M2_HOME 'bin\mvn.cmd'
    if (Test-Path $cand) { $mvnExe = $cand }
}
if (-not $mvnExe) {
    $cand = Get-ChildItem 'C:\*\apache-maven-*\bin\mvn.cmd' -ErrorAction SilentlyContinue | Select-Object -First 1
    if ($cand) { $mvnExe = $cand.FullName }
}

if (-not $mvnExe) {
    throw "Maven not found (checked PATH, MAVEN_HOME, M2_HOME, C:\*\apache-maven-*)."
} else {
    Write-Host "  Maven: $mvnExe" -ForegroundColor DarkGray
    Push-Location $ROOT
    try {
        # Maven/JDK print harmless warnings to stderr; with
        # $ErrorActionPreference='Stop' a 2>&1 merge would turn the first
        # stderr line into a terminating error. Relax it just for this call.
        $prevEAP = $ErrorActionPreference
        $ErrorActionPreference = 'Continue'
        $mvnOutput = & $mvnExe clean install -pl leetcode "-Dsurefire.excludesFile=$excludeFile" 2>&1
        $mvnExit = $LASTEXITCODE
        $ErrorActionPreference = $prevEAP
        if ($mvnExit -eq 0) {
            Write-Host "  BUILD SUCCESS (tests will pass once you implement the solution)" -ForegroundColor Green
        } else {
            Write-Host "  BUILD FAILURE. Maven output:" -ForegroundColor Red
            $mvnOutput | ForEach-Object { Write-Host "    $_" }
            throw "Maven build failed with exit code $mvnExit."
        }
    } catch {
        $ErrorActionPreference = $prevEAP
        throw "Maven invocation failed: $($_.Exception.Message)"
    }
    Pop-Location
}

# ────────────────────────────────────────────────────────────────
#  Summary
# ────────────────────────────────────────────────────────────────
Write-Host ""
Write-Host "Summary" -ForegroundColor Cyan
Write-Host "  -----------------------------------------------" -ForegroundColor DarkGray
Write-Host "  Problem    : $problemNum. $problemTitle" -ForegroundColor White
Write-Host "  Difficulty : $difficulty" -ForegroundColor White
Write-Host "  Slug       : $titleSlug" -ForegroundColor White
Write-Host "  Class      : $className" -ForegroundColor White
Write-Host "  Package    : com.leetcode" -ForegroundColor White
Write-Host "  Solution   : $srcFile" -ForegroundColor White
Write-Host "  Test       : $testFile" -ForegroundColor White
Write-Host "  -----------------------------------------------" -ForegroundColor DarkGray
Write-Host ""
Write-Host "  Happy coding! Now go implement your solution." -ForegroundColor Magenta
