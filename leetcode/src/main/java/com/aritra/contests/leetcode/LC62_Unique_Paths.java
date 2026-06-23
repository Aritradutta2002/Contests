package com.aritra.contests.leetcode;

/*
 * 62. Unique Paths
 *
 * There is a robot on an m x n grid. The robot can only move down or right at any point. Count how
 * many unique paths the robot can take from the top-left corner to the bottom-right corner.
 *
 * Constraints:
 * - 1 <= m, n <= 100
 */
public class LC62_Unique_Paths {
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
