package com.leetcode;

import java.util.Arrays;

/*
 * 1886. Determine Whether Matrix Can Be Obtained By Rotation
 *
 * Given two n x n binary matrices mat and target, return true if mat can be made equal
 * to target by rotating mat in 90-degree increments (any number of times), or false otherwise.
 *
 * Constraints:
 *   n == mat.length == target.length
 *   n == mat[i].length == target[i].length
 *   1 <= n <= 10
 *   mat[i][j] and target[i][j] are 0 or 1
 *
 * Example 1:
 *   mat = [[0,1],[1,0]], target = [[1,0],[0,1]] -> true
 * Example 2:
 *   mat = [[0,1],[1,1]], target = [[1,0],[0,1]] -> false
 * Example 3:
 *   mat = [[0,0,0],[0,1,0],[1,1,1]], target = [[1,1,1],[0,1,0],[0,0,0]] -> true
 */

public class LC1886_Determine_Whether_Matrix_Can_Be_Obtained_By_Rotation {
    public boolean findRotation(int[][] mat, int[][] target) {
        int[][] cur = mat;
        for (int k = 0; k < 4; k++) {
            if (same(cur, target)) {
                return true;
            }
            cur = rotate90Clockwise(cur);
        }
        return false;
    }
    private static boolean same(int[][] a, int[][] b) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] != b[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    private static int[][] rotate90Clockwise(int[][] in) {
        int n = in.length;
        int[][] out = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                out[j][n - 1 - i] = in[i][j];
            }
        }
        return out;
    }
}
