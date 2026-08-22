package com.leetcode;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
/**
 * LeetCode 3629. Minimum Jumps to Reach End via Prime Teleportation
 * 
 * You are given an integer array nums (1-indexed). You can jump from index i to index j
 * if and only if i < j <= i + nums[i]. Additionally, you can teleport from index i to index j
 * if nums[i] is a prime number and 1 <= j <= n where n is the length of the array.
 * 
 * Your task is to find the minimum number of jumps required to reach the last index of the array.
 * 
 * Constraints:
 * - 1 <= nums.length <= 10^4
 * - 1 <= nums[i] <= 50
 */

public class LC3629_Minimum_Jumps_to_Reach_End_via_Prime_Teleportation {
    
    /**
     * Calculate the minimum number of jumps to reach the end of the array.
     * 
     * @param nums the input array where nums[i] represents jump range or prime teleportation
     * @return the minimum number of jumps needed to reach the last index
     */
    public int minimumJumps(int[] nums) {
        int n = nums.length;
        int[] distance = new int[n];
        Arrays.fill(distance, -1);
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        distance[0] = 0;
        boolean[] expandedPrime = new boolean[51];
        while (!queue.isEmpty()) {
            int index = queue.remove();
            if (index == n - 1) return distance[index];
            int lastReachable = Math.min(n - 1, index + nums[index]);
            for (int next = index + 1; next <= lastReachable; next++) {
                if (distance[next] == -1) {
                    distance[next] = distance[index] + 1;
                    queue.add(next);
                }
            }
            if (isPrime(nums[index]) && !expandedPrime[nums[index]]) {
                expandedPrime[nums[index]] = true;
                for (int next = 0; next < n; next++) {
                    if (distance[next] == -1) {
                        distance[next] = distance[index] + 1;
                        queue.add(next);
                    }
                }
            }
        }
        return -1;
    }

    private boolean isPrime(int value) {
        if (value < 2) return false;
        for (int divisor = 2; divisor * divisor <= value; divisor++) {
            if (value % divisor == 0) return false;
        }
        return true;
    }
}
