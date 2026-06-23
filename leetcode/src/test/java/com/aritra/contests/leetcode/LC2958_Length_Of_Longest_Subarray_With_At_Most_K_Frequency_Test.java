package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC2958_Length_Of_Longest_Subarray_With_At_Most_K_Frequency_Test {

    @Test
    public void testStandardCase() {
        int[] nums = {1,2,3,1,2,3,1,2};
        assertEquals(6, LC2958_Length_Of_Longest_Subarray_With_At_Most_K_Frequency.maxSubarrayLength(nums, 2));
    }

    @Test
    public void testAllUnique() {
        int[] nums = {5,5,5,5,5,5};
        assertEquals(2, LC2958_Length_Of_Longest_Subarray_With_At_Most_K_Frequency.maxSubarrayLength(nums, 2));
    }
}
