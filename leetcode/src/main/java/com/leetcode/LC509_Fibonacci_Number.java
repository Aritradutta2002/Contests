package com.leetcode;

/*
 * =============================================================================
 * LeetCode 509 – Fibonacci Number
 * =============================================================================
 *
 * DESCRIPTION:
 *   The Fibonacci numbers, commonly denoted F(n), form a sequence called the
 *   Fibonacci sequence, such that each number is the sum of the two preceding
 *   ones, starting from 0 and 1. That is,
 *
 *       F(0) = 0, F(1) = 1
 *       F(n) = F(n - 1) + F(n - 2), for n > 1
 *
 *   Given n, calculate F(n).
 *
 * CONSTRAINTS:
 *   - 0 <= n <= 30
 *
 * EXAMPLES:
 *
 *   Example 1:
 *     Input:  n = 2
 *     Output: 1
 *     Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
 *
 *   Example 2:
 *     Input:  n = 3
 *     Output: 2
 *     Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
 *
 *   Example 3:
 *     Input:  n = 4
 *     Output: 3
 *     Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 *
 * =============================================================================
 */
public class LC509_Fibonacci_Number {

    /**
     * Returns the n-th Fibonacci number.
     *
     * @param n non-negative integer (0 <= n <= 30)
     * @return F(n)
     */
    public int fib(int n) {
        if(n == 0 || n == 1) return n;
        int a = 0;
        int b = 1;
        int sum = 0;

        for(int i = 2; i <= n; i++){
            sum = (a + b);
            a = b;
            b = sum;
        }

        return sum;
    }
}
