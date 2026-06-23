package com.aritra.contests.leetcode;

import java.io.*;
import java.util.*;

public class LC2962_Count_Subarrays_Where_Max_Element_Appears_At_Least_K_Times_B {

    /**
     * Counts how many subarrays of nums have the global maximum (maxVal)
     * appearing at least k times.
     */

    public static long countSubarrays(int[] nums, int maxVal, int k) {
        int n = nums.length;
        long result = 0;
        int countMax = 0;
        int right = 0;

        // Slide the window [left..right)
        for (int left = 0; left < n; left++) {
            // Expand right until we have k occurrences of maxVal
            while (right < n && countMax < k) {
                if (nums[right++] == maxVal) {
                    countMax++;
                }
            }
            // If we never reached k, no further windows will either
            if (countMax < k) {
                break;
            }
            // All subarrays starting at 'left' with end in [right-1..n-1] are valid
            result += (n - right + 1);

            // Before moving left forward, remove its contribution
            if (nums[left] == maxVal) {
                countMax--;
            }
        }
        return result;
    }
}

