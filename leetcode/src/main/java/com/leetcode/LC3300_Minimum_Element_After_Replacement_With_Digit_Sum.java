package com.leetcode;
import java.util.*;
/*
 * 3300. Minimum Element After Replacement With Digit Sum
 *
 * You are given an integer array nums.
 * You replace each element in nums with the sum of its digits.
 * Return the minimum element in nums after all replacements.
 *
 * Constraints:
 *   - 1 <= nums.length <= 100
 *   - 1 <= nums[i] <= 10^4
 */

class LC3300_Minimum_Element_After_Replacement_With_Digit_Sum {

    public int minElement(int[] nums) {
        int n = nums.length;
        int minimum = Integer.MAX_VALUE;
        for(int i : nums){
            minimum = Math.min(minimum, digitSum(i));
        }
        return minimum;
    }
    public int digitSum (int n) {
        int sum = 0;
        while(n >  0){
            sum += n%10;
            n /= 10;
        }
        return sum;
    }}
