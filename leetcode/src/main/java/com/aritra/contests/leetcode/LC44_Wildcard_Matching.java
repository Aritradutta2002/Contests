package com.aritra.contests.leetcode;
import java.util.*;
/*
 * 44. Wildcard Matching
 *
 * Given an input string s and a pattern p, implement wildcard pattern
 * matching with support for '?' and '*' where:
 * - '?' Matches any single character
 * - '*' Matches any sequence of characters (including the empty sequence)
 *
 * The matching should cover the entire input string (not partial).
 *
 * Constraints:
 * - 0 <= s.length, p.length <= 2000
 * - s contains only lowercase English letters.
 * - p contains only lowercase English letters, '?' or '*'.
 */
public class LC44_Wildcard_Matching {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') dp[0][j] = dp[0][j - 1];
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char pc = p.charAt(j - 1);
                if (pc == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else if (pc == '?' || pc == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}