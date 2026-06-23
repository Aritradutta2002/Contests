package com.aritra.contests.leetcode;

import java.util.*;

/*
 * 3355. Zero Array Transformation I
 *
 * Given an array nums and queries (l, r, val), check if nums can be reduced to all zeros by
 * subtracting val from each element in the range [l, r] for each query.
 *
 * Constraints:
 * - 1 <= nums.length <= 10^5
 * - 0 <= nums[i] <= 10^5
 * - 1 <= queries.length <= 10^5
 * - queries[i].length == 2 (l, r)
 */
public class LC3355_Zero_Array_Transformation_I {
    public static boolean isZeroArray(int[] nums, int[][] queries) {
        int[] deltaArray = new int[nums.length + 1];
        for (int[] query : queries) {
            int left = query[0];
            int right = query[1];
            deltaArray[left] += 1;
            deltaArray[right + 1] -= 1;
        }
        int[] operationCounts = new int[deltaArray.length];
        int currentOperations = 0;
        for (int i = 0; i < deltaArray.length; i++) {
            currentOperations += deltaArray[i];
            operationCounts[i] = currentOperations;
        }
        for (int i = 0; i < nums.length; i++) {
            if (operationCounts[i] < nums[i]) {
                return false;
            }
        }
        return true;
    }
}

