# K — Stones

### Problem Statement
There is a set A = {a_1, a_2, …, a_N} of N positive integers. Taro and Jiro play a game with a pile of K stones. They alternate turns (Taro goes first):
- On each turn, choose an element x in A and remove exactly x stones from the pile.

A player loses when they cannot make a move. Assuming optimal play, determine the winner.

### Constraints
- All values in input are integers.
- 1 ≤ N ≤ 100
- 1 ≤ K ≤ 10^5
- 1 ≤ a_1 < a_2 < … < a_N ≤ K

### Input Format
```
N K
a_1 a_2 … a_N
```

### Output
If Taro wins, print `First`; if Jiro wins, print `Second`.

### Sample Test Cases

**Sample Input 1:**
```
2 4
2 3
```
**Sample Output 1:**
```
First
```

**Sample Input 2:**
```
2 5
2 3
```
**Sample Output 2:**
```
Second
```

**Sample Input 3:**
```
2 7
2 3
```
**Sample Output 3:**
```
First
```

**Sample Input 4:**
```
3 20
1 2 3
```
**Sample Output 4:**
```
Second
```

**Sample Input 5:**
```
3 21
1 2 3
```
**Sample Output 5:**
```
First
```

**Sample Input 6:**
```
1 100000
1
```
**Sample Output 6:**
```
Second
```