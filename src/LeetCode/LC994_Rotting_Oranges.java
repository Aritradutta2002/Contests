package LeetCode;
import java.util.*;
/*
 * 994. Rotting Oranges
 * 
 * You are given an m x n grid where each cell can have one of three values:
 * - 0 representing an empty cell,
 * - 1 representing a fresh orange, or
 * - 2 representing a rotten orange.
 * 
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 * 
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange. 
 * If this is impossible, return -1.
 */
public class LC994_Rotting_Oranges {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;

        // Step 1: Count fresh oranges and add initial rotten ones to queue
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    freshCount++;
                }
            }
        }

        if (freshCount == 0) return 0;
        int minutes = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // Step 2: BFS to rot adjacent fresh oranges
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rottedInThisMinute = false;
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                for (int[] dir : directions) {
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];

                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        queue.offer(new int[]{nr, nc});
                        freshCount--;
                        rottedInThisMinute = true;
                    }
                }
            }
            if (rottedInThisMinute) minutes++;
        }

        return freshCount == 0 ? minutes : -1;
    }

    public static void main(String[] args) {
        LC994_Rotting_Oranges solver = new LC994_Rotting_Oranges();

        // Test Case 1
        int[][] grid1 = {{2,1,1},{1,1,0},{0,1,1}};
        runTest(solver, 1, grid1, 4);

        // Test Case 2
        int[][] grid2 = {{2,1,1},{0,1,1},{1,0,1}};
        runTest(solver, 2, grid2, -1);

        // Test Case 3
        int[][] grid3 = {{0,2}};
        runTest(solver, 3, grid3, 0);
    }

    private static void runTest(LC994_Rotting_Oranges solver, int testId, int[][] grid, int expected) {
        int result = solver.orangesRotting(grid);
        if (result == expected) {
            System.out.println("Test " + testId + ": PASS");
        } else {
            System.out.println("Test " + testId + ": FAIL");
            System.out.println("  Expected: " + expected);
            System.out.println("  Actual:   " + result);
        }
    }
}
