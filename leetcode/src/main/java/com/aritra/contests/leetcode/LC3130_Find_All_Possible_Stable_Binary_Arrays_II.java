package com.aritra.contests.leetcode;

/*
 * @lc app=leetcode id=3130 lang=java
 *
 * [3130] Find All Possible Stable Binary Arrays II
 */

// @lc code=start
class LC3130_Find_All_Possible_Stable_Binary_Arrays_II {
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
}
// @lc code=end

