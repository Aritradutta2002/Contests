package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class LC2901_Longest_Unequal_Adjacent_Groups_Subsequence_IIA_Test {

    @Test
    public void testGetWordsInLongestSubsequenceExample1() {
        String[] words = {"bab", "dab", "cab"};
        int[] groups = {1, 2, 2};
        List<String> result = LC2901_Longest_Unequal_Adjacent_Groups_Subsequence_IIA.getWordsInLongestSubsequence(words, groups);
        assertEquals(List.of("bab", "dab"), result);
    }
}
