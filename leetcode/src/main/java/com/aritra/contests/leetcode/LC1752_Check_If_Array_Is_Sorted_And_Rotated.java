package com.aritra.contests.leetcode;

import java.util.*;

/*
 * 1752. Check if Array Is Sorted and Rotated
 *
 * Given an array nums, return true if the array was originally sorted in non-decreasing order,
 * then rotated some number of positions (including zero). Otherwise, return false.
 * There may be duplicates in the original array.
 * Note: An array A rotated by x positions results in an array B of the same length such that
 * A[i] == B[(i+x) % A.length] for every valid index i.
 *
 * Constraints:
 * - 1 <= nums.length <= 100
 * - 1 <= nums[i] <= 100
 */
public class LC1752_Check_If_Array_Is_Sorted_And_Rotated {
    public boolean check(int[] nums) {
        int count = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) count++;
            if (count > 1) return false;
        }
        return true;
    }
}
