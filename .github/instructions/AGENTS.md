---
description: Load these instructions when generating Java problem scaffolds from only a problem filename, or when preparing competitive-programming templates in this repository.
# applyTo: '*.java'
---
Provide project context and coding guidelines that AI should follow when generating code, answering questions, or reviewing changes.

## Repository Context
- This repository stores platform problem solutions and practice scaffolds under `src/`.
- Supported platforms for scaffold generation:
  - `src/LeetCode`
  - `src/CodeForces`
  - `src/CodeChef`

## Problem-Name-Only Workflow
- When the user sends only a Java filename (example: `MinimumPartitionScore3826.java`):
  - Identify platform from user input.
  - If platform is missing, ask: `Which platform: LeetCode, CodeForces, or CodeChef?`
  - Create or overwrite file in the correct folder:
    - LeetCode -> `src/LeetCode/<filename>`
    - CodeForces -> `src/CodeForces/<filename>`
    - CodeChef -> `src/CodeChef/<filename>`

## Filename Convention
- Use underscore-separated words in generated Java filenames.
- For LeetCode, follow the format `LC<ProblemNumber>_<Title>.java`.
  - Example: `1. Two Sum` -> `LC01_Two_Sum.java`
  - Example: `438. Find All Anagrams in a String` -> `LC438_Find_All_Anagrams_In_A_String.java`
  - Example: `1886. Determine Whether Matrix Can Be Obtained By Rotation` -> `LC1886_Determine_Whether_Matrix_Can_Be_Obtained_By_Rotation.java`
- For CodeForces/CodeChef, follow the format `<Title>_<ProblemID>.java` or underscore-separated words as appropriate.

## Java Scaffold Rules (No Solution)
- Use package matching folder name:
  - `package LeetCode;`
  - `package CodeForces;`
  - `package CodeChef;`
- For LeetCode, always include `import java.util.*;`.
- Class name must exactly match filename without `.java`.
- Create only the LeetCode return methods (nothing other than that).
- **The LeetCode return method MUST be placed first inside the class (above `main` and other methods).**
- **Any helper methods used by the LeetCode method MUST be placed after the LeetCode method and before `main`.**
- **The testcase runner/helper for PASS/FAIL checking must be placed at the very end of the class.**
- Do not implement algorithm.
- Method body must throw:
  - `throw new UnsupportedOperationException("Not implemented yet.");`

## Required Template Content
- Add a clear problem block comment with:
  - problem title
  - short description
  - constraints
  - input/output format (mandatory for CodeForces/CodeChef)
- Add runnable `main` method and test harness:
  - Use `Scanner` in `main` for input handling if needed.
  - Include three good test cases (from LeetCode website).
  - Test harness must output PASS/FAIL for each test case.
  - If method is unimplemented, print `SKIPPED` instead of crashing.

## Testing Cleanup
- When compiling or running Java files inside any problem folder, remove any generated `.class` files from those Java folders after testing.
- Keep scaffold test cases inside the `main` method so they are easy to run and clean up with the compiled output.

## Response Behavior
- Do not provide hints, algorithm explanation, or full solution unless user explicitly asks.
- Compile and run once after scaffold creation.
- Report:
  - file path
  - compile status
  - run summary
- If statement or samples are missing, ask user for problem link.
