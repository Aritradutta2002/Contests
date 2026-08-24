package com.leetcode;

/*
 *   Author : Aritra
 *   Created On: Saturday,07.06.2025 01:03 am
 */

/**
 * 2434. Using a Robot to Print the Lexicographically Smallest String
 *
 * You are given a string s and a robot that currently holds an empty string t. Apply one of the following operations until s and t are both empty:
 *  - Remove the first character of a string s and give it to the robot. The robot will append this character to the string t.
 *  - Remove the last character of a string t and give it to the robot. The robot will write this character on paper.
 * Return the lexicographically smallest string that can be written on the paper.
 * Example 1:
 * Input: s = "zza"
 * Output: "azz"
 * Explanation: Let p denote the written string.
 * Initially p="", s="zza", t="".
 * Perform first operation three times p="", s="", t="zza".
 * Perform second operation three times p="azz", s="", t="".
 * Example 2:
 * Input: s = "bac"
 * Output: "abc"
 * Explanation: Let p denote the written string.
 * Perform first operation twice p="", s="c", t="ba".
 * Perform second operation twice p="ab", s="c", t="".
 * Perform first operation p="ab", s="", t="c".
 * Perform second operation p="abc", s="", t="".
 * Example 3:
 * Input: s = "bdda"
 * Output: "addb"
 * Explanation: Let p denote the written string.
 * Initially p="", s="bdda", t="".
 * Perform first operation four times p="", s="", t="bdda".
 * Perform second operation four times p="addb", s="", t="".
 * Constraints:
 *  - 1 <= s.length <= 105
 *  - s consists of only English lowercase letters.
 */
public class LC2434_Using_Robot_To_Print_Lexicographically_Smallest_String {
    /*
     * Approach: stack plus suffix minimums, writing a character as soon as nothing can beat it.
     *
     * t is a stack, and the paper is built left to right, so at every moment the question is only
     * "is the character on top of the stack the smallest one still available?". Everything still
     * available is either on the stack - where only the top can be written next - or in the unread
     * part of s. So the top should be written exactly when it is no greater than the smallest
     * character remaining in s, which a suffix-minimum array answers in O(1). Writing a strictly
     * smaller character earlier is impossible, and delaying a character that already ties the
     * minimum only pushes larger characters ahead of it, so this local rule is optimal.
     *
     * The sentinel for the empty suffix is the largest possible char, so the final iteration
     * drains whatever is left on the stack and no separate flush is needed.
     *
     * Time: O(n), Space: O(n).
     */
    public static String robotWithString(String s) {
        int n = s.length();
        char[] smallestFrom = new char[n + 1];          // smallest character in s[i..n-1]
        smallestFrom[n] = Character.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            smallestFrom[i] = (char) Math.min(s.charAt(i), smallestFrom[i + 1]);
        }

        StringBuilder paper = new StringBuilder(n);
        char[] stack = new char[n];
        int top = 0;
        for (int i = 0; i < n; i++) {
            stack[top++] = s.charAt(i);
            while (top > 0 && stack[top - 1] <= smallestFrom[i + 1]) {
                paper.append(stack[--top]);
            }
        }
        return paper.toString();
    }
}
