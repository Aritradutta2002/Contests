package com.leetcode;

/*
 * 3754. Concatenate Non-Zero Digits and Multiply by Sum I
 *
 * Form x by concatenating all non-zero digits of n in their original order.
 * Return x multiplied by the sum of digits in x.
 */
public class LC3754_Concatenate_Non_Zero_Digits_And_Multiply_By_Sum_I {
    public static long concatenateNonZeroDigitsAndMultiplyBySum(int n) {
        long x = 0;
        int sum = 0;

        for (char digitChar : String.valueOf(n).toCharArray()) {
            int digit = digitChar - '0';
            if (digit == 0) {
                continue;
            }

            x = x * 10 + digit;
            sum += digit;
        }

        return x * sum;
    }
}