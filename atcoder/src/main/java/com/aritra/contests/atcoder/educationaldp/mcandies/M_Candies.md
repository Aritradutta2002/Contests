# M — Candies

### Problem Statement
There are N children, numbered 1, 2, …, N. They share K candies among themselves. Child i must receive between 0 and a_i candies (inclusive). No candies should be left over.

Find the number of ways to share candies, modulo 10^9+7.

### Constraints
- All values in input are integers.
- 1 ≤ N ≤ 100
- 0 ≤ K ≤ 10^5
- 0 ≤ a_i ≤ K

### Input Format
```
N K
a_1 a_2 … a_N
```

### Output
Print the number of ways, modulo 10^9+7.

### Sample Test Cases

**Sample Input 1:**
```
3 4
1 2 3
```
**Sample Output 1:**
```
5
```
*Ways: (0,1,3), (0,2,2), (1,0,3), (1,1,2), (1,2,1)*

**Sample Input 2:**
```
1 10
9
```
**Sample Output 2:**
```
0
```

**Sample Input 3:**
```
2 0
0 0
```
**Sample Output 3:**
```
1
```

**Sample Input 4:**
```
4 100000
100000 100000 100000 100000
```
**Sample Output 4:**
```
665683269
```