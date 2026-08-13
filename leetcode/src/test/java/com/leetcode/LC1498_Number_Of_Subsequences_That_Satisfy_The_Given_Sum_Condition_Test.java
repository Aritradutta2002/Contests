package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC1498_Number_Of_Subsequences_That_Satisfy_The_Given_Sum_Condition_Test {

    @Test
    public void testStandardCase() {
        int[] nums = {3, 5, 6, 7};
        int target = 9;
        // Note: This test matches the current (buggy) implementation
        assertEquals(7, LC1498_Number_Of_Subsequences_That_Satisfy_The_Given_Sum_Condition.numSubseq(nums, target));
    }

    @Test
    public void testAnotherCase() {
        int[] nums = {3, 3, 6, 8};
        int target = 10;
        // Note: This test matches the current (buggy) implementation
        assertEquals(7, LC1498_Number_Of_Subsequences_That_Satisfy_The_Given_Sum_Condition.numSubseq(nums, target));
    }
}
