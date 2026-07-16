package com.aritra.contests.leetcode;

import java.util.*;

/*
 * 1544. Make The String Great
 *
 * Given a string s, repeatedly remove adjacent characters that are the same letter but of opposite
 * case. Return the resulting "good" string.
 *
 * Constraints:
 * - 1 <= s.length <= 100
 * - s contains only lower and upper case English letters
 */
public class LC1544_Make_The_String_Great {
    static public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && Math.abs(stack.peek() - ch) == 32) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ans.insert(0, stack.pop());
        }

        return ans.toString();
    }
}
