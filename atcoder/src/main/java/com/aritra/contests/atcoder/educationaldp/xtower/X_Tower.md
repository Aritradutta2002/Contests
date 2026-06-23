# X — Tower

### Problem Statement
There are N blocks, numbered 1, 2, …, N. Block i has weight w_i, solidness s_i, and value v_i.

Taro builds a tower by stacking some blocks vertically. Condition:
- For each block i in the tower, the **sum of weights of blocks above it** must be ≤ s_i.

Find the **maximum possible sum of values**.

### Constraints
- All values in input are integers.
- 1 ≤ N ≤ 10^3
- 1 ≤ w_i, s_i ≤ 10^4
- 1 ≤ v_i ≤ 10^9

### Input Format
```
N
w_1 s_1 v_1
w_2 s_2 v_2
...
w_N s_N v_N
```

### Output
Print the maximum possible sum of values.

### Sample Test Cases

**Sample Input 1:**
```
3
2 2 20
2 1 30
3 1 40
```
**Sample Output 1:**
```
50
```
*Stack Blocks 2, 1 (top to bottom): total value = 30 + 20 = 50.*

**Sample Input 2:**
```
4
1 2 10
3 1 10
2 4 10
1 6 10
```
**Sample Output 2:**
```
40
```

**Sample Input 3:**
```
5
1 10000 1000000000
1 10000 1000000000
1 10000 1000000000
1 10000 1000000000
1 10000 1000000000
```
**Sample Output 3:**
```
5000000000
```

**Sample Input 4:**
```
8
9 5 7
6 2 7
5 7 3
7 8 8
8 1 9
6 3 3
3 4 1
7 4 5
```
**Sample Output 4:**
```
22
```