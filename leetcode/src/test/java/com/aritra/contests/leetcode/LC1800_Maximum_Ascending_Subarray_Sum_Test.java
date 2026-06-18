package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC1800_Maximum_Ascending_Subarray_Sum_Test {

    @Test
    public void testStandardCase() {
        int[] nums = {10,20,30,5,10,50};
        assertEquals(65, LC1800_Maximum_Ascending_Subarray_Sum.maxAscendingSum(nums));
    }

    @Test
    public void testAllDescending() {
        int[] nums = {12,17,15,13,10,11,12};
        assertEquals(33, LC1800_Maximum_Ascending_Subarray_Sum.maxAscendingSum(nums));
    }

    @Test
    public void testSingleElement() {
        int[] nums = {100};
        assertEquals(100, LC1800_Maximum_Ascending_Subarray_Sum.maxAscendingSum(nums));
    }
}
