package com.aritra.contests.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * 3312. Sorted GCD Pair Queries
 *
 * You are given an integer array nums of length n and an integer array queries.
 * Let gcdPairs denote an array obtained by calculating the GCD of all possible pairs (nums[i], nums[j]),
 * where 0 <= i < j < n, and then sorting these values in ascending order.
 * For each query queries[i], you need to find the element at index queries[i] in gcdPairs.
 * Return an integer array answer, where answer[i] is the value at gcdPairs[queries[i]] for each query.
 *
 * Constraints:
 * - 2 <= n == nums.length <= 10^5
 * - 1 <= nums[i] <= 5 * 10^4
 * - 1 <= queries.length <= 10^5
 * - 0 <= queries[i] < n * (n - 1) / 2
 */
public class LC3312_Sorted_GCD_Pair_Queries {
    /**
     * Calculates the GCD of all pairs, sorts them, and returns values at the specified query indices.
     *
     * @param nums    the input array of integers
     * @param queries the array of indices to query
     * @return an array containing the GCD values at the specified query indices
     */
    public int[] gcdValues(int[] nums, long[] queries) {
        if (nums == null || nums.length < 2 || queries == null || queries.length == 0) {
            return new int[0];
        }

        int maxValue = Arrays.stream(nums).max().orElse(0);
        int[] freq = new int[maxValue + 1];
        for (int value : nums) {
            freq[value]++;
        }

        long[] pairsMultipleOfD = new long[maxValue + 1];
        for (int d = 1; d <= maxValue; d++) {
            int count = 0;
            for (int multiple = d; multiple <= maxValue; multiple += d) {
                count += freq[multiple];
            }
            if (count >= 2) {
                pairsMultipleOfD[d] = (long) count * (count - 1) / 2;
            }
        }

        long[] exactGcdPairs = new long[maxValue + 1];
        for (int d = maxValue; d >= 1; d--) {
            long total = pairsMultipleOfD[d];
            for (int multiple = d + d; multiple <= maxValue; multiple += d) {
                total -= exactGcdPairs[multiple];
            }
            exactGcdPairs[d] = total;
        }

        long totalPairs = 0;
        for (int d = 1; d <= maxValue; d++) {
            totalPairs += exactGcdPairs[d];
        }

        int[] answer = new int[queries.length];
        if (totalPairs == 0) {
            return answer;
        }

        Integer[] queryOrder = IntStream.range(0, queries.length).boxed().toArray(Integer[]::new);
        Arrays.sort(queryOrder, Comparator.comparingLong(index -> queries[index]));

        int queryIndex = 0;
        long currentStart = 0;
        for (int d = 1; d <= maxValue && queryIndex < queryOrder.length; d++) {
            long count = exactGcdPairs[d];
            if (count <= 0) {
                continue;
            }

            long currentEnd = currentStart + count;
            while (queryIndex < queryOrder.length && queries[queryOrder[queryIndex]] < currentEnd) {
                answer[queryOrder[queryIndex]] = d;
                queryIndex++;
            }
            currentStart = currentEnd;
        }

        return answer;
    }
}