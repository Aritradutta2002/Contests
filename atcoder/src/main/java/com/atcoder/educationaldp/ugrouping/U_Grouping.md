# U — Grouping

### Problem Statement
There are N rabbits, numbered 1, 2, …, N. The compatibility of Rabbit i and j is a_{i,j} (symmetric, a_{i,i} = 0, can be negative).

Taro divides the N rabbits into groups (each rabbit in exactly one group). For each pair (i, j) in the same group with i < j, Taro earns a_{i,j} points.

Find **Taro's maximum possible total score**.

### Constraints
- All values in input are integers.
- 1 ≤ N ≤ 16
- |a_{i,j}| ≤ 10^9
- a_{i,i} = 0; a_{i,j} = a_{j,i}

### Input Format
```
N
a_1,1 … a_1,N
...
a_N,1 … a_N,N
```

### Output
Print the maximum possible total score.

### Sample Test Cases

**Sample Input 1:**
```
3
0 10 20
10 0 -100
20 -100 0
```
**Sample Output 1:**
```
20
```
*Groups: {1,3}, {2}*

**Sample Input 2:**
```
2
0 -10
-10 0
```
**Sample Output 2:**
```
0
```
*Groups: {1}, {2}*

**Sample Input 3:**
```
4
0 1000000000 1000000000 1000000000
1000000000 0 1000000000 1000000000
1000000000 1000000000 0 -1
1000000000 1000000000 -1 0
```
**Sample Output 3:**
```
4999999999
```