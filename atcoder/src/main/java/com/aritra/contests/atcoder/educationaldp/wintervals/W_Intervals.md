# W — Intervals

### Problem Statement
Consider a binary string of length N (characters `0` or `1`). The score is calculated as:
- For each i (1 ≤ i ≤ M), add a_i to the score if the string contains at least one `1` between positions l_i and r_i (inclusive).

Find the **maximum possible score** of a string.

### Constraints
- All values in input are integers.
- 1 ≤ N ≤ 2×10^5
- 1 ≤ M ≤ 2×10^5
- 1 ≤ l_i ≤ r_i ≤ N
- |a_i| ≤ 10^9

### Input Format
```
N M
l_1 r_1 a_1
l_2 r_2 a_2
...
l_M r_M a_M
```

### Output
Print the maximum possible score.

### Sample Test Cases

**Sample Input 1:**
```
5 3
1 3 10
2 4 -10
3 5 10
```
**Sample Output 1:**
```
20
```
*String `10001` gives a_1 + a_3 = 10 + 10 = 20.*

**Sample Input 2:**
```
3 4
1 3 100
1 1 -10
2 2 -20
3 3 -30
```
**Sample Output 2:**
```
90
```

**Sample Input 3:**
```
1 1
1 1 -10
```
**Sample Output 3:**
```
0
```

**Sample Input 4:**
```
1 5
1 1 1000000000
1 1 1000000000
1 1 1000000000
1 1 1000000000
1 1 1000000000
```
**Sample Output 4:**
```
5000000000
```

**Sample Input 5:**
```
6 8
5 5 3
1 1 10
1 6 -8
3 6 5
3 4 9
5 5 -2
1 3 -6
4 6 -7
```
**Sample Output 5:**
```
10
```