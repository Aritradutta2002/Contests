package com.aritra.contests.leetcode;

import java.util.*;

@SuppressWarnings("unused")

/*
 * 1021. Remove Outermost Parentheses
 *
 * A valid parentheses string is primitive if it is non-empty and cannot be split into two non-empty
 * valid parentheses strings. Given a valid parentheses string S, return S after removing the outermost
 * parentheses of every primitive string.
 *
 * Constraints:
 * - 1 <= s.length <= 10^5
 * - s[i] is either '(' or ')'
 * - s is a valid parentheses string
 */
public class LC1021_Remove_Outermost_Parentheses {
    static public String removeOuterParentheses(String s) {
        StringBuilder res = new StringBuilder();
        int depth = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (depth > 0) {
                    res.append(c);
                }
                depth++;
            } else if (c == ')') {
                depth--;
                if (depth > 0) {
                    res.append(c);
                }
            }
        }

        return res.toString();
    }
}
