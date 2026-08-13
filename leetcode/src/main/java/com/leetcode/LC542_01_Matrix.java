package com.leetcode;
import java.util.*;
/*
 * 542. 01 Matrix
 * 
 * Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
 * The distance between two adjacent cells is 1.
 * 
 * Constraints:
 * - m == mat.length
 * - n == mat[i].length
 * - 1 <= m, n <= 10^4
 * - 1 <= m * n <= 10^4
 * - mat[i][j] is either 0 or 1.
 * - There is at least one 0 in mat.
*/
public class LC542_01_Matrix {
    public static int[][] moves = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int[][] ans = new int[n][m];
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0)
                    q.offer(new int[] { i, j });
                else
                    ans[i][j] = Integer.MAX_VALUE;
            }
        }
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            for (int[] dir : moves) {
                int nr = dir[0] + cell[0];
                int nc = dir[1] + cell[1];
                if (nr >= 0 && nc >= 0 && nr < n && nc < m && ans[nr][nc] > ans[cell[0]][cell[1]] + 1) {
                    ans[nr][nc] = ans[cell[0]][cell[1]] + 1;
                    q.offer(new int[] { nr, nc });
                }
            }
        }
        return ans;
    }
}
