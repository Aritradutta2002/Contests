# N — Slimes

### Problem Statement
There are N slimes in a row. Initially, the i-th slime has size a_i.

Taro combines all slimes into one. Each operation:
- Choose two adjacent slimes of sizes x and y, combine them into a new slime of size x+y at a cost of x+y.

Find the **minimum possible total cost**.

### Constraints
- All values in input are integers.
- 2 ≤ N ≤ 400
- 1 ≤ a_i ≤ 10^9

### Input Format
```
N
a_1 a_2 … a_N
```

### Output
Print the minimum possible total cost.

### Sample Test Cases

**Sample Input 1:**
```
4
10 20 30 40
```
**Sample Output 1:**
```
190
```

**Sample Input 2:**
```
5
10 10 10 10 10
```
**Sample Output 2:**
```
120
```

**Sample Input 3:**
```
3
1000000000 1000000000 1000000000
```
**Sample Output 3:**
```
5000000000
```

**Sample Input 4:**
```
6
7 6 8 6 1 1
```
**Sample Output 4:**
```
68
```