package com.aritra.contests.leetcode;

import java.util.*;
/*
 * 2615. Sum of Distances
 *
 * You are given a 0-indexed integer array nums.
 * There exists an array arr of length nums.length, where arr[i] is the sum of
 * |i - j| over all j such that nums[j] == nums[i] and j != i.
 * If there is no such j, set arr[i] to be 0.
 * Return the array arr.
 *
 * Key Constraints:
 * - 1 <= nums.length <= 10^5
 * - 0 <= nums[i] <= 10^9
 */

public class LC2615_Sum_Of_Distances {

    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] ans = new long[n];

        Map<Integer, Long> cnt = new HashMap<>();
        Map<Integer, Long> sum = new HashMap<>();

        // Left contributions
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            long c = cnt.getOrDefault(x, 0L);
            long s = sum.getOrDefault(x, 0L);

            ans[i] += c * i - s;

            cnt.put(x, c + 1);
            sum.put(x, s + i);
        }

        cnt.clear();
        sum.clear();

        for (int i = n - 1; i >= 0; i--) {
            int x = nums[i];
            long c = cnt.getOrDefault(x, 0L);
            long s = sum.getOrDefault(x, 0L);

            ans[i] += s - c * i;

            cnt.put(x, c + 1);
            sum.put(x, s + i);
        }

        return ans;
    }

    public static void main(String[] args) {
        LC2615_Sum_Of_Distances solver = new LC2615_Sum_Of_Distances();
        // Test case 1
        int[] nums1 = { 1, 3, 1, 1, 2 };
        long[] expected1 = { 5, 0, 3, 4, 0 };
        long[] result1 = solver.distance(nums1);
        System.out.println("Test 1: " + Arrays.toString(result1));
        assert Arrays.equals(result1, expected1) : "Test 1 failed";

        // Test case 2
        int[] nums2 = { 0, 5, 3 };
        long[] expected2 = { 0, 0, 0 };
        long[] result2 = solver.distance(nums2);
        System.out.println("Test 2: " + Arrays.toString(result2));
        assert Arrays.equals(result2, expected2) : "Test 2 failed";

        // Test case 3
        int[] nums3 = { 1, 1, 1, 1 };
        long[] expected3 = { 6, 4, 4, 6 };
        long[] result3 = solver.distance(nums3);
        System.out.println("Test 3: " + Arrays.toString(result3));
        assert Arrays.equals(result3, expected3) : "Test 3 failed";

        System.out.println("All tests passed.");
    }
}
