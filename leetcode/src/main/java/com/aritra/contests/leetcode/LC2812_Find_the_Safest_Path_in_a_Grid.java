package com.aritra.contests.leetcode;

import java.util.*;

/*
 * 2812. Find the Safest Path in a Grid
 *
 * Description:
 * You are given a 0-indexed 2D matrix grid of size n x n, where (r, c) represents:
 * - A cell containing a thief if grid[r][c] = 1
 * - An empty cell if grid[r][c] = 0
 *
 * You are initially positioned at (0, 0). In one step, you can move to any adjacent cell in the grid,
 * including cells containing thieves.
 *
 * The safeness factor of a path is the minimum Manhattan distance from any cell in the path to any thief in the grid.
 * Return the maximum safeness factor of all paths leading to cell (n - 1, n - 1).
 *
 * Constraints:
 * 1 <= grid.length == n <= 400
 * grid[i][j] is either 0 or 1.
 * There is at least one thief in the grid.
 */
public class LC2812_Find_the_Safest_Path_in_a_Grid {

    public static int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        if (grid.get(0).get(0) == 1 || grid.get(n - 1).get(n - 1) == 1) {
            return 0;
        }

        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
        }

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    queue.offer(new int[]{i, j});
                    dist[i][j] = 0;
                }
            }
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && dist[nr][nc] == -1) {
                    dist[nr][nc] = dist[r][c] + 1;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }

        // Max-Heap: [safeness, r, c]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        pq.offer(new int[]{dist[0][0], 0, 0});
        dist[0][0] = -1; // Mark as visited

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0];
            int r = curr[1];
            int c = curr[2];

            if (r == n - 1 && c == n - 1) {
                return d;
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && dist[nr][nc] != -1) {
                    int nextSafeness = Math.min(d, dist[nr][nc]);
                    pq.offer(new int[]{nextSafeness, nr, nc});
                    dist[nr][nc] = -1; // Mark as visited
                }
            }
        }

        return 0;
    }
}
