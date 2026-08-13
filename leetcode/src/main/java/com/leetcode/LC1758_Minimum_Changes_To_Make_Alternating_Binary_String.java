package com.leetcode;

/*
 * =============================================================================
 * LeetCode 1758 – Minimum Changes To Make Alternating Binary String
 * =============================================================================
 *
 * DESCRIPTION:
 *   You are given a string s consisting only of the characters '0' and '1'.
 *   In one operation, you can change any '0' to '1' or vice versa.
 *
 *   The string is called alternating if no two adjacent characters are equal.
 *   For example, "010" and "1010" are alternating, while "0100" is not.
 *
 *   Return the minimum number of operations needed to make s alternating.
 *
 * CONSTRAINTS:
 *   - 1 <= s.length <= 10^4
 *   - s[i] is either '0' or '1'.
 *
 * EXAMPLES:
 *
 *   Example 1:
 *     Input:  s = "0100"
 *     Output: 1
 *     Explanation: Change the last character to '1' -> "0101" (alternating).
 *
 *   Example 2:
 *     Input:  s = "10"
 *     Output: 0
 *     Explanation: s is already alternating.
 *
 *   Example 3:
 *     Input:  s = "1111"
 *     Output: 2
 *     Explanation: Change to "0101" or "1010" (both need 2 changes).
 *
 * =============================================================================
 */
public class LC1758_Minimum_Changes_To_Make_Alternating_Binary_String {

    /**
     * Returns the minimum number of changes to make the string alternating.
     *
     * @param s a binary string consisting of '0' and '1'
     * @return minimum operations to make s alternating
     */
    public int minOperations(String s) {
        int n = s.length();
        int cost0 = 0;

        for (int i = 0; i < n; i++) {
            char expected = (char) ('0' + (i % 2));
            if (s.charAt(i) != expected)
                cost0++;
        }

        return Math.min(cost0, n - cost0);
    }
}
