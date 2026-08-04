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
#   3. Generate the JUnit 5 test file
#   4. Verify compilation with Maven
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

$srcDir  = Join-Path $ROOT "leetcode\src\main\java\com\aritra\contests\leetcode"
$testDir = Join-Path $ROOT "leetcode\src\test\java\com\aritra\contests\leetcode"

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
package com.aritra.contests.leetcode;
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
    $testCaseLines = ($exampleTests -split "`n") | Where-Object { $_.Trim() -ne '' }
}

# Parse metaData to get method name and parameter info
$methodName = "solve"
$paramCount = 1
try {
    $meta = $question.metaData | ConvertFrom-Json
    if ($meta.name) { $methodName = $meta.name }
    if ($meta.params) { $paramCount = $meta.params.Count }
} catch {
    if ($javaSnippet -match 'public\s+\S+\s+(\w+)\s*\(') {
        $methodName = $Matches[1]
    }
}

# Build test methods from example test case lines
$testMethods = ""
$testIndex = 1

if ($testCaseLines.Count -gt 0 -and $paramCount -gt 0) {
    $i = 0
    while ($i -lt $testCaseLines.Count) {
        $params = @()
        for ($p = 0; $p -lt $paramCount -and ($i + $p) -lt $testCaseLines.Count; $p++) {
            $params += "        // Input param $($p + 1): $($testCaseLines[$i + $p])"
        }
        $paramComments = $params -join "`n"

        $testMethods += @"

    @Test
    public void testExample$testIndex() {
        // Example $testIndex from LeetCode
$paramComments
        // TODO: set up inputs and expected output, then call solver.$methodName(...)
    }

"@
        $testIndex++
        $i += $paramCount
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

$testContent = @"
package com.aritra.contests.leetcode;

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
#  STEP 4 ─ Verify compilation
# ────────────────────────────────────────────────────────────────
Write-Host ""
Write-Host "[4/5] Verifying compilation..." -ForegroundColor Cyan

Push-Location $ROOT
try {
    $mvnOutput = & mvn compile -pl leetcode -q 2>&1
    if ($LASTEXITCODE -eq 0) {
        Write-Host "  Compilation SUCCESSFUL" -ForegroundColor Green
    } else {
        Write-Host "  Compilation FAILED. Maven output:" -ForegroundColor Red
        $mvnOutput | ForEach-Object { Write-Host "    $_" }
    }
} catch {
    Write-Host "  WARNING: Maven not found or compile failed." -ForegroundColor Yellow
    Write-Host "  You can compile manually: mvn compile -pl leetcode" -ForegroundColor Yellow
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
Write-Host "  Package    : com.aritra.contests.leetcode" -ForegroundColor White
Write-Host "  Solution   : $srcFile" -ForegroundColor White
Write-Host "  Test       : $testFile" -ForegroundColor White
Write-Host "  -----------------------------------------------" -ForegroundColor DarkGray
Write-Host ""
Write-Host "  Happy coding! Now go implement your solution." -ForegroundColor Magenta
