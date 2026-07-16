package com.aritra.contests.leetcode;
import java.util.*;
/*
 * 1848. Minimum Distance to the Target Element
 *
 * Description:
 * Given an integer array nums, an integer target, and an integer start,
 * return the minimum distance between start and any index i such that nums[i] == target.
 * The distance between two indices is the absolute difference between them: |i - start|.
 *
 * Constraints:
 *   1 <= nums.length <= 1000
 *   1 <= nums[i] <= 10^4
 *   0 <= start < nums.length
 *   target is in nums
 *
 * Example 1:
 *   nums = [1, 2, 3, 4, 5], target = 5, start = 3 -> 1
 * Example 2:
 *   nums = [1], target = 1, start = 0 -> 0
 * Example 3:
 *   nums = [1, 1, 1, 1, 1, 1, 1, 1, 1, 1], target = 1, start = 0 -> 0
 */
public class LC1848_Minimum_Distance_To_The_Target_Element {
    public int getMinDistance(int[] nums, int target, int start) {
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                minDiff = Math.min(minDiff, Math.abs(i - start));
            }
        }
        return minDiff;
    }
}
