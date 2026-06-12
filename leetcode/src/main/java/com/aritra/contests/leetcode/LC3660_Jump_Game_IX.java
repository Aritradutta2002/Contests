package com.aritra.contests.leetcode;
import java.util.*;
/*
 * 3660. Jump Game IX
 *
 * Description:
 * You are given an integer array nums. From index i, you may jump forward to
 * an index j > i only if nums[j] < nums[i], or backward to an index j < i only
 * if nums[j] > nums[i]. For each index, return the maximum value reachable by
 * following any sequence of valid jumps.
 *
 * Constraints:
 * - 1 <= nums.length <= 10^5
 * - 1 <= nums[i] <= 10^9
 */
public class LC3660_Jump_Game_IX {

    public int[] maxValue(int[] nums) {
        int n = nums.length;
        int[] prefixMax = new int[n];
        int[] suffixMin = new int[n];
        int[] ans = new int[n];

        prefixMax[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
        }

        suffixMin[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(suffixMin[i + 1], nums[i]);
        }

        int start = 0;
        int componentMax = nums[0];
        for (int i = 0; i < n; i++) {
            componentMax = Math.max(componentMax, nums[i]);
            boolean isBoundary = (i == n - 1) || (prefixMax[i] <= suffixMin[i + 1]);
            if (isBoundary) {
                for (int j = start; j <= i; j++) {
                    ans[j] = componentMax;
                }
                if (i + 1 < n) {
                    start = i + 1;
                    componentMax = nums[start];
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        LC3660_Jump_Game_IX solution = new LC3660_Jump_Game_IX();

        int[] nums1 = { 2, 1, 3 };
        int[] expected1 = { 2, 2, 3 };
        testCase(solution, nums1, expected1, "Test 1");

        int[] nums2 = { 2, 3, 1 };
        int[] expected2 = { 3, 3, 3 };
        testCase(solution, nums2, expected2, "Test 2");

        int[] nums3 = { 5 };
        int[] expected3 = { 5 };
        testCase(solution, nums3, expected3, "Test 3");
    }

    private static void testCase(LC3660_Jump_Game_IX solution, int[] nums, int[] expected, String testName) {
        try {
            int[] actual = solution.maxValue(nums);
            if (Arrays.equals(actual, expected)) {
                System.out.println(testName + ": Pass");
            } else {
                System.out.println(testName + ": Fail");
                System.out.println("  Expected: " + Arrays.toString(expected));
                System.out.println("  Actual:   " + Arrays.toString(actual));
            }
        } catch (UnsupportedOperationException ex) {
            System.out.println(testName + ": PENDING IMPLEMENTATION");
        }
    }
}
