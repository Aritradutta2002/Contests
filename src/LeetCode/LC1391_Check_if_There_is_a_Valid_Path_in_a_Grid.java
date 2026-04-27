package LeetCode;

import java.util.*;

/**
 * Problem: 1391. Check if There is a Valid Path in a Grid
 *
 * Description:
 * You are given an m x n grid. Each cell represents a street:
 *   1: horizontal street (left-right)
 *   2: vertical street   (up-down)
 *   3: turn down-left
 *   4: turn down-right
 *   5: turn up-left
 *   6: turn up-right
 *
 * You start at the upper-left cell (0,0). A valid path starts from (0,0) and ends
 * at the bottom-right cell (m-1, n-1), moving only through connected streets.
 * Return true if there is a valid path.
 *
 * Constraints:
 * - m == grid.length
 * - n == grid[i].length
 * - 1 <= m, n <= 300
 * - 1 <= grid[i][j] <= 6
 *
 * Approach: BFS
 * - Each street type has openings in specific directions.
 * - From each cell, move to a neighbor only if both cells have an opening
 *   facing each other.
 * - Directions order: { up, down, left, right }
 */
public class LC1391_Check_if_There_is_a_Valid_Path_in_a_Grid {

    private static final int[][] DIRECTIONS = {
        {},           // 0 - placeholder
        {0, 0, 1, 1}, // 1 - left-right
        {1, 1, 0, 0}, // 2 - up-down
        {0, 1, 1, 0}, // 3 - down-left
        {0, 1, 0, 1}, // 4 - down-right
        {1, 0, 1, 0}, // 5 - up-left
        {1, 0, 0, 1}  // 6 - up-right
    };

    // Row and column deltas for: up, down, left, right
    private static final int[] DR = {-1, 1, 0, 0};
    private static final int[] DC = {0, 0, -1, 1};

    public boolean hasValidPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if (m == 1 && n == 1) {
            return true;
        }

        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            int street = grid[r][c];

            for (int d = 0; d < 4; d++) {
                if (DIRECTIONS[street][d] == 0) {
                    continue;
                }

                int nr = r + DR[d];
                int nc = c + DC[d];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                    continue;
                }
                if (visited[nr][nc]) {
                    continue;
                }

                int nextStreet = grid[nr][nc];
                int opposite = d ^ 1;
                if (DIRECTIONS[nextStreet][opposite] == 1) {
                    if (nr == m - 1 && nc == n - 1) {
                        return true;
                    }
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        LC1391_Check_if_There_is_a_Valid_Path_in_a_Grid solver =
            new LC1391_Check_if_There_is_a_Valid_Path_in_a_Grid();

        // Test Case 1: Valid path exists
        int[][] grid1 = {{2, 4, 3}, {6, 5, 2}};
        runTest(solver, grid1, true, "Test 1");

        // Test Case 2: No valid path
        int[][] grid2 = {{1, 2, 1}, {1, 2, 1}};
        runTest(solver, grid2, false, "Test 2");

        // Test Case 3: Single cell
        int[][] grid3 = {{1}};
        runTest(solver, grid3, true, "Test 3");

        // Test Case 4: Another valid path
        int[][] grid4 = {{4, 1, 3}, {6, 1, 2}};
        runTest(solver, grid4, true, "Test 4");
    }

    private static void runTest(LC1391_Check_if_There_is_a_Valid_Path_in_a_Grid solver,
                                 int[][] grid, boolean expected, String name) {
        boolean result = solver.hasValidPath(grid);
        if (result == expected) {
            System.out.println(name + ": PASS");
        } else {
            System.out.println(name + ": FAIL");
            System.out.println("  Expected: " + expected);
            System.out.println("  Got:      " + result);
        }
    }
}
