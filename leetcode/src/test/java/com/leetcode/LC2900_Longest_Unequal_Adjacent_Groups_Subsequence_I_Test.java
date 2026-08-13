package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class LC2900_Longest_Unequal_Adjacent_Groups_Subsequence_I_Test {

    @Test
    public void testStandardCase() {
        String[] words = {"e","a","b"};
        int[] groups = {0,0,1};
        List<String> result = LC2900_Longest_Unequal_Adjacent_Groups_Subsequence_I.getLongestSubsequence(words, groups);
        assertEquals(Arrays.asList("e","b"), result);
    }

    @Test
    public void testAllSameGroup() {
        String[] words = {"a","b","c"};
        int[] groups = {0,0,0};
        List<String> result = LC2900_Longest_Unequal_Adjacent_Groups_Subsequence_I.getLongestSubsequence(words, groups);
        assertEquals(Arrays.asList("a"), result);
    }
}
