package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC2563_Count_The_Number_Of_Fair_Pairs_Test {

    @Test
    public void testStandardCase() {
        int[] nums = {0,1,7,4,4,5};
        assertEquals(6, LC2563_Count_The_Number_Of_Fair_Pairs.countFairPairs(nums, 3, 6));
    }

    @Test
    public void testSimpleCase() {
        int[] nums = {1,7,9,2,5};
        assertEquals(1, LC2563_Count_The_Number_Of_Fair_Pairs.countFairPairs(nums, 11, 11));
    }
}
