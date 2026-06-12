# P — Independent Set

### Problem Statement
There is a tree with N vertices. Taro paints each vertex **white or black** with the constraint that **no two adjacent vertices are both black**.

Find the number of valid coloring ways, modulo 10^9+7.

### Constraints
- All values in input are integers.
- 1 ≤ N ≤ 10^5
- The given graph is a tree.

### Input Format
```
N
x_1 y_1
x_2 y_2
...
x_{N-1} y_{N-1}
```

### Output
Print the number of valid colorings, modulo 10^9+7.

### Sample Test Cases

**Sample Input 1:**
```
3
1 2
2 3
```
**Sample Output 1:**
```
5
```

**Sample Input 2:**
```
4
1 2
1 3
1 4
```
**Sample Output 2:**
```
9
```

**Sample Input 3:**
```
1

```
**Sample Output 3:**
```
2
```

**Sample Input 4:**
```
10
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
157
```