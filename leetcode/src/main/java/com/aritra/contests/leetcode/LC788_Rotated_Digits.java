package com.aritra.contests.leetcode;

import java.util.*;

/**
 * 788. Rotated Digits
 * 
 * An integer x is a good number if after rotating each of its digits
 * individually
 * by 180 degrees, we get a valid number that is different from x.
 * Valid digits are 0, 1, 8 (rotate to themselves) and 2, 5 and 6, 9 (rotate to
 * each other).
 * 3, 4, 7 are invalid.
 * 
 * Given an integer n, return the number of good integers in the range [1, n].
 * 
 * Constraints:
 * - 1 <= n <= 10^4
 */
public class LC788_Rotated_Digits {

    public int rotatedDigits(int n) {
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isGood(i)) {
                count++;
            }
        }
        return count;
    }

    public boolean isGood(int n) {
        int curr = n;
        boolean isValid = false;
        while (n > 0) {
            int digit = n % 10;
            n /= 10;
            if (digit == 3 || digit == 4 || digit == 7) {
                return false;
            }
            if (digit == 2 || digit == 5 || digit == 6 || digit == 9) {
                isValid = true;
            }
        }
        return isValid;
    }

    public static void main(String[] args) {
        LC788_Rotated_Digits solution = new LC788_Rotated_Digits();

        System.out.println("--- Test 788. Rotated Digits ---");

        // Test Case 1
        try {
            int res1 = solution.rotatedDigits(10);
            System.out.println("Test 1 (n=10): " + res1 + " -> " + (res1 == 4 ? "Pass" : "Fail"));
            // Expected: 4
        } catch (UnsupportedOperationException e) {
            System.out.println("Test 1: " + e.getMessage());
        }

        // Test Case 2
        try {
            int res2 = solution.rotatedDigits(1);
            System.out.println("Test 2 (n=1): " + res2 + " -> " + (res2 == 0 ? "Pass" : "Fail"));
            // Expected: 0
        } catch (UnsupportedOperationException e) {
            System.out.println("Test 2: " + e.getMessage());
        }

        // Test Case 3
        try {
            int res3 = solution.rotatedDigits(2);
            System.out.println("Test 3 (n=2): " + res3 + " -> " + (res3 == 1 ? "Pass" : "Fail"));
            // Expected: 1
        } catch (UnsupportedOperationException e) {
            System.out.println("Test 3: " + e.getMessage());
        }
    }
}
