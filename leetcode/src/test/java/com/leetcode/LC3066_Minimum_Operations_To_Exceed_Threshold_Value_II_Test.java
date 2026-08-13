package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC3066_Minimum_Operations_To_Exceed_Threshold_Value_II_Test {

    @Test
    public void testStandardCase() {
        int[] nums = {2,11,10,1,3};
        assertEquals(2, LC3066_Minimum_Operations_To_Exceed_Threshold_Value_II.minOperations(nums, 10));
    }

    @Test
    public void testAlreadyExceed() {
        int[] nums = {5,6};
        assertEquals(0, LC3066_Minimum_Operations_To_Exceed_Threshold_Value_II.minOperations(nums, 5));
    }
}
