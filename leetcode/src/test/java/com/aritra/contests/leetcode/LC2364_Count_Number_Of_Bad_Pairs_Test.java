package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC2364_Count_Number_Of_Bad_Pairs_Test {

    @Test
    public void testStandardCase() {
        int[] nums = {4,1,3,3};
        assertEquals(5, LC2364_Count_Number_Of_Bad_Pairs.countBadPairs(nums));
    }

    @Test
    public void testNoBadPairs() {
        int[] nums = {0,1,2,3};
        assertEquals(0, LC2364_Count_Number_Of_Bad_Pairs.countBadPairs(nums));
    }
}
