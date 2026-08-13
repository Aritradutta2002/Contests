package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC594_Longest_Harmonious_Subsequence_Test {

    @Test
    public void testStandardCase() {
        int[] nums = {1,3,2,2,5,2,3,7};
        assertEquals(5, LC594_Longest_Harmonious_Subsequence.findLHS(nums));
    }

    @Test
    public void testNoHarmonious() {
        int[] nums = {1,1,1,1};
        assertEquals(0, LC594_Longest_Harmonious_Subsequence.findLHS(nums));
    }
}
