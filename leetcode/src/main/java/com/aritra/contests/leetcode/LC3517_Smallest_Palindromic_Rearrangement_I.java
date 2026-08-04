package com.aritra.contests.leetcode;

/**
 * 3517. Smallest Palindromic Rearrangement I
 *
 * You are given a palindromic string s.
 * Return the lexicographically smallest palindromic permutation of s.
 *
 * Constraints:
 * - 1 <= s.length <= 10^5
 * - s consists of lowercase English letters.
 * - s is guaranteed to be palindromic.
 */
public class LC3517_Smallest_Palindromic_Rearrangement_I {

    public String smallestPalindrome(String s) {
        int[] frequency = new int[26];
        for (char ch : s.toCharArray()) {
            frequency[ch - 'a']++;
        }

        StringBuilder leftHalf = new StringBuilder();
        StringBuilder middle = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            int count = frequency[i];
            if (count % 2 == 1) {
                middle.append((char) ('a' + i));
                count--;
            }

            for (int j = 0; j < count / 2; j++) {
                leftHalf.append((char) ('a' + i));
            }
        }

        StringBuilder rightHalf = new StringBuilder(leftHalf).reverse();
        return leftHalf + middle.toString() + rightHalf;
    }
}
