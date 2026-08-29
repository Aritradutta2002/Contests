param(
    [Parameter(Mandatory = $true)]
    [string]$ModuleRoot,
    [Parameter(Mandatory = $true)]
    [string]$ExcludesFile,
    # Optional: when supplied, writes "skipped", "selected", "total" (one per line)
    # so a caller such as fetch_leetcode.bat can report exact counts.
    [string]$SummaryFile,
    # Matches the generated placeholder in either form:
    #   throw new UnsupportedOperationException("Not implemented yet.");
    #   throw new UnsupportedOperationException();
    # It deliberately does NOT match "catch (UnsupportedOperationException ex)".
    [string]$MarkerPattern = 'throw\s+new\s+UnsupportedOperationException\s*\(\s*(?:"[^"]*")?\s*\)'
)

$ErrorActionPreference = 'Stop'

$sourceRoot = Join-Path $ModuleRoot 'src\main\java'
$testRoot = Join-Path $ModuleRoot 'src\test\java'
$unimplementedTests = [System.Collections.Generic.HashSet[string]]::new(
    [System.StringComparer]::OrdinalIgnoreCase
)

function Get-RelativePath {
    param([string]$BasePath, [string]$Path)
    $baseUri = [System.Uri]((Resolve-Path $BasePath).Path + '\')
    $pathUri = [System.Uri](Resolve-Path $Path).Path
    return [System.Uri]::UnescapeDataString($baseUri.MakeRelativeUri($pathUri).ToString()) -replace '/', '\'
}

if (Test-Path $sourceRoot) {
    Get-ChildItem -Path $sourceRoot -Filter '*.java' -File -Recurse | ForEach-Object {
        $source = [System.IO.File]::ReadAllText($_.FullName)
        if ($source -match $MarkerPattern) {
            $relativeSource = Get-RelativePath $sourceRoot $_.FullName
            $relativeTest = [System.IO.Path]::ChangeExtension($relativeSource, $null)
            $relativeTest = $relativeTest.TrimEnd('.') + '_Test.java'
            $testPath = Join-Path $testRoot $relativeTest
            if (Test-Path $testPath) {
                $testPattern = '**/' + ($relativeTest -replace '\\', '/')
                [void]$unimplementedTests.Add($testPattern)
            } else {
                Write-Host "[WARN] No corresponding test found for $($_.FullName)" -ForegroundColor Yellow
            }
        }
    }
}

$testPatterns = @($unimplementedTests | Sort-Object)
[System.IO.File]::WriteAllLines($ExcludesFile, $testPatterns)

$allTests = @()
if (Test-Path $testRoot) {
    $allTests = @(Get-ChildItem -Path $testRoot -Filter '*_Test.java' -File -Recurse | Sort-Object FullName)
}
$skippedCount = 0
foreach ($test in $allTests) {
    $relativeTest = (Get-RelativePath $testRoot $test.FullName) -replace '\\', '/'
    $pattern = '**/' + $relativeTest
    if ($unimplementedTests.Contains($pattern)) {
        Write-Host "[SKIP] $relativeTest (solution is not implemented)" -ForegroundColor Yellow
        $skippedCount++
    } else {
        Write-Host "[RUN]  $relativeTest" -ForegroundColor Green
    }
}

$selectedCount = $allTests.Count - $skippedCount
Write-Host "Test selection: $skippedCount skipped, $selectedCount selected to run." -ForegroundColor Cyan

if ($SummaryFile) {
    [System.IO.File]::WriteAllLines($SummaryFile, @("$skippedCount", "$selectedCount", "$($allTests.Count)"))
}