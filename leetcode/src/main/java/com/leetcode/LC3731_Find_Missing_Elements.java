package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 3731. Find Missing Elements
 *
 * You are given an integer array nums consisting of unique integers.
 * 
 * Originally, nums contained every integer within a certain range. However,
 * some integers might have gone missing from the array.
 * 
 * The smallest and largest integers of the original range are still present in
 * nums.
 * 
 * Return a sorted list of all the missing integers in this range. If no
 * integers are missing, return an empty list.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,4,2,5]
 * 
 * Output: [3]
 * 
 * Explanation:
 * 
 * The smallest integer is 1 and the largest is 5, so the full range should be
 * [1,2,3,4,5]. Among these, only 3 is missing.
 * 
 * ...
 */
public class LC3731_Find_Missing_Elements {
    public List<Integer> findMissingElements(int[] nums) {
        int n = nums.length;
        List<Integer> missingElements = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < n - 1; i++) {
            int current = nums[i];
            int next = nums[i + 1];
            for (int j = current + 1; j < next; j++) {
                missingElements.add(j);
            }
        }

        return missingElements;
    }
}