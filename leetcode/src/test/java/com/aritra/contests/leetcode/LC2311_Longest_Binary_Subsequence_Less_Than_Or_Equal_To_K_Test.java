package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC2311_Longest_Binary_Subsequence_Less_Than_Or_Equal_To_K_Test {

    @Test
    public void testStandardCase() {
        assertEquals(5, LC2311_Longest_Binary_Subsequence_Less_Than_Or_Equal_To_K.longestSubsequence("1001010", 5));
    }

    @Test
    public void testCaseTwo() {
        assertEquals(6, LC2311_Longest_Binary_Subsequence_Less_Than_Or_Equal_To_K.longestSubsequence("00101001", 1));
    }
}
