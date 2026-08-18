<# : batch trampoline
@echo off
set "SCRIPT_ROOT=%~dp0"
powershell.exe -NoProfile -ExecutionPolicy Bypass -Command "iex ((Get-Content -Raw '%~f0') -replace '(?s)^.*?#\>','')"
pause
goto :eof
: end batch / begin PowerShell #>

# ============================================================
#  LeetCode Daily Problem Fetcher
#  Double-click this .bat to:
#   1. Fetch today's daily problem via LeetCode GraphQL API
#   2. Generate the Java solution stub
#   3. Generate the JUnit 5 test file with real assertions
#   4. Build & test with mvn clean install
# ============================================================

Set-StrictMode -Version Latest
$ErrorActionPreference = 'Stop'

# Repo root = directory of this .bat file (passed via env var from batch trampoline)
$ROOT = $env:SCRIPT_ROOT.TrimEnd('\')

# ── Helper: normalise title to filename token ──────────────────
function ConvertTo-FileName {
    param([string]$Title)
    $tokens = ($Title -replace '[^a-zA-Z0-9 ]', ' ') -split '\s+' | Where-Object { $_ -ne '' }
    return ($tokens -join '_')
}

# ── Helper: zero-pad problem number ────────────────────────────
function Format-ProblemNumber {
    param([int]$Num)
    if ($Num -lt 10) { return "0$Num" }
    return "$Num"
}

# ── Helper: escape HTML entities in description ────────────────
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

# ────────────────────────────────────────────────────────────────
#  STEP 1 ─ Fetch the daily problem slug
# ────────────────────────────────────────────────────────────────
Write-Host "[1/5] Fetching today's daily problem..." -ForegroundColor Cyan

$dailyQuery = '{"query":"query questionOfToday { activeDailyCodingChallengeQuestion { date link question { questionFrontendId title titleSlug difficulty } } }"}'
$dailyBytes = [System.Text.Encoding]::UTF8.GetBytes($dailyQuery)

$headers = @{
    'Content-Type' = 'application/json'
    'Referer'      = 'https://leetcode.com'
}

try {
    $dailyResp = Invoke-RestMethod -Uri 'https://leetcode.com/graphql' `
        -Method Post -Body $dailyBytes -Headers $headers -UseBasicParsing
} catch {
    Write-Host "ERROR: Failed to fetch daily problem. Check your internet connection." -ForegroundColor Red
    Write-Host $_.Exception.Message
    return
}

$daily = $dailyResp.data.activeDailyCodingChallengeQuestion
$problemNum   = [int]$daily.question.questionFrontendId
$problemTitle = $daily.question.title
$titleSlug    = $daily.question.titleSlug
$difficulty   = $daily.question.difficulty
$dateStr      = $daily.date

Write-Host "  Date      : $dateStr" -ForegroundColor Green
Write-Host "  Problem # : $problemNum" -ForegroundColor Green
Write-Host "  Title     : $problemTitle" -ForegroundColor Green
Write-Host "  Difficulty: $difficulty" -ForegroundColor Green
Write-Host "  Slug      : $titleSlug" -ForegroundColor Green

# ────────────────────────────────────────────────────────────────
#  STEP 2 ─ Fetch full problem details (description, code, tests)
# ────────────────────────────────────────────────────────────────
Write-Host ""
Write-Host "[2/5] Fetching problem details..." -ForegroundColor Cyan

$detailQueryBody = '{"query":"query questionData($titleSlug: String!) { question(titleSlug: $titleSlug) { questionFrontendId title content codeSnippets { lang langSlug code } exampleTestcases metaData } }","variables":{"titleSlug":"' + $titleSlug + '"}}'
$detailBytes = [System.Text.Encoding]::UTF8.GetBytes($detailQueryBody)

try {
    $detailResp = Invoke-RestMethod -Uri 'https://leetcode.com/graphql' `
        -Method Post -Body $detailBytes -Headers $headers -UseBasicParsing
} catch {
    Write-Host "ERROR: Failed to fetch problem details." -ForegroundColor Red
    Write-Host $_.Exception.Message
    return
}

$question = $detailResp.data.question

# Extract Java code snippet
$javaSnippet = ($question.codeSnippets | Where-Object { $_.langSlug -eq 'java' }).code

if (-not $javaSnippet) {
    Write-Host "WARNING: No Java code snippet found. Generating minimal stub." -ForegroundColor Yellow
    $javaSnippet = "// No Java snippet available on LeetCode for this problem."
}

# Extract description text (strip HTML)
$descriptionHtml = $question.content
$descriptionText = Strip-Html $descriptionHtml

# Truncate description for the comment block (first 20 lines)
$descLines = $descriptionText -split "`n"
$shortDesc = ($descLines | Select-Object -First 20) -join "`n * "
if ($descLines.Count -gt 20) { $shortDesc += "`n * ..." }

# Extract example test cases
$exampleTests = $question.exampleTestcases

# ────────────────────────────────────────────────────────────────
#  STEP 3 ─ Build file/class names
# ────────────────────────────────────────────────────────────────
Write-Host ""
Write-Host "[3/5] Generating files..." -ForegroundColor Cyan

$paddedNum  = Format-ProblemNumber $problemNum
$titleToken = ConvertTo-FileName $problemTitle
$className  = "LC${paddedNum}_${titleToken}"

$srcDir  = Join-Path $ROOT "leetcode\src\main\java\com\leetcode"
$testDir = Join-Path $ROOT "leetcode\src\test\java\com\leetcode"

$srcFile  = Join-Path $srcDir  "${className}.java"
$testFile = Join-Path $testDir "${className}_Test.java"

# Check if files already exist
if (Test-Path $srcFile) {
    Write-Host "  Solution file already exists: $srcFile" -ForegroundColor Yellow
    Write-Host "  Skipping generation. Delete the file first to regenerate." -ForegroundColor Yellow
    return
}

# ────────────────────────────────────────────────────────────────
#  STEP 3a ─ Generate the solution stub
# ────────────────────────────────────────────────────────────────

$snippetBody = $javaSnippet
# Remove the outer "class Solution {" wrapper if present
if ($snippetBody -match '(?s)class\s+Solution\s*\{(.+)\}\s*$') {
    $snippetBody = $Matches[1].Trim()
}

# Inject "throw new UnsupportedOperationException" into empty method bodies
$snippetBody = [regex]::Replace(
    $snippetBody,
    '(\{)\s*(\})',
    '{ throw new UnsupportedOperationException("Not implemented yet."); }'
)

# Build the solution file
$solutionContent = @"
package com.leetcode;
import java.util.*;
import java.io.*;

/**
 * $problemNum. $problemTitle
 *
 * $shortDesc
 */
public class $className {
    $snippetBody
}
"@

# Ensure directory exists
if (-not (Test-Path $srcDir)) { New-Item -ItemType Directory -Path $srcDir -Force | Out-Null }

$solutionContent | Out-File -FilePath $srcFile -Encoding utf8 -NoNewline
Write-Host "  Created: $srcFile" -ForegroundColor Green

# ────────────────────────────────────────────────────────────────
#  STEP 3b ─ Generate the JUnit 5 test file
# ────────────────────────────────────────────────────────────────

$testCaseLines = @()
if ($exampleTests) {
    $testCaseLines = @( ($exampleTests -split "`n") | Where-Object { $_.Trim() -ne '' } )
}

# Parse metaData to get method name, parameter types, and return type
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
    # Check for unsupported types (TreeNode, ListNode, void, etc.)
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

# Extract expected outputs from HTML description
$expectedOutputs = Extract-ExpectedOutputs $descriptionHtml

Write-Host "  Method   : $methodName" -ForegroundColor DarkGray
Write-Host "  Params   : $paramCount ($($paramJavaTypes -join ', '))" -ForegroundColor DarkGray
Write-Host "  Returns  : $returnJavaType" -ForegroundColor DarkGray
Write-Host "  Examples : $($expectedOutputs.Count) outputs parsed" -ForegroundColor DarkGray

# Build test methods with real assertions
$testMethods = ""
$testIndex = 1

if (-not $unsupported -and $testCaseLines.Count -gt 0 -and $paramCount -gt 0 -and $expectedOutputs.Count -gt 0) {
    $i = 0
    $outputIdx = 0
    while ($i -lt $testCaseLines.Count -and $outputIdx -lt $expectedOutputs.Count) {
        # Gather parameters for this test case
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

        # Convert expected output
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
            $actualDecl = "        $returnJavaType actual = solver.$methodName($callArgs);"
            $assertion = Get-AssertionCall $returnJavaType 'actual' 'expected'

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
            # Fallback to TODO stub for unsupported types
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
    # Fallback: generate TODO stubs when types cannot be inferred
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

$testContent | Out-File -FilePath $testFile -Encoding utf8 -NoNewline
Write-Host "  Created: $testFile" -ForegroundColor Green

# ────────────────────────────────────────────────────────────────
#  STEP 4 ─ Run mvn clean install
# ────────────────────────────────────────────────────────────────
Write-Host ""
Write-Host "[4/5] Running mvn clean install..." -ForegroundColor Cyan

Push-Location $ROOT
try {
    $mvnOutput = & mvn clean install -pl leetcode 2>&1
    if ($LASTEXITCODE -eq 0) {
        Write-Host "  BUILD SUCCESS" -ForegroundColor Green
    } else {
        Write-Host "  BUILD FAILURE. Maven output:" -ForegroundColor Red
        $mvnOutput | ForEach-Object { Write-Host "    $_" }
    }
} catch {
    Write-Host "  WARNING: Maven not found or build failed." -ForegroundColor Yellow
    Write-Host "  You can build manually: mvn clean install -pl leetcode" -ForegroundColor Yellow
}
Pop-Location

# ────────────────────────────────────────────────────────────────
#  STEP 5 ─ Summary
# ────────────────────────────────────────────────────────────────
Write-Host ""
Write-Host "[5/5] Summary" -ForegroundColor Cyan
Write-Host "  -----------------------------------------------" -ForegroundColor DarkGray
Write-Host "  Date       : $dateStr" -ForegroundColor White
Write-Host "  Problem    : $problemNum. $problemTitle" -ForegroundColor White
Write-Host "  Difficulty : $difficulty" -ForegroundColor White
Write-Host "  Class      : $className" -ForegroundColor White
Write-Host "  Package    : com.leetcode" -ForegroundColor White
Write-Host "  Solution   : $srcFile" -ForegroundColor White
Write-Host "  Test       : $testFile" -ForegroundColor White
Write-Host "  -----------------------------------------------" -ForegroundColor DarkGray
Write-Host ""
Write-Host "  Happy coding! Now go implement your solution." -ForegroundColor Magenta
