package com.leetcode;
import java.util.*;
/**
 * 560. Subarray Sum Equals K
 * 
 * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
 * A subarray is a contiguous non-empty sequence of elements within an array.
 * 
 * Constraints:
 * 1 <= nums.length <= 2 * 10^4
 * -1000 <= nums[i] <= 1000
 * -10^7 <= k <= 10^7
 */
public class LC560_Subarray_Sum_Equals_K {
    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap<Integer, Integer> prefixsum = new HashMap<>();
        prefixsum.put(0, 1); // A prefix sum of 0 has occurred exactly once at the beginning
        
        for (int num : nums) {
            sum += num;
            if (prefixsum.containsKey(sum - k)) {
                count += prefixsum.get(sum - k);
            }
            prefixsum.put(sum, prefixsum.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }
}
