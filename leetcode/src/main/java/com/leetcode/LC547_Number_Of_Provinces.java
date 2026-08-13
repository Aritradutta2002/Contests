package com.leetcode;
/*
 * LeetCode 547. Number of Provinces
 *
 * Description:
 * There are n cities represented by an n x n adjacency matrix isConnected,
 * where isConnected[i][j] = 1 means city i and city j are directly connected,
 * and 0 otherwise. A province is a group of directly or indirectly connected
 * cities with no cities outside the group.
 *
 * Return the total number of provinces.
 *
 * Constraints:
 * 1 <= n <= 200
 * n == isConnected.length
 * n == isConnected[i].length
 * isConnected[i][j] is 0 or 1
 * isConnected[i][i] == 1
 * isConnected[i][j] == isConnected[j][i]
 */
public class LC547_Number_Of_Provinces {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int connectedComponent = countConnectedDFS(isConnected, n);
        return connectedComponent;
    }
    public int countConnectedDFS(int[][] connected, int n) {
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, visited, connected);
                count++;
            }
        }
        return count;
    }
    public void dfs(int node, boolean[] visited, int[][] connected){
        int n = connected.length;
        visited[node] = true;
        for(int neighbor = 0; neighbor < n; neighbor++){
            if(connected[node][neighbor] == 1 && !visited[neighbor]){
                dfs(neighbor, visited, connected);
            }
        }
    }
}
