package com.leetcode;

import java.util.*;
/**
 * 3559. Number of Ways to Assign Edge Weights II
 * 
 * Problem Description:
 * There is an undirected tree with n nodes, labeled from 1 to n, rooted at node 1.
 * You are given a 2D integer array edges of length n - 1, where edges[i] = [ui, vi] 
 * represents an edge between nodes ui and vi in the tree.
 * Initially, all edges have a weight of 0. You are required to assign each edge a weight
 * of either 1 or 2.
 * The cost of a path between any two nodes u and v is defined as the sum of the weights
 * of all edges on the path.
 * You are given a 2D integer array queries, where queries[i] = [ui, vi]. For each query, 
 * you need to find the number of ways to assign weights to the edges such that the cost
 * of the path between ui and vi is odd.
 * Return an array answer where answer[i] is the number of valid assignments for queries[i].
 * Since the answer can be very large, return it modulo 10^9 + 7.
 * Note: For each query, ignore all edges that do not belong to the simple path between ui and vi.
 * 
 * Constraints:
 * - 2 <= n <= 10^5
 * - edges.length == n - 1
 * - edges[i].length == 2
 * - 1 <= ui, vi <= n
 * - 1 <= queries.length <= 10^5
 * - queries[i].length == 2
 * - 1 <= queries[i][0], queries[i][1] <= n
 */
public class LC3559_Number_of_Ways_to_Assign_Edge_Weights_II {
    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        final int modulo = 1_000_000_007;
        int n = edges.length + 1;
        int levels = 1;
        while ((1 << levels) <= n) levels++;
        @SuppressWarnings("unchecked")
        List<Integer>[] graph = (List<Integer>[]) new List<?>[n + 1];
        for (int node = 1; node <= n; node++) graph[node] = new ArrayList<>();
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        int[][] ancestor = new int[levels][n + 1];
        int[] depth = new int[n + 1];
        int[] queue = new int[n];
        int head = 0;
        int tail = 0;
        queue[tail++] = 1;
        while (head < tail) {
            int node = queue[head++];
            for (int next : graph[node]) {
                if (next == ancestor[0][node]) continue;
                ancestor[0][next] = node;
                depth[next] = depth[node] + 1;
                queue[tail++] = next;
            }
        }
        for (int level = 1; level < levels; level++) {
            for (int node = 1; node <= n; node++) {
                ancestor[level][node] = ancestor[level - 1][ancestor[level - 1][node]];
            }
        }
        int[] powersOfTwo = new int[n + 1];
        powersOfTwo[0] = 1;
        for (int distance = 1; distance <= n; distance++) {
            powersOfTwo[distance] = (int) ((long) powersOfTwo[distance - 1] * 2 % modulo);
        }
        int[] answer = new int[queries.length];
        for (int index = 0; index < queries.length; index++) {
            int distance = depth[queries[index][0]] + depth[queries[index][1]]
                    - 2 * depth[lowestCommonAncestor(queries[index][0], queries[index][1], depth, ancestor)];
            answer[index] = distance == 0 ? 0 : powersOfTwo[distance - 1];
        }
        return answer;
    }

    private int lowestCommonAncestor(int first, int second, int[] depth, int[][] ancestor) {
        if (depth[first] < depth[second]) {
            int swap = first;
            first = second;
            second = swap;
        }
        int difference = depth[first] - depth[second];
        for (int level = 0; difference > 0; level++, difference >>= 1) {
            if ((difference & 1) != 0) first = ancestor[level][first];
        }
        if (first == second) return first;
        for (int level = ancestor.length - 1; level >= 0; level--) {
            if (ancestor[level][first] != ancestor[level][second]) {
                first = ancestor[level][first];
                second = ancestor[level][second];
            }
        }
        return ancestor[0][first];
    }
}
