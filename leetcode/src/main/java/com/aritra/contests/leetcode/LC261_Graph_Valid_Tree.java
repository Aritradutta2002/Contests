package com.aritra.contests.leetcode;
import java.util.*;
/*
 * 261. Graph Valid Tree
 *
 * Description:
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges, return
 * true if these edges make up a valid tree.
 *
 * Constraints:
 * - 1 <= n <= 2000
 * - 0 <= edges.length <= 5000
 * - edges[i].length == 2
 * - 0 <= ai, bi < n
 * - ai != bi
 * - There are no self-loops or duplicate edges
 *
 * Example 1:
 * n = 5, edges = [[0,1],[0,2],[0,3],[1,4]] -> true
 * Example 2:
 * n = 5, edges = [[0,1],[1,2],[2,3],[1,3],[1,4]] -> false
 * Example 3:
 * n = 4, edges = [[0,1],[2,3]] -> false
 */
public class LC261_Graph_Valid_Tree {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        for (int[] e : edges) {
            int p1 = find(parent, e[0]), p2 = find(parent, e[1]);
            if (p1 == p2) return false;
            parent[p1] = p2;
        }
        return true;
    }
    private int find(int[] parent, int x) {
        if (parent[x] != x) parent[x] = find(parent, parent[x]);
        return parent[x];
    }
}
