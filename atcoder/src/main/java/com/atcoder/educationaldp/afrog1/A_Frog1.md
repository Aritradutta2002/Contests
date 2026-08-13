# A — Frog 1

### Problem Statement
There are N stones, numbered 1, 2, …, N. For each i (1 ≤ i ≤ N), the height of Stone i is h_i.

There is a frog who is initially on Stone 1. He will repeat the following action some number of times to reach Stone N:
- If the frog is currently on Stone i, jump to Stone i+1 or Stone i+2. A cost of |h_i − h_j| is incurred, where j is the stone to land on.

Find the minimum possible total cost incurred before the frog reaches Stone N.

### Constraints
- All values in input are integers.
- 2 ≤ N ≤ 10^5
- 1 ≤ h_i ≤ 10^4

### Input Format
```
N
h_1 h_2 … h_N
```

### Output
Print the minimum possible total cost incurred.

### Sample Test Cases

**Sample Input 1:**
```
4
10 30 40 20
```
**Sample Output 1:**
```
30
```
*Explanation:* Path 1 → 2 → 4 costs |10−30| + |30−20| = 30.

**Sample Input 2:**
```
2
10 10
```
**Sample Output 2:**
```
0
```

**Sample Input 3:**
```
6
30 10 60 10 60 50
```
**Sample Output 3:**
```
40
```
*Explanation:* Path 1 → 3 → 5 → 6 costs |30−60| + |60−60| + |60−50| = 40.