package com.leetcode;

import java.util.*;

/**
 * LeetCode 1306. Jump Game III
 * 
 * Problem: Given an array of non-negative integers, you are initially positioned at the start index.
 * When you are at index i, you can jump to i + arr[i] or i - arr[i].
 * Check if you can reach any index with value 0.
 * 
 * Key Constraints:
 * - From index i, you can jump to: i + arr[i] or i - arr[i]
 * - Goal: reach any index where arr[j] == 0
 * - Cannot jump outside the array bounds
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class LC1306_Jump_Game_III {
    
    /**
     * Determine if we can reach any index with value 0
     * @param arr array of non-negative integers
     * @param start starting index for jumping
     * @return true if any index with value 0 is reachable, false otherwise
     */
    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        
        while (!queue.isEmpty()) {
            int index = queue.poll();
            
            // Check if current index has value 0
            if (arr[index] == 0) {
                return true;
            }
            
            // Jump forward by arr[index]
            int nextIdx = index + arr[index];
            if (nextIdx < arr.length && !visited[nextIdx]) {
                visited[nextIdx] = true;
                queue.offer(nextIdx);
            }
            
            // Jump backward by arr[index]
            int prevIdx = index - arr[index];
            if (prevIdx >= 0 && !visited[prevIdx]) {
                visited[prevIdx] = true;
                queue.offer(prevIdx);
            }
        }
        
        return false;
    }}
