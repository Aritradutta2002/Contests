package com.aritra.contests.leetcode;

/*
 * 63. Unique Paths II
 *
 * A robot is located at the top-left corner of an m x n grid. The robot can only move down or right.
 * The grid may contain obstacles (1). Count unique paths from top-left to bottom-right avoiding
 * obstacles.
 *
 * Constraints:
 * - 1 <= m, n <= 100
 * - obstacleGrid[i][j] is 0 or 1
 */
public class LC63_Unique_Paths_II {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }

        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    if (i > 0) dp[i][j] += dp[i - 1][j];
                    if (j > 0) dp[i][j] += dp[i][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}