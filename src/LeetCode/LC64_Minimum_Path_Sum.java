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

        // dist[i][j] = minimum path sum to reach cell (i,j)
        int[][] dist = new int[n][m];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[0][0] = grid[0][0];

        // Min-heap BFS (Dijkstra): entry = [accumulated cost, row, col]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{grid[0][0], 0, 0});

        // Only move right (+0,+1) or down (+1,+0)
        int[] dr = {1, 0};
        int[] dc = {0, 1};

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0], r = curr[1], c = curr[2];

            if (cost > dist[r][c]) continue; // stale entry, skip

            for (int d = 0; d < 2; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr < n && nc < m) {
                    int newCost = dist[r][c] + grid[nr][nc];
                    if (newCost < dist[nr][nc]) {
                        dist[nr][nc] = newCost;
                        pq.offer(new int[]{newCost, nr, nc});
                    }
                }
            }
        }

        return dist[n - 1][m - 1];
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
