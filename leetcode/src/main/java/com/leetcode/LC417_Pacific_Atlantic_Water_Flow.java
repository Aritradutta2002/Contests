package com.leetcode;
import java.util.*;
/*
 * 417. Pacific Atlantic Water Flow
 *
 * Description:
 * Given an m x n matrix heights where heights[r][c] is the height above sea level,
 * water can flow from a cell to neighboring cells (up, down, left, right) with equal
 * or lower height. The Pacific touches the left and top edges, and the Atlantic touches
 * the right and bottom edges. Return all coordinates where water can flow to both oceans.
 *
 * Constraints:
 * - m == heights.length
 * - n == heights[r].length
 * - 1 <= m, n <= 200
 * - 0 <= heights[r][c] <= 10^5
 *
 * Example 1:
 * heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
 * -> [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
 * Example 2:
 * heights = [[1]] -> [[0,0]]
 * Example 3:
 * heights = [[1,1],[1,1]] -> [[0,0],[0,1],[1,0],[1,1]]
 */
public class LC417_Pacific_Atlantic_Water_Flow {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        boolean[][] pac = new boolean[m][n], atl = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(heights, pac, i, 0);
            dfs(heights, atl, i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, pac, 0, j);
            dfs(heights, atl, m - 1, j);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pac[i][j] && atl[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }
    private void dfs(int[][] h, boolean[][] visited, int i, int j) {
        int m = h.length, n = h[0].length;
        visited[i][j] = true;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] d : dirs) {
            int ni = i + d[0], nj = j + d[1];
            if (ni >= 0 && ni < m && nj >= 0 && nj < n && !visited[ni][nj] && h[ni][nj] >= h[i][j]) {
                dfs(h, visited, ni, nj);
            }
        }
    }
}
