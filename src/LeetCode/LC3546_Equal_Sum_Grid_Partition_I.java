package LeetCode;
import java.util.*;
/*
 * 3546. Equal Sum Grid Partition I
 *
 * Given an m x n grid of positive integers, determine whether a single
 * horizontal or vertical cut between rows or columns can split the grid
 * into two non-empty parts with equal sums.
 *
 * Constraints:
 * - 2 <= m, n <= 50
 * - 1 <= grid[i][j] <= 10^5
 */
public class LC3546_Equal_Sum_Grid_Partition_I {

    // Approach #1: Linear Scan
    // Build row/col prefix sums, then linearly scan for 'half'
    // Time: O(n*m), Space: O(n+m)
    public boolean canPartitionGrid(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        long[] rowPS = new long[n + 1]; // rowPS[i] = sum of rows 0..i-1
        long[] colPS = new long[m + 1]; // colPS[j] = sum of cols 0..j-1

        // rowPS[i+1] accumulates row i's total; colPS[j+1] accumulates col j's total
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                rowPS[i + 1] += grid[i][j];
                colPS[j + 1] += grid[i][j];
            }

        // Convert to cumulative prefix sums
        for (int i = 1; i <= n; i++) rowPS[i] += rowPS[i - 1];
        for (int j = 1; j <= m; j++) colPS[j] += colPS[j - 1];

        // If total is odd, no equal partition is possible
        long total = rowPS[n];
        if (total % 2 != 0) return false;
        long half = total / 2;

        // Horizontal cut after row i: check if sum of rows 0..i-1 == half
        for (int i = 1; i < n; i++)
            if (rowPS[i] == half) return true;
        // Vertical cut after col j: check if sum of cols 0..j-1 == half
        for (int j = 1; j < m; j++)
            if (colPS[j] == half) return true;

        return false;
    }

    // Approach #2: Binary Search for 'half'
    // Since all grid values are positive, prefix sums are strictly increasing.
    // Use binary search instead of linear scan to find 'half'.
    // Time: O(n*m), Space: O(n+m) — overall still dominated by prefix sum construction
    public boolean canPartitionGrid_BS(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        long[] rowPS = new long[n + 1];
        long[] colPS = new long[m + 1];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                rowPS[i + 1] += grid[i][j];
                colPS[j + 1] += grid[i][j];
            }

        for (int i = 1; i <= n; i++) rowPS[i] += rowPS[i - 1];
        for (int j = 1; j <= m; j++) colPS[j] += colPS[j - 1];

        long total = rowPS[n];
        if (total % 2 != 0) return false;
        long half = total / 2;

        // Search range [1, n) / [1, m) — exclude index 0 (sum is always 0)
        if (Arrays.binarySearch(rowPS, 1, n, half) >= 0) return true;
        if (Arrays.binarySearch(colPS, 1, m, half) >= 0) return true;

        return false;
    }

    public static void main(String[] args) {
        LC3546_Equal_Sum_Grid_Partition_I solver = new LC3546_Equal_Sum_Grid_Partition_I();

        int[][] grid1 = {{1, 2}, {2, 1}};
        int[][] grid2 = {{7, 3}, {2, 6}};
        int[][] grid3 = {{4, 5}, {6, 7}};

        // Approach #1: Linear Scan
        System.out.println("=== Approach #1: Linear Scan ===");
        runTest(solver, 1, grid1, true, 1);
        runTest(solver, 2, grid2, true, 1);
        runTest(solver, 3, grid3, false, 1);

        // Approach #2: Binary Search
        System.out.println("=== Approach #2: Binary Search ===");
        runTest(solver, 1, grid1, true, 2);
        runTest(solver, 2, grid2, true, 2);
        runTest(solver, 3, grid3, false, 2);
    }

    private static void runTest(LC3546_Equal_Sum_Grid_Partition_I solver, int testId, int[][] grid, boolean expected, int approach) {
        try {
            boolean result = approach == 1 ? solver.canPartitionGrid(grid) : solver.canPartitionGrid_BS(grid);
            if (result == expected) {
                System.out.println("Test " + testId + ": PASS");
            } else {
                System.out.println("Test " + testId + ": FAIL");
                System.out.println("  Expected: " + expected);
                System.out.println("  Actual:   " + result);
            }
        } catch (UnsupportedOperationException e) {
            System.out.println("Test " + testId + ": SKIPPED (Not implemented)");
        } catch (Exception e) {
            System.out.println("Test " + testId + ": ERROR (" + e.getMessage() + ")");
        }
    }
}
