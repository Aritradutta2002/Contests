# Y — Grid 2

### Problem Statement
There is a grid with H rows and W columns. N specific squares are **wall squares**; the others are empty. Squares (1,1) and (H,W) are guaranteed to be empty.

Taro starts from (1,1) and reaches (H,W) by moving **right** or **down** to an adjacent empty square.

Find the number of paths, modulo 10^9+7.

*(Note: Unlike Grid 1, H, W can be up to 10^5, so a direct DP over the grid is infeasible — inclusion-exclusion over wall squares is needed.)*

### Constraints
- All values in input are integers.
- 2 ≤ H, W ≤ 10^5
- 1 ≤ N ≤ 3000
- Squares (1,1) and (H,W) are empty.

### Input Format
```
H W N
r_1 c_1
r_2 c_2
...
r_N c_N
```

### Output
Print the number of paths, modulo 10^9+7.

### Sample Test Cases

**Sample Input 1:**
```
3 4 2
2 2
1 4
```
**Sample Output 1:**
```
3
```

**Sample Input 2:**
```
5 2 2
2 1
4 2
```
**Sample Output 2:**
```
0
```

**Sample Input 3:**
```
5 5 4
3 1
3 5
1 3
5 3
```
**Sample Output 3:**
```
24
```

**Sample Input 4:**
```
100000 100000 1
50000 50000
```
**Sample Output 4:**
```
123445622
```