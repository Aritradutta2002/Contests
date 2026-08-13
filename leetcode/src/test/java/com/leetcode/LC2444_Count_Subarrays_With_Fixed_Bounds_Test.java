package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC2444_Count_Subarrays_With_Fixed_Bounds_Test {

    @Test
    public void testStandardCase() {
        int[] nums = {1,3,5,2,7,5};
        assertEquals(2, LC2444_Count_Subarrays_With_Fixed_Bounds.countSubarrays(nums, 1, 5));
    }

    @Test
    public void testSimpleCase() {
        int[] nums = {1,5};
        assertEquals(1, LC2444_Count_Subarrays_With_Fixed_Bounds.countSubarrays(nums, 1, 5));
    }
}
