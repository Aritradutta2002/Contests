package com.aritra.contests.leetcode;

import java.util.*;

/**
 * 1291. Sequential Digits
 *
 * An integer has sequential digits if and only if each digit in the number is
 * one more than the previous digit.
 *
 * Return a sorted list of all the integers in the range [low, high] inclusive
 * that have sequential digits.
 *
 * Constraints:
 * - 10 <= low <= high <= 10^9
 *
 * Example 1:
 * Input: low = 100, high = 300
 * Output: [123,234]
 *
 * Example 2:
 * Input: low = 1000, high = 13000
 * Output: [1234,2345,3456,4567,5678,6789,12345]
 */
class LC1291_Sequential_Digits {

    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();

        for (int startDigit = 1; startDigit <= 9; startDigit++) {
            long num = startDigit;
            int nextDigit = startDigit + 1;
            while (nextDigit <= 9) {
                num = num * 10 + nextDigit;
                if (num > high) {
                    break;
                }
                if (num >= low) {
                    result.add((int) num);
                }
                nextDigit++;
            }
        }

        Collections.sort(result);
        return result;
    }
}
