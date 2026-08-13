package com.leetcode;
import java.util.*;
/*
 * 684. Redundant Connection
 *
 * Description:
 * You are given a tree with n nodes (labeled 1 to n) plus one additional edge.
 * The added edge creates exactly one cycle. Return the edge that can be removed so
 * that the resulting graph is a tree of n nodes. If multiple answers exist, return
 * the one that occurs last in the input.
 *
 * Constraints:
 * - n == edges.length
 * - 3 <= n <= 1000
 * - edges[i].length == 2
 * - 1 <= ai < bi <= edges.length
 * - ai != bi
 * - There are no repeated edges
 * - The graph is connected
 *
 * Example 1:
 * edges = [[1,2],[1,3],[2,3]] -> [2,3]
 * Example 2:
 * edges = [[1,2],[2,3],[3,4],[1,4],[1,5]] -> [1,4]
 * Example 3:
 * edges = [[1,2],[2,3],[3,1]] -> [3,1]
 */
public class LC684_Redundant_Connection {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) parent[i] = i;
        for (int[] e : edges) {
            int p1 = find(parent, e[0]), p2 = find(parent, e[1]);
            if (p1 == p2) return e;
            parent[p1] = p2;
        }
        return new int[0];
    }
    private int find(int[] parent, int x) {
        if (parent[x] != x) parent[x] = find(parent, parent[x]);
        return parent[x];
    }
}
