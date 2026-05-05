package LeetCode;
import java.util.*;
/**
 * 64. Minimum Path Sum
 *
 * Given an m x n grid filled with non-negative numbers, find a path from the
 * top-left corner to the bottom-right corner that minimizes the sum of all
 * numbers along the path. You can only move either right or down at each step.
 *
 * Constraints:
 * - m == grid.length
 * - n == grid[i].length
 * - 1 <= m, n <= 200
 * - 0 <= grid[i][j] <= 200
 *
 * Example 1:
 * Input:  grid = [[1,3,1],[1,5,1],[4,2,1]]
 * Output: 7
 * Explanation: Path 1 → 3 → 1 → 1 → 1 gives the minimum sum.
 *
 * Example 2:
 * Input:  grid = [[1,2,3],[4,5,6]]
 * Output: 12
 */
class LC64_Minimum_Path_Sum {

    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];

        dp[0][0] = grid[0][0];

        for (int j = 1; j < m; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[n - 1][m - 1];
    }


    public static void main(String[] args) {
        LC64_Minimum_Path_Sum solution = new LC64_Minimum_Path_Sum();

        // Test 1: standard 3x3 grid
        try {
            int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
            int expected = 7;
            int result = solution.minPathSum(grid);
            if (result == expected) {
                System.out.println("Test 1: PASS");
            } else {
                System.out.println("Test 1: FAIL");
                System.out.println("  Expected: " + expected);
                System.out.println("  Got:      " + result);
            }
        } catch (UnsupportedOperationException e) {
            System.out.println("Test 1: SKIPPED");
        }

        // Test 2: 2x3 grid
        try {
            int[][] grid = {{1, 2, 3}, {4, 5, 6}};
            int expected = 12;
            int result = solution.minPathSum(grid);
            if (result == expected) {
                System.out.println("Test 2: PASS");
            } else {
                System.out.println("Test 2: FAIL");
                System.out.println("  Expected: " + expected);
                System.out.println("  Got:      " + result);
            }
        } catch (UnsupportedOperationException e) {
            System.out.println("Test 2: SKIPPED");
        }

        // Test 3: single cell
        try {
            int[][] grid = {{5}};
            int expected = 5;
            int result = solution.minPathSum(grid);
            if (result == expected) {
                System.out.println("Test 3: PASS");
            } else {
                System.out.println("Test 3: FAIL");
                System.out.println("  Expected: " + expected);
                System.out.println("  Got:      " + result);
            }
        } catch (UnsupportedOperationException e) {
            System.out.println("Test 3: SKIPPED");
        }

        // Test 4: single row
        try {
            int[][] grid = {{1, 2, 5}};
            int expected = 8;
            int result = solution.minPathSum(grid);
            if (result == expected) {
                System.out.println("Test 4: PASS");
            } else {
                System.out.println("Test 4: FAIL");
                System.out.println("  Expected: " + expected);
                System.out.println("  Got:      " + result);
            }
        } catch (UnsupportedOperationException e) {
            System.out.println("Test 4: SKIPPED");
        }
    }

}
