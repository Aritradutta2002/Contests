package com.aritra.contests.leetcode;

/*
 * @lc app=leetcode id=316 lang=java
 *
 * [316] Remove Duplicate Letters
 */

// @lc code=start
class LC316_Remove_Duplicate_Letters {
    public String removeDuplicateLetters(String s) {
        int n = s.length();
        int[] remaining = new int[26];
        for (char c : s.toCharArray()) {
            remaining[c - 'a']++;
        }

        boolean[] used = new boolean[26];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char curr = s.charAt(i);
            int idx = curr - 'a';

            remaining[idx]--;
            if (used[idx]) {
                continue;
            }

            while (sb.length() > 0) {
                char last = sb.charAt(sb.length() - 1);
                if (last <= curr || remaining[last - 'a'] == 0) {
                    break;
                }

                used[last - 'a'] = false;
                sb.deleteCharAt(sb.length() - 1);
            }

            sb.append(curr);
            used[idx] = true;

        }
        return sb.toString();
    }
}
// @lc code=end
