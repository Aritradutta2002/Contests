package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC560_Subarray_Sum_Equals_K_Test {

    private final LC560_Subarray_Sum_Equals_K solution = new LC560_Subarray_Sum_Equals_K();

    @Test
    public void testStandardCase() {
        int[] nums = {1, 1, 1};
        assertEquals(2, solution.subarraySum(nums, 2));
    }

    @Test
    public void testAnotherCase() {
        int[] nums = {1, 2, 3};
        assertEquals(2, solution.subarraySum(nums, 3));
    }

    @Test
    public void testWithNegatives() {
        int[] nums = {1, -1, 0};
        assertEquals(3, solution.subarraySum(nums, 0));
    }
}
