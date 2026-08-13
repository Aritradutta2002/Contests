package com.leetcode;

import java.util.*;

/*
 * 3286. Find a Safe Walk Through a Grid
 *
 * Description:
 * You are given an m x n binary matrix grid and an integer health.
 * You start at the upper-left corner (0, 0) and want to reach the lower-right corner (m - 1, n - 1).
 * In each step, you can move to an adjacent cell (up, down, left, or right) as long as your health is greater than 0.
 * If you move to a cell with value 1, your health decreases by 1. If you move to a cell with value 0, your health remains unchanged.
 * Return true if you can reach the lower-right corner with health >= 1, and false otherwise.
 *
 * Constraints:
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 50
 * grid[i][j] is either 0 or 1.
 * 1 <= health <= m + n
 */
public class LC3286_Find_a_Safe_Walk_Through_a_Grid {

    public static boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();
        
        int[][] minLoss = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(minLoss[i], Integer.MAX_VALUE);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        int startLoss = grid.get(0).get(0);
        minLoss[0][0] = startLoss;
        pq.offer(new int[]{0, 0, startLoss});
        
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int r = curr[0];
            int c = curr[1];
            int loss = curr[2];
            
            if (loss > minLoss[r][c]) {
                continue;
            }
            
            if (r == m - 1 && c == n - 1) {
                break;
            }
            
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    int nextLoss = loss + grid.get(nr).get(nc);
                    if (nextLoss < minLoss[nr][nc]) {
                        minLoss[nr][nc] = nextLoss;
                        pq.offer(new int[]{nr, nc, nextLoss});
                    }
                }
            }
        }
        
        return health - minLoss[m - 1][n - 1] >= 1;
    }
}
