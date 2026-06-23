# I — Coins

### Problem Statement
Let N be a positive **odd** number. There are N coins, numbered 1, 2, …, N. Coin i comes up heads with probability p_i and tails with probability 1 − p_i.

Taro has tossed all N coins. Find the probability of having **more heads than tails**.

### Constraints
- N is an odd number.
- 1 ≤ N ≤ 2999
- p_i is a real number with two decimal places.
- 0 < p_i < 1

### Input Format
```
N
p_1 p_2 … p_N
```

### Output
Print the probability of having more heads than tails. Absolute error ≤ 10^-9 is accepted.

### Sample Test Cases

**Sample Input 1:**
```
3
0.30 0.60 0.80
```
**Sample Output 1:**
```
0.612
```

**Sample Input 2:**
```
1
0.50
```
**Sample Output 2:**
```
0.5
```

**Sample Input 3:**
```
5
0.42 0.01 0.42 0.99 0.42
```
**Sample Output 3:**
```
0.3821815872
```