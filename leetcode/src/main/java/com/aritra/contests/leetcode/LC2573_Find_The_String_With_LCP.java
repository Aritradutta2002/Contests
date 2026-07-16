package com.aritra.contests.leetcode;
import java.util.*;
/*
 * LeetCode 2573. Find the String with LCP
 *
 * Description:
 * You are given an n x n matrix lcp where lcp[i][j] is the length of the longest
 * common prefix between the suffixes word[i:] and word[j:].
 * Return the lexicographically smallest lowercase English string word that
 * produces the given matrix. If no such string exists, return an empty string.
 *
 * Constraints:
 * 1 <= n == lcp.length == lcp[i].length <= 1000
 * 0 <= lcp[i][j] <= n
 */
public class LC2573_Find_The_String_With_LCP {
    public String findTheString(int[][] lcp) {
        int n = lcp.length;
        char[] word = new char[n];

        char nextChar = 'a';
        for (int i = 0; i < n; i++) {
            if (word[i] != '\0') {
                continue;
            }
            if (nextChar > 'z') {
                return "";
            }

            word[i] = nextChar;
            for (int j = i + 1; j < n; j++) {
                if (lcp[i][j] > 0) {
                    word[j] = nextChar;
                }
            }
            nextChar++;
        }

        int[][] computed = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (word[i] == word[j]) {
                    computed[i][j] = computed[i + 1][j + 1] + 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (computed[i][j] != lcp[i][j]) {
                    return "";
                }
            }
        }

        return new String(word);

    }
}
