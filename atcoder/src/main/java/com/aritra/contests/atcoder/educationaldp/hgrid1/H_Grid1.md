# H — Grid 1

### Problem Statement
There is a grid with H rows and W columns. Square (i, j) is either `.` (empty) or `#` (wall). Squares (1,1) and (H,W) are guaranteed to be empty.

Taro starts from (1,1) and reaches (H,W) by repeatedly moving **right** or **down** to an adjacent empty square.

Find the number of paths from (1,1) to (H,W), modulo 10^9+7.

### Constraints
- 2 ≤ H, W ≤ 1000
- a_i,j is `.` or `#`.
- Squares (1,1) and (H,W) are empty.

### Input Format
```
H W
a_1,1 a_1,2 ... a_1,W
...
a_H,1 a_H,2 ... a_H,W
```

### Output
Print the number of paths, modulo 10^9+7.

### Sample Test Cases

**Sample Input 1:**
```
3 4
...#
.#..
....
```
**Sample Output 1:**
```
3
```

**Sample Input 2:**
```
5 2
..
#.
..
.#
..
```
**Sample Output 2:**
```
0
```

**Sample Input 3:**
```
5 5
..#..
.....
#...#
.....
..#..
```
**Sample Output 3:**
```
24
```

**Sample Input 4:**
```
20 20
....................
....................
....................
....................
....................
....................
....................
....................
....................
....................
....................
....................
....................
....................
....................
....................
....................
....................
....................
```
**Sample Output 4:**
```
345263555
```