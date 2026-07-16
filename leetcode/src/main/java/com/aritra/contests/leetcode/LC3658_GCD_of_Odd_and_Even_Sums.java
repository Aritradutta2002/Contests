package com.aritra.contests.leetcode;

/**
 * 3658. GCD of Odd and Even Sums
 *
 * You are given an integer n. Your task is to compute the GCD (greatest common
 * divisor)
 * of two values:
 * - sumOdd: the sum of the smallest n positive odd numbers.
 * - sumEven: the sum of the smallest n positive even numbers.
 * Return the GCD of sumOdd and sumEven.
 *
 * Constraints:
 * - 1 <= n <= 10^100
 *
 * Example 1:
 * Input: n = 4
 * Output: 4
 * Explanation:
 * - sumOdd = 1 + 3 + 5 + 7 = 16
 * - sumEven = 2 + 4 + 6 + 8 = 20
 * - GCD(16, 20) = 4
 *
 * Example 2:
 * Input: n = 5
 * Output: 5
 * Explanation:
 * - sumOdd = 1 + 3 + 5 + 7 + 9 = 25
 * - sumEven = 2 + 4 + 6 + 8 + 10 = 30
 * - GCD(25, 30) = 5
 */
class LC3658_GCD_of_Odd_and_Even_Sums {

    /**
     * Mathematical insight:
     * - Sum of first n odd numbers  = n²
     *   (e.g., n=4: 1+3+5+7 = 16 = 4²)
     * - Sum of first n even numbers = n(n+1)
     *   (e.g., n=4: 2+4+6+8 = 20 = 4×5)
     *
     * Now, GCD(n², n(n+1)):
     *   = n × GCD(n, n+1)     -- factor out the common n
     *   = n × 1               -- consecutive integers are always coprime
     *   = n
     *
     * Therefore, the GCD of sumOdd and sumEven is always n itself.
     * No loops or GCD computation needed — O(1) time and space.
     */
    public int gcdOfOddEvenSums(int n) {
        return n;
    }
}
