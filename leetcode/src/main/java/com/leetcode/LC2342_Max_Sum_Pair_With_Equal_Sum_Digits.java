package com.leetcode;

import java.util.Scanner;

/*
 * 2342. Max Sum Pair with Equal Sum Digits
 *
 * Given an array nums, find the maximum sum of two numbers whose digit sum is equal. If no such
 * pair exists, return -1.
 *
 * Constraints:
 * - 1 <= nums.length <= 10^5
 * - 1 <= nums[i] <= 10^9
 */
public class LC2342_Max_Sum_Pair_With_Equal_Sum_Digits {
    static public int maximumSum(int[] nums) {
        // HashMap<Integer, Integer> map = new HashMap<>();
        int[] map = new int[82];
        int ans = -1;

        for (int ele : nums) {
            int digitSum = getDigitSum(ele);

            if (map[digitSum] > 0) {
                int prev = map[digitSum];
                //int prev = map.get(digitSum);
                ans = Math.max(ans, ele + prev);
                map[digitSum] = Math.max(ele, prev);
                //map.put(digitSum, Math.max(ele, prev));
            } else {
                map[digitSum] = ele;
                //map.put(digitSum, ele);
            }

        }

        return ans;

    }
    static public int getDigitSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
