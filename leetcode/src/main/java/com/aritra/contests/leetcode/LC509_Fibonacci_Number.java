package com.aritra.contests.leetcode;

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

    // ─── Test Harness ────────────────────────────────────────────────────
    public static void main(String[] args) {
        LC509_Fibonacci_Number sol = new LC509_Fibonacci_Number();

        int testNum = 0;
        int passed = 0;

        // ── Official Sample Tests ────────────────────────────────────────
        passed += runTest(sol, ++testNum, 2, 1);
        passed += runTest(sol, ++testNum, 3, 2);
        passed += runTest(sol, ++testNum, 4, 3);

        // ── Extra Sanity Tests ───────────────────────────────────────────
        passed += runTest(sol, ++testNum, 0, 0); // base case F(0) = 0
        passed += runTest(sol, ++testNum, 1, 1); // base case F(1) = 1
        passed += runTest(sol, ++testNum, 10, 55); // F(10) = 55

        System.out.println("\n" + passed + " / " + testNum + " tests passed.");
    }

    private static int runTest(
            LC509_Fibonacci_Number sol,
            int testNum, int input, int expected) {

        System.out.printf("Test %d: n = %d, expected = %d  =>  ", testNum, input, expected);
        try {
            int result = sol.fib(input);
            if (result == expected) {
                System.out.println("PASS");
                return 1;
            } else {
                System.out.printf("FAIL (got %d)%n", result);
                return 0;
            }
        } catch (UnsupportedOperationException e) {
            System.out.println("SKIPPED");
            return 0;
        }
    }
}
