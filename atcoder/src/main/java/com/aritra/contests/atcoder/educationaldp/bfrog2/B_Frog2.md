# B — Frog 2

### Problem Statement
There are N stones, numbered 1, 2, …, N. For each i (1 ≤ i ≤ N), the height of Stone i is h_i.

There is a frog who is initially on Stone 1. He will repeat the following action some number of times to reach Stone N:
- If the frog is currently on Stone i, jump to one of the following: Stone i+1, i+2, …, i+K. A cost of |h_i − h_j| is incurred, where j is the stone to land on.

Find the minimum possible total cost incurred before the frog reaches Stone N.

### Constraints
- All values in input are integers.
- 2 ≤ N ≤ 10^5
- 1 ≤ K ≤ 100
- 1 ≤ h_i ≤ 10^4

### Input Format
```
N K
h_1 h_2 … h_N
```

### Output
Print the minimum possible total cost incurred.

### Sample Test Cases

**Sample Input 1:**
```
5 3
10 30 40 50 20
```
**Sample Output 1:**
```
30
```
*Explanation:* Path 1 → 2 → 5 costs |10−30| + |30−20| = 30.

**Sample Input 2:**
```
3 1
10 20 10
```
**Sample Output 2:**
```
20
```

**Sample Input 3:**
```
2 100
10 10
```
**Sample Output 3:**
```
0
```

**Sample Input 4:**
```
10 4
40 10 20 70 80 10 20 70 80 60
```
**Sample Output 4:**
```
40
```
*Explanation:* Path 1 → 4 → 8 → 10 costs |40−70| + |70−70| + |70−60| = 40.