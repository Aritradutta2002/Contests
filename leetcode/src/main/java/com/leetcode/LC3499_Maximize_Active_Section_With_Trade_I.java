package com.leetcode;

/*
 * 3499. Maximize Active Section with Trade I
 *
 * You are given a binary string s of length n, where:
 *  - '1' represents an active section.
 *  - '0' represents an inactive section.
 *
 * You can perform at most one trade to maximize the number of active sections
 * in s. In a trade, you:
 *  - Convert a contiguous block of '1's that is surrounded by '0's to all '0's.
 *  - Afterward, convert a contiguous block of '0's that is surrounded by '1's
 *    to all '1's.
 *
 * Return the maximum number of active sections in s after making the optimal
 * trade. Treat s as if it is augmented with a '1' at both ends, forming
 * t = '1' + s + '1'. The augmented '1's do not contribute to the final count.
 *
 * Constraints:
 *  - 1 <= n == s.length <= 10^5
 *  - s[i] is either '0' or '1'
 *
 * Tags: String, Enumeration
 * Difficulty: Medium
 */
public class LC3499_Maximize_Active_Section_With_Trade_I {

    public int maxActiveSectionsAfterTrade(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int ones = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                ones++;
            }
        }

        int bestGain = 0;
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '1') {
                int j = i;
                while (j < s.length() && s.charAt(j) == '1') {
                    j++;
                }

                boolean hasZeroBefore = i > 0 && s.charAt(i - 1) == '0';
                boolean hasZeroAfter = j < s.length() && s.charAt(j) == '0';

                if (hasZeroBefore && hasZeroAfter) {
                    int leftZeros = 0;
                    int k = i - 1;
                    while (k >= 0 && s.charAt(k) == '0') {
                        leftZeros++;
                        k--;
                    }

                    int rightZeros = 0;
                    k = j;
                    while (k < s.length() && s.charAt(k) == '0') {
                        rightZeros++;
                        k++;
                    }

                    bestGain = Math.max(bestGain, leftZeros + rightZeros);
                }

                i = j;
            } else {
                i++;
            }
        }

        return ones + bestGain;
    }
}
