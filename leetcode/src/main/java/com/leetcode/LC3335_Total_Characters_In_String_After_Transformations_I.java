package com.leetcode;

import java.util.*;

@SuppressWarnings("unused")

/*
 * 3335. Total Characters in String After Transformations I
 *
 * Apply transformation t times: 'a' -> 'bc', 'b' -> 'ca', 'c' -> 'ab', all other letters shift by
 * one. Return the final length of the string modulo 10^9 + 7.
 *
 * Constraints:
 * - 1 <= s.length <= 10^5
 * - s consists of lowercase English letters
 * - 1 <= t <= 10^5
 */
public class LC3335_Total_Characters_In_String_After_Transformations_I {
    public static int lengthAfterTransformations(String s, int t) {

        final int MOD = 1_000_000_007;
        int[] dp = new int[26];
        for (char c : s.toCharArray()) {
            dp[c - 'a']++;
        }

        for (int step = 0; step < t; step++) {
            int[] next = new int[26];
            System.arraycopy(dp, 0, next, 1, 25);
            next[0] = (next[0] + dp[25]) % MOD;
            next[1] = (next[1] + dp[25]) % MOD;
            dp = next;
        }

        long ans = 0;
        for (int cnt : dp) {
            ans = (ans + cnt) % MOD;
        }
        return (int) ans;
    }
}

