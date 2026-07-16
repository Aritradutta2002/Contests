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
}
