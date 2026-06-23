package com.aritra.contests.leetcode;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
public class LC438_Find_All_Anagrams_In_A_String_B {

    /*
     * Problem: 438. Find All Anagrams in a String
     *
     * Description:
     * Given two strings s and p, return an array of all the start indices of p's anagrams in s.
     * You may return the answer in any order.
     *
     * Constraints:
     * 1 <= s.length, p.length <= 3 * 10^4
     * s and p consist of lowercase English letters.
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (p.length() > s.length()) {
            return ans;
        }

        int[] need = new int[26];
        int[] window = new int[26];
        for (int i = 0; i < p.length(); i++) {
            need[p.charAt(i) - 'a']++;
            window[s.charAt(i) - 'a']++;
        }

        if (Arrays.equals(need, window)) {
            ans.add(0);
        }

        for (int right = p.length(); right < s.length(); right++) {
            window[s.charAt(right) - 'a']++;
            window[s.charAt(right - p.length()) - 'a']--;
            if (Arrays.equals(need, window)) {
                ans.add(right - p.length() + 1);
            }
        }

        return ans;
    }
    private static final class TestCase {
        final String s;
        final String p;
        final List<Integer> expected;

        TestCase(String s, String p, List<Integer> expected) {
            this.s = s;
            this.p = p;
            this.expected = expected;
        }
    }
}
