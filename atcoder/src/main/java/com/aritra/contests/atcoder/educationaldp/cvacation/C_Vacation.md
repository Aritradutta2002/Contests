# C — Vacation

### Problem Statement
Taro's summer vacation consists of N days. For each day i (1 ≤ i ≤ N), Taro will choose one of the following activities:
- **A:** Swim in the sea. Gain a_i points of happiness.
- **B:** Catch bugs in the mountains. Gain b_i points of happiness.
- **C:** Do homework at home. Gain c_i points of happiness.

Taro cannot do the same activity for two or more **consecutive** days.

Find the maximum possible total happiness points.

### Constraints
- All values in input are integers.
- 1 ≤ N ≤ 10^5
- 1 ≤ a_i, b_i, c_i ≤ 10^4

### Input Format
```
N
a_1 b_1 c_1
a_2 b_2 c_2
...
a_N b_N c_N
```

### Output
Print the maximum possible total happiness.

### Sample Test Cases

**Sample Input 1:**
```
3
10 40 70
20 50 80
30 60 90
```
**Sample Output 1:**
```
210
```
*Explanation:* Activities in order C, B, C → 70 + 50 + 90 = 210.

**Sample Input 2:**
```
1
100 10 1
```
**Sample Output 2:**
```
100
```

**Sample Input 3:**
```
7
6 7 8
8 8 3
2 5 2
7 8 6
4 6 8
2 3 4
7 5 1
```
**Sample Output 3:**
```
46
```
*Explanation:* Activities in order C, A, B, A, C, B, A.