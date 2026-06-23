package com.aritra.contests.leetcode;

import java.util.Scanner;

/*
 * 1404. Number of Steps to Reduce a Number in Binary Representation to One
 *
 * Given the binary representation of an integer as a string s, return the number of steps to reduce
 * it to 1 under the rules: If the number is even, divide by 2. If odd, subtract 1.
 *
 * Constraints:
 * - 1 <= s.length <= 500
 * - s consists of characters '0' or '1'
 * - s[0] == '1'
 */
public class LC1404_Number_Of_Steps_To_Reduce_A_Number_In_Binary_Representation_To_One {
    public static int numSteps(String s) {
        int steps = 0;
        int carry = 0;
        for (int i = s.length() - 1; i > 0; i--) {
            if (s.charAt(i) - '0' + carry == 1) {
                carry = 1;
                steps += 2;
            } else {
                steps += 1;
            }
        }
        return steps + carry;
    }
}