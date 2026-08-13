# Z — Frog 3

### Problem Statement
There are N stones, numbered 1, 2, …, N. The height of Stone i is h_i with h_1 < h_2 < … < h_N.

There is a frog initially on Stone 1. Each action:
- From Stone i, jump to any Stone j (i < j ≤ N) at a cost of (h_j − h_i)^2 + C.

Find the **minimum possible total cost** to reach Stone N.

*(This problem requires the Convex Hull Trick / Slope Trick optimization.)*

### Constraints
- All values in input are integers.
- 2 ≤ N ≤ 2×10^5
- 1 ≤ C ≤ 10^12
- 1 ≤ h_1 < h_2 < … < h_N ≤ 10^6

### Input Format
```
N C
h_1 h_2 … h_N
```

### Output
Print the minimum possible total cost.

### Sample Test Cases

**Sample Input 1:**
```
5 6
1 2 3 4 5
```
**Sample Output 1:**
```
20
```
*Path 1 → 3 → 5: ((3-1)^2 + 6) + ((5-3)^2 + 6) = 20.*

**Sample Input 2:**
```
2 1000000000000
500000 1000000
```
**Sample Output 2:**
```
1250000000000
```

**Sample Input 3:**
```
8 5
1 3 4 5 10 11 12 13
```
**Sample Output 3:**
```
62
```
*Path 1 → 2 → 4 → 5 → 8: (4+5) + (4+5) + (25+5) + (9+5) = 62.*