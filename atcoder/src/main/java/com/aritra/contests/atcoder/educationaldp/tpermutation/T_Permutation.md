# T — Permutation

### Problem Statement
Let N be a positive integer. You are given a string s of length N−1, consisting of `<` and `>`.

Find the number of permutations (p_1, p_2, …, p_N) of (1, 2, …, N) satisfying:
- For each i (1 ≤ i ≤ N−1): p_i < p_{i+1} if s[i] = `<`, and p_i > p_{i+1} if s[i] = `>`

Modulo 10^9+7.

### Constraints
- 2 ≤ N ≤ 3000
- s is a string of length N−1 consisting of `<` and `>`.

### Input Format
```
N
s
```

### Output
Print the number of valid permutations, modulo 10^9+7.

### Sample Test Cases

**Sample Input 1:**
```
4
<><
```
**Sample Output 1:**
```
5
```
*Valid: (1,3,2,4), (1,4,2,3), (2,3,1,4), (2,4,1,3), (3,4,1,2)*

**Sample Input 2:**
```
5
<<<<
```
**Sample Output 2:**
```
1
```

**Sample Input 3:**
```
20
>>>><>>><>><>>><<>>
```
**Sample Output 3:**
```
217136290
```