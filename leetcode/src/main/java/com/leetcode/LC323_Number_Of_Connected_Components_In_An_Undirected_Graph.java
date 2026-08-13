package com.leetcode;
import java.util.*;
/*
 * 323. Number of Connected Components in an Undirected Graph
 *
 * Description:
 * You have a graph of n nodes labeled from 0 to n - 1 and an edge list where each
 * edge connects two nodes. Return the number of connected components in the graph.
 *
 * Constraints:
 * - 1 <= n <= 2000
 * - 0 <= edges.length <= 5000
 * - edges[i].length == 2
 * - 0 <= ai, bi < n
 * - ai != bi
 * - There are no duplicate edges
 *
 * Example 1:
 * n = 5, edges = [[0,1],[1,2],[3,4]] -> 2
 * Example 2:
 * n = 5, edges = [[0,1],[1,2],[2,3],[3,4]] -> 1
 * Example 3:
 * n = 5, edges = [] -> 5
 */
public class LC323_Number_Of_Connected_Components_In_An_Undirected_Graph {
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        int components = n;
        for (int[] e : edges) {
            int p1 = find(parent, e[0]), p2 = find(parent, e[1]);
            if (p1 != p2) {
                parent[p1] = p2;
                components--;
            }
        }
        return components;
    }
    private int find(int[] parent, int x) {
        if (parent[x] != x) parent[x] = find(parent, parent[x]);
        return parent[x];
    }
}
