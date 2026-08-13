package com.leetcode;
import java.util.*;
/*
 * 1091. Shortest Path in Binary Matrix
 *
 * Description:
 * Given an n x n binary matrix grid, return the length of the shortest clear path
 * in the matrix. If there is no clear path, return -1.
 *
 * A clear path is a path from the top-left cell (0, 0) to the bottom-right cell
 * (n - 1, n - 1) such that:
 * - All visited cells are 0.
 * - All adjacent cells of the path are 8-directionally connected.
 *
 * The length of a clear path is the number of visited cells in this path.
 *
 * Constraints:
 * n == grid.length
 * n == grid[i].length
 * 1 <= n <= 100
 * grid[i][j] is 0 or 1
 *
 * Input format (method):
 * int[][] grid
 *
 * Output format (method):
 * int shortest clear path length, or -1
 */
public class LC1091_Shortest_Path_In_Binary_Matrix {
    public static int[][] moves = {
        {-1, 0}, {1, 0}, {0, -1}, {0, 1},
        {-1, -1}, {-1, 1}, {1, -1}, {1, 1}
    };

    public static int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;

        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0], c = curr[1], dist = curr[2];

            if (r == n - 1 && c == n - 1) return dist;

            for (int[] dir : moves) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n
                        && !visited[nr][nc] && grid[nr][nc] == 0) {
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc, dist + 1});
                }
            }
        }

        return -1; 
    }
}
