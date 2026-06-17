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
    }}
