package com.leetcode;
import java.util.*;
/*
 * 200. Number of Islands
 * 
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 * 
 * Constraints:
 * - m == grid.length
 * - n == grid[i].length
 * - 1 <= m, n <= 300
 * - grid[i][j] is '0' or '1'.
 */
public class LC200_Number_Of_Islands {
    public int numIslands(char[][] grid) {
        return numIslandsDFS(grid);
    }

    // ==========================================
    // APPROACH 1: Depth-First Search (DFS)
    // Time Complexity: O(M * N)
    // Space Complexity: O(M * N) worst case recursion stack
    // ==========================================
    public int numIslandsDFS(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid, int r, int c){
        if(!boundary(r, c, grid)) return;
        grid[r][c] = '0';
        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }
    public boolean boundary(int i, int j, char[][] grid){
        if(i < 0 || i >= grid.length) return false;
        if(j < 0 || j >= grid[0].length) return false;
        return grid[i][j] == '1';
    }

    // ==========================================
    // APPROACH 2: Breadth-First Search (BFS)
    // Time Complexity: O(M * N)
    // Space Complexity: O(min(M, N))
    // ==========================================
    public int numIslandsBFS(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '1'){
                    count++;
                    bfs(grid, i, j);
                }
            }
        }
        return count;
    }
    public void bfs(char[][] grid, int r, int c) {
        int n = grid.length, m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});
        grid[r][c] = '0';
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int[] d : dirs) {
                int nr = curr[0] + d[0];
                int nc = curr[1] + d[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == '1') {
                    q.offer(new int[]{nr, nc});
                    grid[nr][nc] = '0';
                }
            }
        }
    }

    // ==========================================
    // APPROACH 3: Union Find (Disjoint Set)
    // Time Complexity: O(M * N)
    // Space Complexity: O(M * N)
    // ==========================================
    public int numIslandsUF(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int n = grid.length, m = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    if (i + 1 < n && grid[i+1][j] == '1') uf.union(i * m + j, (i + 1) * m + j);
                    if (j + 1 < m && grid[i][j+1] == '1') uf.union(i * m + j, i * m + (j + 1));
                }
            }
        }
        return uf.getCount();
    }

    class UnionFind {
        int[] parent;
        int count;

        public UnionFind(char[][] grid) {
            int n = grid.length;
            int m = grid[0].length;
            parent = new int[n * m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == '1') {
                        parent[i * m + j] = i * m + j;
                        count++;
                    }
                }
            }
        }
    public int find(int i) {
            if (parent[i] == i) return i;
            return parent[i] = find(parent[i]);
        }
    public void union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI != rootJ) {
                parent[rootI] = rootJ;
                count--;
            }
        }
    public int getCount() {
            return count;
        }
    }
}
