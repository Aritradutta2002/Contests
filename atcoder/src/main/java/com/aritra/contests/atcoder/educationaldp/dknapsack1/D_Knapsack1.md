# D — Knapsack 1

### Problem Statement
There are N items, numbered 1, 2, …, N. For each i (1 ≤ i ≤ N), Item i has a weight of w_i and a value of v_i.

Taro has decided to choose some of the N items to carry in a knapsack of capacity W (sum of weights ≤ W).

Find the maximum possible sum of values.

### Constraints
- All values in input are integers.
- 1 ≤ N ≤ 100
- 1 ≤ W ≤ 10^5
- 1 ≤ w_i ≤ W
- 1 ≤ v_i ≤ 10^9

### Input Format
```
N W
w_1 v_1
w_2 v_2
...
w_N v_N
```

### Output
Print the maximum possible sum of values.

### Sample Test Cases

**Sample Input 1:**
```
3 8
3 30
4 50
5 60
```
**Sample Output 1:**
```
90
```
*Explanation:* Items 1 and 3: weight = 3+5 = 8, value = 30+60 = 90.

**Sample Input 2:**
```
5 5
1 1000000000
1 1000000000
1 1000000000
1 1000000000
1 1000000000
```
**Sample Output 2:**
```
5000000000
```

**Sample Input 3:**
```
6 15
6 5
5 6
6 4
6 6
3 5
7 2
```
**Sample Output 3:**
```
17
```
*Explanation:* Items 2, 4, 5: weights 5+6+3=14, values 6+6+5=17.