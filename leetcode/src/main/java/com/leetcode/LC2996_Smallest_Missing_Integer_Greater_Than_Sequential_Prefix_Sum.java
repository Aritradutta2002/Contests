package com.leetcode;

/**
 * 2996. Smallest Missing Integer Greater Than Sequential Prefix Sum
 *
 * You are given a 0-indexed array of integers nums.
 * A prefix nums[0..i] is sequential if, for all 1 <= j <= i, nums[j] = nums[j - 1] + 1.
 * In particular, the prefix consisting only of nums[0] is sequential.
 *
 * Return the smallest integer x missing from nums such that x is greater than or equal
 * to the sum of the longest sequential prefix.
 *
 * Constraints:
 * - 1 <= nums.length <= 50
 * - 1 <= nums[i] <= 50
 */
public class LC2996_Smallest_Missing_Integer_Greater_Than_Sequential_Prefix_Sum {
    public int missingInteger(int[] nums) {
        int sum = nums[0];
        for (int i = 1; i < nums.length && nums[i] == nums[i - 1] + 1; i++) {
            sum += nums[i];
        }

        boolean[] present = new boolean[52];
        for (int num : nums) {
            if (num <= 51) {
                present[num] = true;
            }
        }

        int x = sum;
        while (x <= 51 && present[x]) {
            x++;
        }
        return x;
    }
}
