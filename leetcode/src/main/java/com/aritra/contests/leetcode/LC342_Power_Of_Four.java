package com.aritra.contests.leetcode;

import java.util.*;

/**
 * 342. Power of Four
 * 
 * Problem Statement:
 * Given an integer n, return true if it is a power of four. Otherwise, return false.
 * An integer n is a power of four, if there exists an integer x such that n == 4^x.
 * 
 * Constraints:
 * - -2^31 <= n <= 2^31 - 1
 * 
 * Follow up: Could you solve it without loops/recursion?
 */
public class LC342_Power_Of_Four {

    public boolean isPowerOfFour(int n) {
        if(n == 1) return true;
        if(n <= 0) return false;
        if(n > 0){
            while(n % 4 == 0){
                n = n/4;
            }
        }
        return n == 1;
    }

    public static void main(String[] args) {
        LC342_Power_Of_Four solution = new LC342_Power_Of_Four();

        // Test Cases
        int[] testCases = {16, 5, 1};
        boolean[] expectedOutputs = {true, false, true};

        boolean allPassed = true;

        for (int i = 0; i < testCases.length; i++) {
            System.out.print("Test Case " + (i + 1) + ": ");
            try {
                boolean result = solution.isPowerOfFour(testCases[i]);
                if (result == expectedOutputs[i]) {
                    System.out.println("PASS");
                } else {
                    System.out.println("FAIL (Expected " + expectedOutputs[i] + ", got " + result + ")");
                    allPassed = false;
                }
            } catch (UnsupportedOperationException e) {
                System.out.println("SKIPPED (Not implemented yet)");
                allPassed = false;
            } catch (Exception e) {
                System.out.println("FAIL (Exception: " + e.getMessage() + ")");
                allPassed = false;
            }
        }

        System.out.println("========================================");
        if (allPassed) {
            System.out.println("All test cases passed!");
        } else {
            System.out.println("Some test cases failed or were skipped.");
        }
    }
}
