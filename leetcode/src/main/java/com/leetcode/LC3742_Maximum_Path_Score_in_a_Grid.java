package com.leetcode;

import java.util.*;

/**
 * 3742. Maximum Path Score in a Grid
 *
 * Problem Description:
 * You are given an m x n grid of integers (values 0, 1, or 2) and an integer k.
 * Starting at (0, 0) and moving only right or down to (m - 1, n - 1), choose a path
 * that maximizes the total score (sum of visited cell values) while visiting at most
 * k cells with value > 0. Return the maximum score, or -1 if no valid path exists.
 *
 * Constraints:
 * - 1 <= m, n
 * - 0 <= k
 * - grid[i][j] is in {0, 1, 2}
 * - grid[0][0] == 0
 * - Exact bounds are defined in the LeetCode problem statement.
 */

public class LC3742_Maximum_Path_Score_in_a_Grid {
    /**
     * Computes the maximum path score in the grid under the given constraint.
     *
     * @param grid The input grid.
     * @param k The maximum number of positive cells allowed on the path.
     * @return The maximum achievable score, or -1 if no valid path exists.
     */
    public int maxPathScore(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new int[n][m][k + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dp[i][j], Integer.MIN_VALUE);
            }
        }

        dp[0][0][0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int t = 0; t <= k; t++) {
                    // Skip already computed states
                    if (dp[i][j][t] != Integer.MIN_VALUE) continue;

                    int currentVal = grid[i][j];
                    int delta = (currentVal > 0) ? 1 : 0;
                    int requiredPrevT = t - delta;
                    if (requiredPrevT < 0) continue;

                    int maxPrev = Integer.MIN_VALUE;

                    // Check top cell (i-1, j)
                    if (i > 0 && dp[i-1][j][requiredPrevT] > maxPrev) {
                        maxPrev = dp[i-1][j][requiredPrevT];
                    }

                    // Check left cell (i, j-1)
                    if (j > 0 && dp[i][j-1][requiredPrevT] > maxPrev) {
                        maxPrev = dp[i][j-1][requiredPrevT];
                    }

                    if (maxPrev != Integer.MIN_VALUE) {
                        dp[i][j][t] = maxPrev + currentVal;
                    }
                }
            }
        }

        // Find maximum score at destination
        int maxScore = Integer.MIN_VALUE;
        for (int t = 0; t <= k; t++) {
            if (dp[n-1][m-1][t] > maxScore) {
                maxScore = dp[n-1][m-1][t];
            }
        }

        return (maxScore == Integer.MIN_VALUE) ? -1 : maxScore;
    }
}