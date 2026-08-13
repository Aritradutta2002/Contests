package com.leetcode;
/*
 * 1846. Maximum Element After Decreasing and Rearranging
 *
 * Description:
 * You are given an array of positive integers arr. Perform some operations
 * (possibly none) on arr so that it satisfies these conditions:
 *   - The first element in arr must equal 1.
 *   - After that, the difference between any two adjacent elements must be
 *     at most 1. In other words, arr[i + 1] - arr[i] <= 1 for
 *     0 <= i < n - 1.
 *   - The value of the last element must be at most n (n is the length of
 *     the array).
 * Return the maximum possible value of the last element of arr after
 * performing operations.
 *
 * Constraints:
 *   1 <= arr.length <= 10^5
 *   1 <= arr[i] <= 10^9
 *
 * Example 1:
 *   arr = [2, 2, 1, 2, 1] -> 2
 * Example 2:
 *   arr = [100, 1, 1000] -> 3
 * Example 3:
 *   arr = [1, 2, 3, 4, 5] -> 5
 */
public class LC1846_Maximum_Element_After_Decreasing_And_Rearranging {

    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        java.util.Arrays.sort(arr);
        int max = 1; // first element must be 1
        for (int i = 1; i < arr.length; i++) {
            // each element can be at most prev + 1
            max = Math.min(arr[i], max + 1);
        }
        return max;
    }
}