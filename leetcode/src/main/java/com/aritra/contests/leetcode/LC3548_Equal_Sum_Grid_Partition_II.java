package com.aritra.contests.leetcode;
import java.util.*;
/*
 * 3548. Equal Sum Grid Partition II
 * 
 * You are given an m x n matrix grid of positive integers. Your task is to determine if it is possible to make either one horizontal or one vertical cut on the grid such that:
 * 1. Each of the two resulting sections formed by the cut is non-empty.
 * 2. The sum of elements in both sections is equal, or can be made equal by discounting at most one single cell in total (from either section).
 * 3. If a cell is discounted, the rest of the section must remain connected.
 * 
 * Constraints:
 * - m == grid.length
 * - n == grid[i].length
 * - 1 <= m, n <= 1000
 * - 1 <= grid[i][j] <= 10^6
 */
public class LC3548_Equal_Sum_Grid_Partition_II {
    public boolean canPartitionGrid(int[][] grid) {
        return check(grid) || check(rotate(grid));
    }

    private boolean check(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long topOrLeftSum = 0L;
        long bottomOrRightSum = 0L;
        Map<Long, Integer> seen = new HashMap<>();
        Map<Long, Integer> remaining = new HashMap<>();

        for (int[] row : grid) {
            for (int value : row) {
                long current = value;
                bottomOrRightSum += current;
                remaining.merge(current, 1, Integer::sum);
            }
        }

        for (int cut = 0; cut < m - 1; cut++) {
            for (int value : grid[cut]) {
                long current = value;
                topOrLeftSum += current;
                bottomOrRightSum -= current;
                seen.merge(current, 1, Integer::sum);
                remaining.merge(current, -1, Integer::sum);
            }

            if (topOrLeftSum == bottomOrRightSum) {
                return true;
            }

            if (topOrLeftSum < bottomOrRightSum) {
                long diff = bottomOrRightSum - topOrLeftSum;
                if (remaining.getOrDefault(diff, 0) > 0 && canRemoveFromLowerOrRight(grid, cut, n, diff)) {
                    return true;
                }
            } else {
                long diff = topOrLeftSum - bottomOrRightSum;
                if (seen.getOrDefault(diff, 0) > 0 && canRemoveFromUpperOrLeft(grid, cut, n, diff)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean canRemoveFromLowerOrRight(int[][] grid, int cut, int n, long diff) {
        int lowerRows = grid.length - cut - 1;
        if (lowerRows > 1 && n > 1) {
            return true;
        }
        if (cut == grid.length - 2) {
            return grid[cut + 1][0] == diff || grid[cut + 1][n - 1] == diff;
        }
        if (n == 1) {
            return grid[cut + 1][0] == diff || grid[grid.length - 1][0] == diff;
        }
        return false;
    }

    private boolean canRemoveFromUpperOrLeft(int[][] grid, int cut, int n, long diff) {
        int upperRows = cut + 1;
        if (upperRows > 1 && n > 1) {
            return true;
        }
        if (cut == 0) {
            return grid[0][0] == diff || grid[0][n - 1] == diff;
        }
        if (n == 1) {
            return grid[0][0] == diff || grid[cut][0] == diff;
        }
        return false;
    }

    private int[][] rotate(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] rotated = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][i] = grid[i][j];
            }
        }
        return rotated;
    }

    public static void main(String[] args) {
        LC3548_Equal_Sum_Grid_Partition_II solver = new LC3548_Equal_Sum_Grid_Partition_II();
        Scanner sc = new Scanner(System.in);

        // Test Case 1
        int[][] grid1 = {{1, 4}, {2, 3}};
        runTest(solver, 1, grid1, true);

        // Test Case 2
        int[][] grid2 = {{1, 2}, {3, 4}};
        runTest(solver, 2, grid2, true);

        // Test Case 3
        int[][] grid3 = {{1, 2, 4}, {2, 3, 5}};
        runTest(solver, 3, grid3, false);

        sc.close();
    }

    private static void runTest(LC3548_Equal_Sum_Grid_Partition_II solver, int testId, int[][] grid, boolean expected) {
        try {
            boolean result = solver.canPartitionGrid(grid);
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
