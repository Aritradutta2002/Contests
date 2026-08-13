package com.leetcode;

/*
 * Solved using Kadane's Algorithm
 */
import java.util.*;

public class LC1800_Maximum_Ascending_Subarray_Sum {
    static public int maxAscendingSum(int[] nums) {
        int sum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] > nums[i - 1]) {
                sum = sum + nums[i];
            }

            else {
                sum = nums[i];
            }

            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        return maxSum;
    }
}
