# J — Sushi

### Problem Statement
There are N dishes, numbered 1, 2, …, N. Initially, Dish i has a_i (1 ≤ a_i ≤ 3) pieces of sushi.

Taro repeatedly rolls a die showing numbers 1, 2, …, N with equal probability. If the outcome is i and Dish i has sushi, eat one piece; otherwise do nothing.

Find the **expected number of operations** until all sushi is eaten.

### Constraints
- All values in input are integers.
- 1 ≤ N ≤ 300
- 1 ≤ a_i ≤ 3

### Input Format
```
N
a_1 a_2 … a_N
```

### Output
Print the expected number of operations. Relative error ≤ 10^-9 is accepted.

### Sample Test Cases

**Sample Input 1:**
```
3
1 1 1
```
**Sample Output 1:**
```
5.5
```

**Sample Input 2:**
```
1
3
```
**Sample Output 2:**
```
3
```

**Sample Input 3:**
```
2
1 2
```
**Sample Output 3:**
```
4.5
```

**Sample Input 4:**
```
10
1 3 2 3 3 2 3 2 1 3
```
**Sample Output 4:**
```
54.48064457488221
```