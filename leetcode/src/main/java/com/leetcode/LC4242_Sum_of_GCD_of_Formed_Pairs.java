package com.leetcode;

import java.util.Arrays;

/**
 * 4242. Sum of GCD of Formed Pairs
 *
 * You are given an integer array nums of length n.
 *
 * Construct an array prefixGcd where for each index i:
 * - Let mx_i = max(nums[0], nums[1], ..., nums[i]).
 * - prefixGcd[i] = gcd(nums[i], mx_i).
 *
 * After constructing prefixGcd:
 * - Sort prefixGcd in non-decreasing order.
 * - Form pairs by taking the smallest unpaired element and the largest unpaired element.
 * - Repeat this process until no more pairs can be formed.
 * - For each formed pair, compute the gcd of the two elements.
 * - If n is odd, the middle element in the prefixGcd array remains unpaired and should be ignored.
 *
 * Return an integer denoting the sum of the GCD values of all formed pairs.
 *
 * Constraints:
 * - 1 <= n == nums.length <= 10^5
 * - 1 <= nums[i] <= 10^9
 *
 * Example 1:
 * Input: nums = [2,6,4]
 * Output: 2
 *
 * Example 2:
 * Input: nums = [3,6,2,8]
 * Output: 5
 */
class LC4242_Sum_of_GCD_of_Formed_Pairs {

    public long gcdSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0L;
        }

        int[] prefixGcd = new int[nums.length];
        int maxSoFar = nums[0];
        prefixGcd[0] = gcd(nums[0], maxSoFar);

        for (int i = 1; i < nums.length; i++) {
            maxSoFar = Math.max(maxSoFar, nums[i]);
            prefixGcd[i] = gcd(nums[i], maxSoFar);
        }

        Arrays.sort(prefixGcd);

        long sum = 0L;
        int left = 0;
        int right = prefixGcd.length - 1;
        while (left < right) {
            sum += gcd(prefixGcd[left], prefixGcd[right]);
            left++;
            right--;
        }
        return sum;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}