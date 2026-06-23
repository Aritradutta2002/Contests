package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC2016_Maximum_Difference_Between_Increasing_Elements_Test {

    @Test
    public void testStandardCase() {
        int[] nums = {7, 1, 5, 4};
        assertEquals(4, LC2016_Maximum_Difference_Between_Increasing_Elements.maximumDifference(nums));
    }

    @Test
    public void testNoIncrease() {
        int[] nums = {9, 4, 3, 2};
        assertEquals(-1, LC2016_Maximum_Difference_Between_Increasing_Elements.maximumDifference(nums));
    }

    @Test
    public void testIncreasing() {
        int[] nums = {1, 5, 2, 10};
        assertEquals(9, LC2016_Maximum_Difference_Between_Increasing_Elements.maximumDifference(nums));
    }
}
