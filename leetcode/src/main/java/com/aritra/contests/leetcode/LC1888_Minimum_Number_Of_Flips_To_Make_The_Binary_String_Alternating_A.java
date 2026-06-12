package com.aritra.contests.leetcode;

/*
 * @lc app=leetcode id=1888 lang=java
 *
 * [1888] Minimum Number of Flips to Make the Binary String Alternating
 */

// @lc code=start
class LC1888_Minimum_Number_Of_Flips_To_Make_The_Binary_String_Alternating_A {
    public int minFlips(String s) {
        int n = s.length();
        // Build diff array against pattern "010101..." using int[] instead of String
        // (O(n) vs O(n²))
        int[] diff = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            int ch = s.charAt(i % n) - '0';
            diff[i] = (i & 1) == 0 ? (ch) : (1 ^ ch);
        }

        // Sliding window of size n
        int ones = 0;
        for (int i = 0; i < n; i++)
            if (diff[i] == 1)
                ones++;

        int len = Math.min(ones, n - ones);

        for (int i = n; i < 2 * n; i++) {
            if (diff[i] == 1)
                ones++;
            if (diff[i - n] == 1)
                ones--;
            len = Math.min(len, Math.min(ones, n - ones));
        }

        return len;
    }
}
// @lc code=end
