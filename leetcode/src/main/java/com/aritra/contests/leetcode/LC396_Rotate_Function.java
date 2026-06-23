package com.aritra.contests.leetcode;
import java.util.*;
/*
 * Problem 396: Rotate Function
 * 
 * Description:
 * You are given an integer array nums of length n.
 * Assume arrk to be an array obtained by rotating nums by k positions clock-wise.
 * We define the rotation function F on nums as follow:
 *   F(k) = 0 * arrk[0] + 1 * arrk[1] + ... + (n - 1) * arrk[n - 1].
 * Return the maximum value of F(0), F(1), ..., F(n-1).
 * 
 * Constraints:
 * - n == nums.length
 * - 1 <= n <= 10^5
 * - -100 <= nums[i] <= 100
 */
public class LC396_Rotate_Function {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int currentFunctionValue = 0;
        int totalSum = 0;
        for(int i = 0; i < n; i++){
            currentFunctionValue += (i * nums[i]);
            totalSum += nums[i];
        }

        int maxValue = currentFunctionValue;
        for(int j = 0; j < n; j++){
            currentFunctionValue = currentFunctionValue + totalSum - (n * nums[n - j - 1]);
            maxValue = Math.max(maxValue, currentFunctionValue);
        }
        return maxValue;
    }}
