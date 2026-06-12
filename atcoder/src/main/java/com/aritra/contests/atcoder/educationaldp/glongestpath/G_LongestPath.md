# G — Longest Path

### Problem Statement
There is a directed graph G with N vertices and M edges. The graph **does not contain directed cycles** (DAG).

Find the length of the longest directed path in G. The length of a path is the number of edges in it.

### Constraints
- All values in input are integers.
- 2 ≤ N ≤ 10^5
- 1 ≤ M ≤ 10^5
- 1 ≤ x_i, y_i ≤ N
- All pairs (x_i, y_i) are distinct.
- G does not contain directed cycles.

### Input Format
```
N M
x_1 y_1
x_2 y_2
...
x_M y_M
```

### Output
Print the length of the longest directed path.

### Sample Test Cases

**Sample Input 1:**
```
4 5
1 2
1 3
3 2
2 4
3 4
```
**Sample Output 1:**
```
3
```

**Sample Input 2:**
```
6 3
2 3
4 5
5 6
```
**Sample Output 2:**
```
2
```

**Sample Input 3:**
```
5 8
5 3
2 3
2 4
5 2
5 1
1 4
4 3
1 3
```
**Sample Output 3:**
```
3
```