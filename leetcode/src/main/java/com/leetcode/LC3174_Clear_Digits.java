package com.leetcode;
/*
 * 3174. Clear Digits
 *
 * Given a string s, repeatedly delete the first digit and the closest non-digit character to its
 * left. Return the resulting string.
 *
 * Constraints:
 * - 1 <= s.length <= 100
 * - s consists of lowercase English letters and digits
 */
public class LC3174_Clear_Digits {
    static public String clearDigits(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}

