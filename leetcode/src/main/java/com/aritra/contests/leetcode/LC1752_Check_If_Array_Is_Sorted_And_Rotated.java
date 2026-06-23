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
