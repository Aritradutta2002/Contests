# R — Walk

### Problem Statement
There is a simple directed graph G with N vertices. a_{i,j} = 1 means there is a directed edge from vertex i to j; otherwise 0.

Find the **number of different directed paths of length K** in G, modulo 10^9+7. A path that traverses the same edge multiple times is also counted.

### Constraints
- All values in input are integers.
- 1 ≤ N ≤ 50
- 1 ≤ K ≤ 10^18
- a_{i,j} is 0 or 1; a_{i,i} = 0

### Input Format
```
N K
a_1,1 … a_1,N
...
a_N,1 … a_N,N
```

### Output
Print the number of directed paths of length K, modulo 10^9+7.

### Sample Test Cases

**Sample Input 1:**
```
4 2
0 1 0 0
0 0 1 1
0 0 0 1
1 0 0 0
```
**Sample Output 1:**
```
6
```

**Sample Input 2:**
```
3 3
0 1 0
1 0 1
0 0 0
```
**Sample Output 2:**
```
3
```

**Sample Input 3:**
```
6 2
0 0 0 0 0 0
0 0 1 0 0 0
0 0 0 0 0 0
0 0 0 0 1 0
0 0 0 0 0 1
0 0 0 0 0 0
```
**Sample Output 3:**
```
1
```

**Sample Input 4:**
```
1 1
0
```
**Sample Output 4:**
```
0
```