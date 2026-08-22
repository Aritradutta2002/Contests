package com.leetcode;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/**
 * 3471. Find the Largest Almost Missing Integer
 *
 * You are given an integer array nums and an integer k.
 * 
 * An integer x is almost missing from nums if x appears in exactly one subarray
 * of size k within nums.
 * 
 * Return the largest almost missing integer from nums. If no such integer
 * exists, return -1.
 * A subarray is a contiguous sequence of elements within an array.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [3,9,2,1,7], k = 3
 * 
 * Output: 7
 * 
 * Explanation:
 * 
 * 
 * - 1 appears in 2 subarrays of size 3: [9, 2, 1] and [2, 1, 7].
 * 
 */
public class LC3471_Find_the_Largest_Almost_Missing_Integer {
    public int largestInteger(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int n = nums.length;

        // Count the occurrences of each integer in all subarrays of size k
        for (int i = 0; i <= n - k; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int j = i; j < i + k; j++) {
                uniqueElements.add(nums[j]);
            }
            for (int num : uniqueElements) {
                countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            }
        }

        // Find the largest integer that appears in exactly one subarray of size k
        int largestAlmostMissing = -1;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 1) {
                largestAlmostMissing = Math.max(largestAlmostMissing, entry.getKey());
            }
        }

        return largestAlmostMissing;
    }
}