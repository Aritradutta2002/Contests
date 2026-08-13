package com.leetcode;

import java.util.*;

/*
 * 2900. Longest Unequal Adjacent Groups Subsequence I
 *
 * Given an array of strings words and an array groups, find the longest subsequence where adjacent
 * words come from different groups.
 *
 * Constraints:
 * - 1 <= words.length <= 100
 * - 1 <= words[i].length <= 10
 * - groups.length == words.length
 * - groups[i] is 0 or 1
 */
public class LC2900_Longest_Unequal_Adjacent_Groups_Subsequence_I {
    public static List<String> getLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        List<String> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        result.add(words[0]);

        for (int i = 1; i < n; i++) {
            if (groups[i] != groups[i - 1]) {
                result.add(words[i]);
            }
        }

        return result;
    }

}

