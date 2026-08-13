package com.leetcode;
import java.util.*;

/*
 * 1722. Minimize Hamming Distance After Swap Operations
 *
 * You are given two integer arrays, source and target, both of length n. You are also given an array
 * allowedSwaps where each allowedSwaps[i] = [ai, bi] indicates that you can swap elements at indices
 * ai and bi any number of times. Return the minimum Hamming distance between source and target after
 * performing any number of swap operations.
 *
 * Constraints:
 * - 1 <= n <= 10^5
 * - source.length == target.length == n
 * - 0 <= source[i], target[i] <= 10^5
 * - 0 <= allowedSwaps.length <= 10^5
 * - allowedSwaps[i].length == 2
 */
public class LC1722_Minimize_Hamming_Distance_After_Swap_Operations {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        for (int[] swap : allowedSwaps) {
            int pa = find(parent, swap[0]), pb = find(parent, swap[1]);
            if (pa != pb) parent[pb] = pa;
        }
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = find(parent, i);
            map.computeIfAbsent(root, k -> new HashMap<>()).merge(source[i], 1, Integer::sum);
        }
        int same = 0;
        for (int i = 0; i < n; i++) {
            int root = find(parent, i);
            Map<Integer, Integer> cnt = map.get(root);
            if (cnt.getOrDefault(target[i], 0) > 0) {
                same++;
                cnt.merge(target[i], -1, Integer::sum);
            }
        }
        return n - same;
    }
    private int find(int[] parent, int x) {
        if (parent[x] != x) parent[x] = find(parent, parent[x]);
        return parent[x];
    }
}
