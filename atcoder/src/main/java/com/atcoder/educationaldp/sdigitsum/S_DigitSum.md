# S — Digit Sum

### Problem Statement
Find the number of integers between 1 and K (inclusive) whose **digit sum is a multiple of D**, modulo 10^9+7.

### Constraints
- All values in input are integers.
- 1 ≤ K < 10^{10000}
- 1 ≤ D ≤ 100

### Input Format
```
K
D
```

### Output
Print the count, modulo 10^9+7.

### Sample Test Cases

**Sample Input 1:**
```
30
4
```
**Sample Output 1:**
```
6
```
*Those six integers are: 4, 8, 13, 17, 22, 26.*

**Sample Input 2:**
```
1000000009
1
```
**Sample Output 2:**
```
2
```

**Sample Input 3:**
```
98765432109876543210
58
```
**Sample Output 3:**
```
635270834
```