package com.aritra.contests.leetcode;
import java.util.*;
/*
 * 2946. Matrix Similarity After Cyclic Shifts
 * 
 * You are given a 0-indexed m x n integer matrix mat and an integer k.
 * You have to cyclically right shift odd indexed rows k times and cyclically
 * left shift even indexed rows k times.
 * Return true if the initial and final matrix are exactly the same and false otherwise.
 * 
 * Constraints:
 * - 1 <= mat.length <= 25
 * - 1 <= mat[i].length <= 25
 * - 1 <= mat[i][j] <= 25
 * - 1 <= k <= 50
 */
public class LC2946_Matrix_Similarity_After_Cyclic_Shifts {
    public boolean areSimilar(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;
        k = k % m;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][(j + k) % m] != mat[i][j]) return false;
            }
        }
        return true;
    }
    private static void runTest(LC2946_Matrix_Similarity_After_Cyclic_Shifts solver, int testId, int[][] mat, int k, boolean expected) {
        try {
            boolean result = solver.areSimilar(mat, k);
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
