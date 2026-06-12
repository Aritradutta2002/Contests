package com.aritra.contests.leetcode;

import java.util.*;

/*
 * 2657. Find the Prefix Common Array of Two Arrays
 *
 * You are given two 0-indexed integer permutations A and B of length n.
 * A prefix common array of A and B is an array C such that C[i] is equal to
 * the count of numbers that are present at or before the index i in both A and B.
 * Return the prefix common array of A and B.
 *
 * Constraints:
 * - 1 <= A.length == B.length == n <= 50
 * - 1 <= A[i], B[i] <= n
 * - It is guaranteed that A and B are both permutations of length n.
 */
public class LC2657_Find_The_Prefix_Common_Array_Of_Two_Arrays {

    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] ans = new int[n];
        int[] freq = new int[n + 1];
        int common = 0;
        for (int i = 0; i < n; i++) {
            if (++freq[A[i]] == 2) {
                common++;
            }
            if (++freq[B[i]] == 2) {
                common++;
            }
            ans[i] = common;
        }
        return ans;
    }

    public static void main(String[] args) {
        LC2657_Find_The_Prefix_Common_Array_Of_Two_Arrays solver = new LC2657_Find_The_Prefix_Common_Array_Of_Two_Arrays();

        // Test Case 1: Permutations of length 4
        int[] A1 = { 1, 3, 2, 4 };
        int[] B1 = { 3, 1, 2, 4 };
        int[] expected1 = { 0, 2, 3, 4 };
        runTest(solver, 1, A1, B1, expected1);

        // Test Case 2: Permutations of length 3
        int[] A2 = { 2, 3, 1 };
        int[] B2 = { 3, 1, 2 };
        int[] expected2 = { 0, 1, 3 };
        runTest(solver, 2, A2, B2, expected2);

        // Test Case 3: Permutations of length 1 (minimal constraint)
        int[] A3 = { 1 };
        int[] B3 = { 1 };
        int[] expected3 = { 1 };
        runTest(solver, 3, A3, B3, expected3);
    }

    private static void runTest(LC2657_Find_The_Prefix_Common_Array_Of_Two_Arrays solver, int testId, int[] A, int[] B,
            int[] expected) {
        try {
            int[] result = solver.findThePrefixCommonArray(A, B);
            if (Arrays.equals(result, expected)) {
                System.out.println("Test " + testId + ": PASS");
            } else {
                System.out.println("Test " + testId + ": FAIL");
                System.out.println("  Expected: " + Arrays.toString(expected));
                System.out.println("  Actual:   " + Arrays.toString(result));
            }
        } catch (UnsupportedOperationException e) {
            System.out.println("Test " + testId + ": SKIPPED (Not implemented)");
        } catch (Exception e) {
            System.out.println("Test " + testId + ": ERROR (" + e.getMessage() + ")");
        }
    }
}
