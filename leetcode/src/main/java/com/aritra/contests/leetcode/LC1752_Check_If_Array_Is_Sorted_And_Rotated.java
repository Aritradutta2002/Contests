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
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public static void main(String[] args) {
        LC1752_Check_If_Array_Is_Sorted_And_Rotated solver = new LC1752_Check_If_Array_Is_Sorted_And_Rotated();

        // Test Case 1: Rotated sorted array [3, 4, 5, 1, 2] -> Expected: true
        int[] nums1 = {3, 4, 5, 1, 2};
        runTest(solver, 1, nums1, true);

        // Test Case 2: Array that is not sorted/rotated [2, 1, 3, 4] -> Expected: false
        int[] nums2 = {2, 1, 3, 4};
        runTest(solver, 2, nums2, false);

        // Test Case 3: Already sorted array (0 rotation) [1, 2, 3] -> Expected: true
        int[] nums3 = {1, 2, 3};
        runTest(solver, 3, nums3, true);
    }

    private static void runTest(LC1752_Check_If_Array_Is_Sorted_And_Rotated solver, int testId, int[] nums, boolean expected) {
        try {
            boolean actual = solver.check(nums);
            if (Boolean.valueOf(actual).equals(expected)) {
                System.out.println("Test " + testId + ": PASS");
            } else {
                System.out.println("Test " + testId + ": FAIL");
            }
        } catch (UnsupportedOperationException e) {
            System.out.println("Test " + testId + ": SKIPPED (Not implemented)");
        } catch (Exception e) {
            System.out.println("Test " + testId + ": ERROR (" + e.getMessage() + ")");
        }
    }
}
