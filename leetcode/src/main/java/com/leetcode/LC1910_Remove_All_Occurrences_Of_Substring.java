package com.leetcode;

import java.util.*;

/*
 * 1910. Remove All Occurrences of a Substring
 *
 * Given two strings s and part, repeatedly remove the leftmost occurrence of part from s until no
 * more occurrences exist. Return the resulting string.
 *
 * Constraints:
 * - 1 <= s.length <= 1000
 * - 1 <= part.length <= 1000
 * - s and part consist of lowercase English letters
 */
public class LC1910_Remove_All_Occurrences_Of_Substring {
    static public String removeOccurrences(String s, String part) {

        StringBuilder ans = new StringBuilder();
        int n = s.length();
        int m = part.length();

        for (int i = 0; i < n; i++) {
            ans.append(s.charAt(i));
            if (ans.length() >= m) {
                String sub = ans.substring(ans.length() - m);
                if (sub.equals(part)) {
                    ans.setLength(ans.length() - m);
                }
            }
        }
        return ans.toString();
    }
}

