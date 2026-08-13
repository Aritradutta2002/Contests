package com.leetcode;

import java.util.*;

/**
 * 695. Max Area of Island
 * 
 * You are given an m x n binary matrix grid. An island is a group of 1's
 * (representing land) connected
 * 4-directionally (horizontal or vertical.) You may assume all four edges of
 * the grid are surrounded by water.
 * 
 * The area of an island is the number of cells with a value 1 in the island.
 * 
 * Return the maximum area of an island in grid. If there is no island, return
 * 0.
 * 
 * Constraints:
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 50
 * grid[i][j] is either 0 or 1.
 */
public class LC695_Max_Area_Of_Island {
    private int[] dx = { -1, 1, 0, 0 };
    private int[] dy = { 0, 0, -1, 1 };

    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int maxSize = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    maxSize = Math.max(maxSize, bfs(i, j, grid, visited));
                }
            }
        }
        return maxSize;
    }
    public int bfs(int r, int c, int[][] grid, boolean[][] visited) {
        int count = 1;
        int n = grid.length, m = grid[0].length;
        Queue<Integer> row = new ArrayDeque<>();
        Queue<Integer> col = new ArrayDeque<>();
        row.offer(r);
        col.offer(c);
        visited[r][c] = true;

        while (!row.isEmpty()) {
            int rr = row.poll();
            int cc = col.poll();
            for (int i = 0; i < 4; i++) {
                int nr = rr + dx[i];
                int nc = cc + dy[i];
                if (nr >= 0 && nc >= 0 && nr < n && nc < m && grid[nr][nc] == 1 && !visited[nr][nc]) {
                    count++;
                    visited[nr][nc] = true;
                    row.offer(nr);
                    col.offer(nc);
                }
            }
        }
        return count;
    }
}
