package com.leetcode;
import java.util.*;
/*
 * 2145. Count the Hidden Sequences
 *
 * Given a differences array and lower/upper bounds, count the number of possible hidden sequences
 * consistent with the differences where all values stay within the bounds.
 *
 * Constraints:
 * - n == differences.length + 1
 * - 1 <= n <= 10^5
 * - -10^5 <= differences[i] <= 10^5
 * - -10^5 <= lower <= upper <= 10^5
 */
public class LC2145_Count_The_Hidden_Sequences {
    public static int numberOfArrays(int[] differences, int lower, int upper) {
        int n = differences.length;
        long[] prefixSum = new long[n + 1];
        prefixSum[0] = 0;
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + differences[i - 1];
        }
        long minPrefix = Long.MAX_VALUE;
        long maxPrefix = Long.MIN_VALUE;
        for (int i = 0; i <= n; i++) {
            minPrefix = Math.min(minPrefix, prefixSum[i]);
            maxPrefix = Math.max(maxPrefix, prefixSum[i]);
        }
        long minValue = lower - minPrefix;
        long maxValue = upper - maxPrefix;
        if (minValue > maxValue) {
            return 0;
        }
        return (int) (maxValue - minValue + 1);
    }
}

