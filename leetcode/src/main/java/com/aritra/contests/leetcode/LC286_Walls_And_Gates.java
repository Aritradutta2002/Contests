package com.aritra.contests.leetcode;
import java.util.*;
/*
 * 286. Walls and Gates
 *
 * Description:
 * You are given an m x n grid rooms initialized with:
 * -1 for a wall or obstacle, 0 for a gate, and INF for an empty room.
 * Fill each empty room with the distance to its nearest gate. If it is impossible to
 * reach a gate, it should be filled with INF.
 *
 * Constraints:
 * - 1 <= m, n <= 250
 * - rooms[i][j] is -1, 0, or 2^31 - 1
 *
 * Example 1:
 * rooms = [[2147483647,-1,0,2147483647],[2147483647,2147483647,2147483647,-1],[2147483647,-1,2147483647,-1],[0,-1,2147483647,2147483647]]
 * -> [[3,-1,0,1],[2,2,1,-1],[1,-1,2,-1],[0,-1,3,4]]
 * Example 2:
 * rooms = [[-1]] -> [[-1]]
 * Example 3:
 * rooms = [[0]] -> [[0]]
 */
public class LC286_Walls_And_Gates {
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length, n = rooms[0].length, INF = Integer.MAX_VALUE;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) queue.offer(new int[]{i, j});
            }
        }
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1];
            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && rooms[nr][nc] == INF) {
                    rooms[nr][nc] = rooms[r][c] + 1;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
    }
}
