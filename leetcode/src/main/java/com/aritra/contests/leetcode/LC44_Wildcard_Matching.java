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
        throw new UnsupportedOperationException("Not implemented yet.");
    }


    
    public static void main(String[] args) {
        LC44_Wildcard_Matching solver = new LC44_Wildcard_Matching();

        String[][] testCases = {
            {"aa", "a"},           // false
            {"aa", "*"},           // true
            {"cb", "?a"},          // false
            {"adceb", "*a*b"},     // true
            {"acdcb", "a*c?b"},    // false
            {"", "*****"},         // true
            {"mississippi", "m??*iss*?i*"}, // true
            {"abefcdgiescdfimde", "ab*cd?i*de"}, // true
        };
        boolean[] expected = {false, true, false, true, false, true, true, true};

        for (int i = 0; i < testCases.length; i++) {
            try {
                boolean result = solver.isMatch(testCases[i][0], testCases[i][1]);
                if (result == expected[i]) {
                    System.out.println("Test " + (i + 1) + ": PASS");
                } else {
                    System.out.println("Test " + (i + 1) + ": FAIL (expected " + expected[i] + ", got " + result + ")");
                }
            } catch (UnsupportedOperationException e) {
                System.out.println("Test " + (i + 1) + ": SKIPPED (Not implemented)");
            }
        }
    }
}