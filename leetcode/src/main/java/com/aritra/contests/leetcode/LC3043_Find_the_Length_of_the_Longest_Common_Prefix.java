package com.aritra.contests.leetcode;

import java.util.*;

/*
 * 3043. Find the Length of the Longest Common Prefix
 *
 * You are given two arrays with positive integers arr1 and arr2.
 * A prefix of a positive integer is an integer formed by one or more of its digits, starting from its leftmost digit.
 * A common prefix of two integers a and b is an integer c, such that c is a prefix of both a and b.
 * 
 * Find the length of the longest common prefix among all pairs of integers (x, y) such that x belongs to arr1 and y belongs to arr2.
 * If no common prefix exists, return 0.
 *
 * Constraints:
 * - 1 <= arr1.length, arr2.length <= 5 * 10^4
 * - 1 <= arr1[i], arr2[i] <= 10^8
 */
public class LC3043_Find_the_Length_of_the_Longest_Common_Prefix {

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<String> set = new HashSet<>();
        for (int num : arr1) {
            String s = String.valueOf(num);
            for (int i = 1; i <= s.length(); i++) {
                set.add(s.substring(0, i));
            }
        }

        int maxLen = 0;
        for (int num : arr2) {
            String s = String.valueOf(num);
            for (int i = 1; i <= s.length(); i++) {
                String prefix = s.substring(0, i);
                if (set.contains(prefix)) {
                    maxLen = Math.max(maxLen, prefix.length());
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LC3043_Find_the_Length_of_the_Longest_Common_Prefix solver = new LC3043_Find_the_Length_of_the_Longest_Common_Prefix();

        // Test Case 1
        int[] arr1_1 = { 1, 10, 100 };
        int[] arr2_1 = { 1000 };
        runTest(solver, 1, arr1_1, arr2_1, 3);

        // Test Case 2
        int[] arr1_2 = { 1, 2, 3 };
        int[] arr2_2 = { 4, 4, 4 };
        runTest(solver, 2, arr1_2, arr2_2, 0);

        // Test Case 3
        int[] arr1_3 = { 12, 123 };
        int[] arr2_3 = { 124, 12345 };
        runTest(solver, 3, arr1_3, arr2_3, 3);
    }

    private static void runTest(LC3043_Find_the_Length_of_the_Longest_Common_Prefix solver, int testId, int[] arr1,
            int[] arr2, int expected) {
        try {
            int result = solver.longestCommonPrefix(arr1, arr2);
            if (result == expected) {
                System.out.println("Test " + testId + ": PASS");
            } else {
                System.out.println("Test " + testId + ": FAIL");
                System.out.println("  Expected: " + expected);
                System.out.println("  Actual:   " + result);
            }
        } catch (UnsupportedOperationException e) {
            System.out.println("Test " + testId + ": SKIPPED (Not implemented)");
        } catch (Exception e) {
            System.out.println("Test " + testId + ": ERROR (" + e.getMessage() + ")");
        }
    }
}
