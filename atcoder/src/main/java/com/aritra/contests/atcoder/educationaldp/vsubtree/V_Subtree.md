# V — Subtree

### Problem Statement
There is a tree with N vertices. Taro paints each vertex black or white so that **all black vertices form a connected subtree** (i.e., any black vertex is reachable from any other black vertex through only black vertices).

Given a positive integer M, for each vertex v (1 ≤ v ≤ N), find the number of valid colorings where **vertex v must be black**, modulo M.

### Constraints
- All values in input are integers.
- 1 ≤ N ≤ 10^5
- 2 ≤ M ≤ 10^9
- The given graph is a tree.

### Input Format
```
N M
x_1 y_1
...
x_{N-1} y_{N-1}
```

### Output
Print N lines. The v-th line is the answer for vertex v.

### Sample Test Cases

**Sample Input 1:**
```
3 100
1 2
2 3
```
**Sample Output 1:**
```
3
4
3
```

**Sample Input 2:**
```
4 100
1 2
1 3
1 4
```
**Sample Output 2:**
```
8
5
5
5
```

**Sample Input 3:**
```
1 100

```
**Sample Output 3:**
```
1
```

**Sample Input 4:**
```
10 2
8 5
10 8
6 5
1 5
4 8
2 10
3 6
9 2
1 7
```
**Sample Output 4:**
```
0
0
1
1
1
0
1
0
1
1
```