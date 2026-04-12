param(
    [string]$FilePath,
    [string]$WorkspaceRoot
)

# Remove extra quotes if present
$FilePath = $FilePath.Trim('"')
$WorkspaceRoot = $WorkspaceRoot.Trim('"')

if ([string]::IsNullOrWhiteSpace($FilePath)) {
    $fallbackFilePath = $args |
        ForEach-Object { $_.ToString().Trim('"') } |
        Where-Object { $_ -match '\.java$' } |
        Select-Object -First 1

    if (-not [string]::IsNullOrWhiteSpace($fallbackFilePath)) {
        $FilePath = $fallbackFilePath
    }
}

if ([string]::IsNullOrWhiteSpace($WorkspaceRoot)) {
    $WorkspaceRoot = $PSScriptRoot
}

if ([string]::IsNullOrWhiteSpace($FilePath) -or -not (Test-Path -LiteralPath $FilePath)) {
    Write-Host "Invalid Java file path passed to script: '$FilePath'" -ForegroundColor Red
    exit 1
}

# Compile the Java file
$binPath = Join-Path $WorkspaceRoot "bin"
$srcPath = Join-Path $WorkspaceRoot "src"
javac -d $binPath -sourcepath $srcPath "$FilePath"

if ($LASTEXITCODE -ne 0) {
    Write-Host "Compilation failed!" -ForegroundColor Red
    exit 1
}

# Extract package name from the file
$content = Get-Content -Raw $FilePath
$packageMatch = [regex]::Match($content, '^\s*package\s+([A-Za-z0-9_.]+)\s*;', [System.Text.RegularExpressions.RegexOptions]::Multiline)

# Get the class name (filename without extension)
$className = [System.IO.Path]::GetFileNameWithoutExtension($FilePath)

# Run the Java program
if ($packageMatch.Success) {
    $packageName = $packageMatch.Groups[1].Value
    $fullClassName = "$packageName.$className"
    java -cp $binPath $fullClassName
} else {
    java -cp $binPath $className
}
