package com.leetcode;
import java.util.*;
@SuppressWarnings("unused")

/*
 * 2958. Length of Longest Subarray With At Most K Frequency
 *
 * Return the maximum length of a subarray where each element appears at most k times.
 *
 * Constraints:
 * - 1 <= nums.length <= 10^5
 * - 1 <= nums[i] <= 10^9
 * - 1 <= k <= nums.length
 */
public class LC2958_Length_Of_Longest_Subarray_With_At_Most_K_Frequency {
    public static int maxSubarrayLength(int[] nums, int k) {
        int start = 0, maxLength = 0;
        Map<Integer, Integer> freq = new HashMap<>();

        for (int end = 0; end < nums.length; end++) {
            freq.put(nums[end], freq.getOrDefault(nums[end], 0) + 1);

            while (freq.get(nums[end]) > k) {
                freq.put(nums[start], freq.get(nums[start]) - 1);
                if (freq.get(nums[start]) == 0) {
                    freq.remove(nums[start]);
                }
                start++;
            }

            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}

