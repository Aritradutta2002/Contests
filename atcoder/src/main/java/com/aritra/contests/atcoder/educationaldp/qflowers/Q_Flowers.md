# Q — Flowers

### Problem Statement
There are N flowers in a row. Flower i (from the left) has height h_i and beauty a_i. All heights are distinct.

Taro removes some flowers so that the heights of the **remaining flowers are monotonically increasing** from left to right.

Find the **maximum possible sum of beauties** of the remaining flowers.

### Constraints
- All values in input are integers.
- 1 ≤ N ≤ 2×10^5
- 1 ≤ h_i ≤ N (all distinct)
- 1 ≤ a_i ≤ 10^9

### Input Format
```
N
h_1 h_2 … h_N
a_1 a_2 … a_N
```

### Output
Print the maximum possible total beauty.

### Sample Test Cases

**Sample Input 1:**
```
4
3 1 4 2
10 20 30 40
```
**Sample Output 1:**
```
60
```
*Keep flowers 2 and 4 (heights 1, 2): beauty = 20 + 40 = 60.*

**Sample Input 2:**
```
1
1
10
```
**Sample Output 2:**
```
10
```

**Sample Input 3:**
```
5
1 2 3 4 5
1000000000 1000000000 1000000000 1000000000 1000000000
```
**Sample Output 3:**
```
5000000000
```

**Sample Input 4:**
```
9
4 2 5 8 3 6 1 7 9
6 8 8 4 6 3 5 7 5
```
**Sample Output 4:**
```
31
```