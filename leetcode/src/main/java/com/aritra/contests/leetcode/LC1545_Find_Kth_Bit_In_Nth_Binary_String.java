package com.aritra.contests.leetcode;
import java.util.*;

public class LC1545_Find_Kth_Bit_In_Nth_Binary_String {
    public char findKthBit(int n, int k) {
        if (n == 1) return '0';
        int len = (1 << n) - 1;
        int mid = 1 << (n - 1);
        
        if (k == mid) return '1';
        
        if (k < mid) {
            return findKthBit(n - 1, k);
        } 
        else {
            int newK = len - k + 1;
            char bit = findKthBit(n - 1, newK);
            return bit == '0' ? '1' : '0';
        }
    }

    public static void main(String[] args) {
        LC1545_Find_Kth_Bit_In_Nth_Binary_String solver = new LC1545_Find_Kth_Bit_In_Nth_Binary_String();
        int[][] testInputs = {
            {1, 1},
            {2, 3},
            {3, 1},
            {3, 7},
            {4, 11}
        };

        char[] expected = {'0', '1', '0', '1', '1'};

        int passed = 0;
        for (int i = 0; i < testInputs.length; i++) {
            int n = testInputs[i][0];
            int k = testInputs[i][1];
            char expectedValue = expected[i];

            try {
                char actual = solver.findKthBit(n, k);
                boolean ok = actual == expectedValue;
                if (ok) {
                    passed++;
                }
                System.out.println(
                    "Test " + (i + 1) + " -> n=" + n + ", k=" + k
                    + " | expected=" + expectedValue
                    + ", actual=" + actual
                    + " | " + (ok ? "PASS" : "FAIL")
                );
            } catch (Exception e) {
                System.out.println(
                    "Test " + (i + 1) + " -> n=" + n + ", k=" + k
                    + " | expected=" + expectedValue
                    + " | EXCEPTION: " + e.getMessage()
                    + " | FAIL"
                );
            }
        }

        System.out.println("\nSummary: " + passed + "/" + testInputs.length + " tests passed.");
    }
}
