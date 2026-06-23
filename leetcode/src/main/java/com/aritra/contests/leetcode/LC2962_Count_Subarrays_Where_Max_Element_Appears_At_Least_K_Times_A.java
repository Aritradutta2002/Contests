package com.aritra.contests.leetcode;

import java.util.*;

public class LC2962_Count_Subarrays_Where_Max_Element_Appears_At_Least_K_Times_A {
    public static long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        long ans = 0;
        int count = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
        }

        for (var x : nums) {
            while (j < n && count < k) {
                count += (nums[j] == max) ? 1 : 0;
                j++;
            }
            if (count < k) {
                break;
            }
            ans += n - j + 1;
            count -= x == max ? 1 : 0;
        }
        return ans;
    }
}

