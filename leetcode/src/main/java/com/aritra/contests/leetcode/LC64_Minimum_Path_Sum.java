package com.aritra.contests.leetcode;
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
 */
class LC64_Minimum_Path_Sum {

    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dist = new int[n][m];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[0][0] = grid[0][0];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{grid[0][0], 0, 0});

        int[] dr = {1, 0};
        int[] dc = {0, 1};

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0], r = curr[1], c = curr[2];

            if (cost > dist[r][c]) continue;

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
}
