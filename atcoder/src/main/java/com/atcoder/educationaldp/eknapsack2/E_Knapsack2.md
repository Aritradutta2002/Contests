# E — Knapsack 2

### Problem Statement
Same as Knapsack 1 but with different constraints — W can be very large while values are small.

There are N items. Item i has weight w_i and value v_i. Knapsack capacity is W.

Find the maximum possible sum of values.

### Constraints
- All values in input are integers.
- 1 ≤ N ≤ 100
- 1 ≤ W ≤ 10^9
- 1 ≤ w_i ≤ W
- 1 ≤ v_i ≤ 10^3

### Input Format
```
N W
w_1 v_1
w_2 v_2
...
w_N v_N
```

### Output
Print the maximum possible sum of values.

### Sample Test Cases

**Sample Input 1:**
```
3 8
3 30
4 50
5 60
```
**Sample Output 1:**
```
90
```

**Sample Input 2:**
```
1 1000000000
1000000000 10
```
**Sample Output 2:**
```
10
```

**Sample Input 3:**
```
6 15
6 5
5 6
6 4
6 6
3 5
7 2
```
**Sample Output 3:**
```
17
```