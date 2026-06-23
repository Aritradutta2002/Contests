package com.aritra.contests.leetcode;
import java.lang.*;
import java.util.*;
/*
 * 2444. Count Subarrays with Fixed Bounds
 *
 * You are given an integer array nums and two integers minK and maxK. Return the number of subarrays
 * where the minimum element is exactly minK and the maximum element is exactly maxK.
 *
 * Constraints:
 * - 2 <= nums.length <= 10^5
 * - 0 <= nums[i] <= 10^6
 * - 0 <= minK <= maxK <= 10^6
 */
public class LC2444_Count_Subarrays_With_Fixed_Bounds {
    public static long countSubarrays(int[] nums, int minK, int maxK) {
        long total = 0;
        int lastInvalid = -1, lastMin = -1, lastMax = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minK || nums[i] > maxK) lastInvalid = i;
            if (nums[i] == minK) lastMin = i;
            if (nums[i] == maxK) lastMax = i;

            int validStart = Math.min(lastMin, lastMax);
            total += Math.max(0, validStart - lastInvalid);
        }

        return total;
    }

}
