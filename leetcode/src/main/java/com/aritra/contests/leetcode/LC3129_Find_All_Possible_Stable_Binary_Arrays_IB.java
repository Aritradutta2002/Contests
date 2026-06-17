package com.aritra.contests.leetcode;

/*
 * =============================================================================
 * LeetCode 3129 – Find All Possible Stable Binary Arrays I
 * =============================================================================
 *
 * DESCRIPTION:
 *   You are given 3 positive integers zero, one, and limit.
 *
 *   A binary array arr is called stable if:
 *     1. The number of occurrences of 0 in arr is exactly zero.
 *     2. The number of occurrences of 1 in arr is exactly one.
 *     3. Each subarray of arr with a size greater than limit must contain
 *        both 0 and 1.
 *
 *   Return the total number of stable binary arrays.
 *
 *   Since the answer may be very large, return it modulo 10^9 + 7.
 *
 * CONSTRAINTS:
 *   - 1 <= zero, one, limit <= 200
 *
 * EXAMPLES:
 *
 *   Example 1:
 *     Input:  zero = 1, one = 1, limit = 2
 *     Output: 2
 *     Explanation: The two possible stable binary arrays are [1,0] and [0,1].
 *
 *   Example 2:
 *     Input:  zero = 1, one = 2, limit = 1
 *     Output: 1
 *     Explanation: The only possible stable binary array is [1,0,1].
 *
 *   Example 3:
 *     Input:  zero = 3, one = 3, limit = 2
 *     Output: 14
 *     Explanation: All the possible stable binary arrays are [0,0,1,0,1,1],
 *       [0,0,1,1,0,1], [0,1,0,0,1,1], [0,1,0,1,0,1], [0,1,0,1,1,0],
 *       [0,1,1,0,0,1], [0,1,1,0,1,0], [1,0,0,1,0,1], [1,0,0,1,1,0],
 *       [1,0,1,0,0,1], [1,0,1,0,1,0], [1,0,1,1,0,0], [1,1,0,0,1,0],
 *       [1,1,0,1,0,0].
 *
 * =============================================================================
 */
public class LC3129_Find_All_Possible_Stable_Binary_Arrays_IB {

    /**
     * Returns the number of stable binary arrays modulo 10^9 + 7.
     *
     * @param zero  number of 0s in the array (1 <= zero <= 200)
     * @param one   number of 1s in the array (1 <= one <= 200)
     * @param limit maximum allowed consecutive run of identical bits
     * @return count of stable binary arrays mod 10^9 + 7
     */
    public int numberOfStableArrays(int zero, int one, int limit) {
        final int mod = 1_000_000_007;
        long[][][] dp = new long[zero + 1][one + 1][2];

        for (int z = 1; z <= Math.min(zero, limit); z++) {
            dp[z][0][0] = 1;
        }
        for (int o = 1; o <= Math.min(one, limit); o++) {
            dp[0][o][1] = 1;
        }

        for (int z = 1; z <= zero; z++) {
            for (int o = 1; o <= one; o++) {
                dp[z][o][0] = (dp[z - 1][o][0] + dp[z - 1][o][1]) % mod;
                if (z > limit) {
                    dp[z][o][0] = (dp[z][o][0] - dp[z - limit - 1][o][1] + mod) % mod;
                }

                dp[z][o][1] = (dp[z][o - 1][0] + dp[z][o - 1][1]) % mod;
                if (o > limit) {
                    dp[z][o][1] = (dp[z][o][1] - dp[z][o - limit - 1][0] + mod) % mod;
                }
            }
        }

        return (int) ((dp[zero][one][0] + dp[zero][one][1]) % mod);
    }
    static int runTest(
            LC3129_Find_All_Possible_Stable_Binary_Arrays_IB sol,
            int testNum, int zero, int one, int limit, int expected) {

        System.out.printf("Test %d: zero=%d, one=%d, limit=%d, expected=%d  =>  ",
                testNum, zero, one, limit, expected);
        try {
            int result = sol.numberOfStableArrays(zero, one, limit);
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
