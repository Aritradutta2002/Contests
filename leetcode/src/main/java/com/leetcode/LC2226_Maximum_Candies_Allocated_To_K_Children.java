package com.leetcode;

import java.util.*;

/*
 * 2226. Maximum Candies Allocated to K Children
 *
 * You are given an array candies where each element is the size of a pile of candies. You want to
 * allocate candies to k children such that each child gets the same number of candies, each child
 * gets candies from one pile only, and every child gets the maximum possible number of candies.
 * Return the maximum number of candies each child can get.
 *
 * Constraints:
 * - 1 <= candies.length <= 10^5
 * - 1 <= candies[i] <= 10^7
 * - 1 <= k <= 10^12
 */
public class LC2226_Maximum_Candies_Allocated_To_K_Children {
    public static int maximumCandies(int[] candies, long k) {
        if (candies == null || candies.length == 0) {
            return 0;
        }
        long sum = candies[0];
        int maxCount = candies[0];
        int n = candies.length;
        for (int i = 1; i < n; i++) {
            maxCount = Math.max(maxCount, candies[i]);
            sum += candies[i];
        }

        if (sum < k) {
            return 0;
        }

        int left = 1;
        int right = maxCount;
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canDistribute(candies, mid, k)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
    public static boolean canDistribute(int[] candies, int mid, long k) {
        long count = 0;
        for (int candy : candies) {
            count += candy / mid;
        }
        return count >= k;
    }
}

