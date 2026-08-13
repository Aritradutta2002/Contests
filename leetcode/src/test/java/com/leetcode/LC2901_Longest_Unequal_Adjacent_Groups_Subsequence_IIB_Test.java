package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class LC2901_Longest_Unequal_Adjacent_Groups_Subsequence_IIB_Test {

    @Test
    public void testGetWordsInLongestSubsequenceExample1() {
        LC2901_Longest_Unequal_Adjacent_Groups_Subsequence_IIB solver = new LC2901_Longest_Unequal_Adjacent_Groups_Subsequence_IIB();
        String[] words = {"bab", "dab", "cab"};
        String[] groups = {"g1", "g2", "g2"};
        List<Integer> result = solver.getWordsInLongestSubsequence(3, words, groups);
        assertEquals(List.of(0, 1), result);
    }
}
