# F — LCS

### Problem Statement
You are given strings s and t. Find one longest string that is a subsequence of both s and t.

> **Note:** A subsequence is obtained by removing zero or more characters from a string without changing the order of the remaining characters.

### Constraints
- s and t are strings consisting of lowercase English letters.
- 1 ≤ |s|, |t| ≤ 3000

### Input Format
```
s
t
```

### Output
Print one longest common subsequence of s and t. If multiple answers exist, any one is accepted.

### Sample Test Cases

**Sample Input 1:**
```
axyb
abyxb
```
**Sample Output 1:**
```
axb
```
*(or `ayb`)*

**Sample Input 2:**
```
aa
xayaz
```
**Sample Output 2:**
```
aa
```

**Sample Input 3:**
```
a
z
```
**Sample Output 3:**
```

```
*(empty string)*

**Sample Input 4:**
```
abracadabra
avadakedavra
```
**Sample Output 4:**
```
aaadara
```