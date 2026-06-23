package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC03_Longest_Substring_Without_Repeating_Characters_Test {

    @Test
    public void testStandardCase() {
        LC03_Longest_Substring_Without_Repeating_Characters solver = new LC03_Longest_Substring_Without_Repeating_Characters();
        assertEquals(3, solver.lengthOfLongestSubstring("abcabcbb"));
    }

    @Test
    public void testAllSameChars() {
        LC03_Longest_Substring_Without_Repeating_Characters solver = new LC03_Longest_Substring_Without_Repeating_Characters();
        assertEquals(1, solver.lengthOfLongestSubstring("bbbbb"));
    }

    @Test
    public void testStandardCase2() {
        LC03_Longest_Substring_Without_Repeating_Characters solver = new LC03_Longest_Substring_Without_Repeating_Characters();
        assertEquals(3, solver.lengthOfLongestSubstring("pwwkew"));
    }

    @Test
    public void testDvdf() {
        LC03_Longest_Substring_Without_Repeating_Characters solver = new LC03_Longest_Substring_Without_Repeating_Characters();
        assertEquals(3, solver.lengthOfLongestSubstring("dvdf"));
    }
}
