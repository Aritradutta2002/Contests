package LeetCode;

import java.util.*;

/**
 * Problem: 1559. Detect Cycles in 2D Grid
 *
 * Description:
 * Given a 2D grid of lowercase letters, return true if there exists a cycle
 * made of adjacent cells with the same character. A valid cycle has length at
 * least 4 and cannot immediately move back to the previous cell.
 *
 * Key Constraints:
 * - 1 <= m, n <= 500
 * - grid contains only lowercase English letters
 */
public class LC1559_Detect_Cycles_in_2D_Grid {
    private int[] dx = { -1, 1, 0, 0 };
    private int[] dy = { 0, 0, -1, 1 };

    public boolean containsCycle(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    if (bfs(i, j, -1, -1, grid, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean bfs(int rr, int cc, int px, int py, char[][] grid, boolean[][] visited) {
        Queue<int[]> child = new ArrayDeque<>();
        Queue<int[]> parent = new ArrayDeque<>();
        int n = grid.length;
        int m = grid[0].length;
        visited[rr][cc] = true;
        child.offer(new int[] { rr, cc });
        parent.offer(new int[] { px, py });

        while (!child.isEmpty()) {
            int[] c = child.poll();
            int[] p = parent.poll();

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + c[0];
                int ny = dy[i] + c[1];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m
                        && grid[nx][ny] == grid[c[0]][c[1]]
                        && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    child.offer(new int[] { nx, ny });
                    parent.offer(new int[] { c[0], c[1] });
                }

                else if (nx >= 0 && nx < n && ny >= 0 && ny < m
                        && visited[nx][ny]
                        && grid[nx][ny] == grid[c[0]][c[1]]
                        && (nx != p[0] || ny != p[1])) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LC1559_Detect_Cycles_in_2D_Grid solution = new LC1559_Detect_Cycles_in_2D_Grid();

        char[][] grid1 = {
                { 'a', 'a', 'a', 'a' },
                { 'a', 'b', 'b', 'a' },
                { 'a', 'b', 'b', 'a' },
                { 'a', 'a', 'a', 'a' }
        };
        testCase(solution, grid1, true, "Example 1");

        char[][] grid2 = {
                { 'c', 'c', 'c', 'a' },
                { 'c', 'd', 'c', 'c' },
                { 'c', 'c', 'e', 'c' },
                { 'f', 'c', 'c', 'c' }
        };
        testCase(solution, grid2, true, "Example 2");

        char[][] grid3 = {
                { 'a', 'b', 'b' },
                { 'b', 'z', 'b' },
                { 'b', 'b', 'a' }
        };
        testCase(solution, grid3, false, "Example 3");
    }

    private static void testCase(LC1559_Detect_Cycles_in_2D_Grid solution, char[][] grid, boolean expected,
            String testName) {
        try {
            boolean result = solution.containsCycle(grid);
            if (result == expected) {
                System.out.println(testName + ": PASS");
            } else {
                System.out.println(testName + ": FAIL");
                System.out.println("  Expected: " + expected);
                System.out.println("  Got:      " + result);
            }
        } catch (UnsupportedOperationException ex) {
            System.out.println(testName + ": PENDING IMPLEMENTATION");
        }
    }
}
