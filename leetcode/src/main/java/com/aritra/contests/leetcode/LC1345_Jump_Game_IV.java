package com.aritra.contests.leetcode;

import java.util.*;

/**
 * LeetCode 1345. Jump Game IV
 * 
 * Problem: Given an array of integers, return the minimum number of jumps to reach the last index.
 * From index i, you can jump to any index j where:
 * - j = i + 1 or j = i - 1 (adjacent indices)
 * - arr[i] == arr[j] for any valid index j
 * 
 * Key Constraints:
 * - arr.length >= 1
 * - Can jump to adjacent index or any index with the same value
 * - Must find minimum number of jumps to reach last index
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class LC1345_Jump_Game_IV {
    
    /**
     * Find the minimum number of jumps to reach the last index
     * @param arr array of integers
     * @return minimum number of jumps required
     */
    public int minimumJumps(int[] arr) {
        int n = arr.length;
        if (n == 1) return 0;
        
        // Group indices by value for quick lookup of equal elements
        Map<Integer, List<Integer>> valueToIndices = new HashMap<>();
        for (int i = 0; i < n; i++) {
            valueToIndices.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.offer(0);
        visited[0] = true;
        int jumps = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            jumps++;
            
            for (int i = 0; i < size; i++) {
                int index = queue.poll();
                
                // Try jumping to adjacent indices
                int nextIdx = index + 1;
                if (nextIdx < n && !visited[nextIdx]) {
                    if (nextIdx == n - 1) return jumps;
                    visited[nextIdx] = true;
                    queue.offer(nextIdx);
                }
                
                int prevIdx = index - 1;
                if (prevIdx >= 0 && !visited[prevIdx]) {
                    visited[prevIdx] = true;
                    queue.offer(prevIdx);
                }
                
                // Try jumping to indices with same value
                List<Integer> sameValueIndices = valueToIndices.get(arr[index]);
                if (sameValueIndices != null) {
                    for (int j : sameValueIndices) {
                        if (!visited[j]) {
                            if (j == n - 1) return jumps;
                            visited[j] = true;
                            queue.offer(j);
                        }
                    }
                    sameValueIndices.clear(); // Optimization: avoid revisiting same value group
                }
            }
        }
        
        return jumps;
    }}
