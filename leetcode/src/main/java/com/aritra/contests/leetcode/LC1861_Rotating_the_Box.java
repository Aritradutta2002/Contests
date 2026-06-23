package com.aritra.contests.leetcode;
import java.util.*;
/**
 * 1861. Rotating the Box
 * Given an m x n matrix boxGrid (side-view of a box):
 *   - '#' = stone
 *   - '*' = stationary obstacle
 *   - '.' = empty
 * The box is rotated 90 degrees clockwise, then stones fall down due to gravity
 * until they land on an obstacle, another stone, or bottom. Obstacles do not move.
 * Return the n x m rotated matrix after stones settle.
 *
 * Constraints:
 *   m == boxGrid.length, n == boxGrid[i].length
 *   1 <= m, n <= 500
 *   boxGrid[i][j] is '#', '*', or '.'.
 */
public class LC1861_Rotating_the_Box {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length, n = boxGrid[0].length;

        for (char[] row : boxGrid) {
            int empty = n - 1;
            for (int col = n - 1; col >= 0; col--) {
                if (row[col] == '*') {
                    empty = col - 1;
                } else if (row[col] == '#') {
                    row[col] = '.';
                    row[empty] = '#';
                    empty--;
                }
            }
        }

        char[][] result = new char[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[j][m - i - 1] = boxGrid[i][j];
            }
        }

        return result;
    }
}
