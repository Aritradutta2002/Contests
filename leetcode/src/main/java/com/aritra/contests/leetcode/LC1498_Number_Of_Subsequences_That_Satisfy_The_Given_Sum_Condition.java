package com.aritra.contests.leetcode;

import java.util.*;

/*
 *   Author : Aritra
 *   Created On: Sunday,29.06.2025 01:16 pm
 */

/*
 You are given an array of integers nums and an integer target.
 Return the number of non-empty subsequences of nums such that the sum of
 the minimum and maximum element on it is less or equal to the target.
 Since the answer may be too large, return it modulo 109 + 7.
 */

public class LC1498_Number_Of_Subsequences_That_Satisfy_The_Given_Sum_Condition {
    public static int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int mod = (int) 1e9 + 7;
        int l = 0, r = n - 1;

        while(l <= r){
            if(nums[l] + nums[r] > target){
                r--;
            } else{
                int count = r - l + 1;
                int result = 1;
                for(int i = 0; i < count; i++){
                    result = (result * 2) % mod;
                }
                return result - 1;
            }
        }

        return 0;
    }
}

