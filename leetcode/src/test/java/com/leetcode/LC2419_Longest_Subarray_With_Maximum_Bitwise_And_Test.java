package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC2419_Longest_Subarray_With_Maximum_Bitwise_And_Test {

    @Test
    public void testStandardCase() {
        int[] nums = {1,2,3,3,2,2};
        assertEquals(2, LC2419_Longest_Subarray_With_Maximum_Bitwise_And.longestSubarray(nums));
    }

    @Test
    public void testAllSame() {
        int[] nums = {5,5,5,5};
        assertEquals(4, LC2419_Longest_Subarray_With_Maximum_Bitwise_And.longestSubarray(nums));
    }
}
