# L — Deque

### Problem Statement
Taro and Jiro play a game with a sequence a = (a_1, a_2, …, a_N). They alternate turns (Taro first). Each turn:
- Remove the element at the **beginning** or **end** of a. The player earns x points where x is the removed element.

Let X and Y be Taro's and Jiro's total scores. Taro tries to maximize X−Y; Jiro tries to minimize X−Y.

Find the resulting value of X−Y with optimal play.

### Constraints
- All values in input are integers.
- 1 ≤ N ≤ 3000
- 1 ≤ a_i ≤ 10^9

### Input Format
```
N
a_1 a_2 … a_N
```

### Output
Print the resulting value of X−Y.

### Sample Test Cases

**Sample Input 1:**
```
4
10 80 90 30
```
**Sample Output 1:**
```
10
```

**Sample Input 2:**
```
3
10 100 10
```
**Sample Output 2:**
```
-80
```

**Sample Input 3:**
```
1
10
```
**Sample Output 3:**
```
10
```

**Sample Input 4:**
```
10
1000000000 1 1000000000 1 1000000000 1 1000000000 1 1000000000 1
```
**Sample Output 4:**
```
4999999995
```

**Sample Input 5:**
```
6
4 2 9 7 1 5
```
**Sample Output 5:**
```
2
```