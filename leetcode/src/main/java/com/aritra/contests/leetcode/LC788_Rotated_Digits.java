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
    }}
