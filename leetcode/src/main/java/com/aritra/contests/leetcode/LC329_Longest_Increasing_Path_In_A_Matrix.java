package com.aritra.contests.leetcode;
import java.util.*;
/*
 * Problem 329. Longest Increasing Path in a Matrix
 *
 * Description:
 *   Given an m x n integers matrix, return the length of the longest
 *   increasing path in the matrix.
 *
 *   From each cell, you can move in four directions: left, right, up, or
 *   down. You may NOT move diagonally or move outside the boundary.
 *   You may NOT move to a cell with an equal or smaller value (strictly
 *   increasing only).
 *
 * Constraints:
 *   - m == matrix.length
 *   - n == matrix[i].length
 *   - 1 <= m, n <= 200
 *   - 0 <= matrix[i][j] <= 2^31 - 1
 *
 * Input:  int[][] matrix
 * Output: int  (length of the longest strictly increasing path)
 */
public class LC329_Longest_Increasing_Path_In_A_Matrix {
    // -------------------------------------------------------------------------
    // LeetCode method (to be implemented)
    // -------------------------------------------------------------------------
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] memo = new int[n][m];
        int longestPath = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int path = dfs(matrix, memo, n, m, i, j);
                longestPath = Math.max(longestPath, path);
            }
        }
        return longestPath;
    }
    public int dfs(int[][] matrix, int[][] memo, int n, int m, int i, int j) {
        if(memo[i][j] > 0) return memo[i][j];
        int path = 0;
        int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        for (int[] d : dir) {
            int x = i + d[0];
            int y = j + d[1];
            if (x >= 0 && x < n && y >= 0 && y < m && matrix[x][y] > matrix[i][j]) {
                path = Math.max(path, dfs(matrix, memo, n, m, x, y));
            }
        }
        memo[i][j] = path + 1;
        return path + 1;
    }

    // -------------------------------------------------------------------------
    // Test harness
    // -------------------------------------------------------------------------
    private static void runTest(String label, int[][] matrix, int expected) {
        LC329_Longest_Increasing_Path_In_A_Matrix solver = new LC329_Longest_Increasing_Path_In_A_Matrix();
        try {
            int result = solver.longestIncreasingPath(matrix);
            System.out.println(label + ": " + (result == expected ? "PASS" : "FAIL")
                    + " (expected=" + expected + ", got=" + result + ")");
        } catch (UnsupportedOperationException e) {
            System.out.println(label + ": SKIPPED");
        }
    }
}
