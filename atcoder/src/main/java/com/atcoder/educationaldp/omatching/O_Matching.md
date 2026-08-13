# O — Matching

### Problem Statement
There are N men and N women, numbered 1, 2, …, N. The compatibility of Man i and Woman j is given by a_{i,j} (1 = compatible, 0 = not).

Find the number of ways to make N pairs (each man paired with exactly one woman and vice versa, all compatible), modulo 10^9+7.

### Constraints
- All values in input are integers.
- 1 ≤ N ≤ 21
- a_{i,j} is 0 or 1.

### Input Format
```
N
a_1,1 … a_1,N
...
a_N,1 … a_N,N
```

### Output
Print the number of valid pairings, modulo 10^9+7.

### Sample Test Cases

**Sample Input 1:**
```
3
0 1 1
1 0 1
1 1 1
```
**Sample Output 1:**
```
3
```
*Pairs: {(1,2),(2,1),(3,3)}, {(1,2),(2,3),(3,1)}, {(1,3),(2,1),(3,2)}*

**Sample Input 2:**
```
4
0 1 0 0
0 0 0 1
1 0 0 0
0 0 1 0
```
**Sample Output 2:**
```
1
```

**Sample Input 3:**
```
1
0
```
**Sample Output 3:**
```
0
```