package com.aritra.contests.leetcode;

import java.util.Scanner;

/*
 * 1726. Tuple with Same Product
 *
 * Given an array nums of distinct positive integers, return the number of tuples (a, b, c, d) such
 * that a * b = c * d and a, b, c, d are distinct elements.
 *
 * Constraints:
 * - 1 <= nums.length <= 1000
 * - 1 <= nums[i] <= 10^4
 * - All elements are distinct
 */
public class LC1726_Tuple_With_Same_Product {
    static public int tupleSameProduct(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (nums[i] * nums[j] == nums[j + 1] * nums[i + 1]) {
                    count++;
                }
            }
        }
        return count;
    }
}
