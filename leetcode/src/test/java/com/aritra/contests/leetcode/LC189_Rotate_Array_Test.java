package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC189_Rotate_Array_Test {

    @Test
    public void testStandardCase() {
        int[] nums = {1,2,3,4,5,6,7};
        int[] expected = {5,6,7,1,2,3,4};
        LC189_Rotate_Array.rotate(nums, 3);
        assertArrayEquals(expected, nums);
    }

    @Test
    public void testSingleElement() {
        int[] nums = {1};
        int[] expected = {1};
        LC189_Rotate_Array.rotate(nums, 0);
        assertArrayEquals(expected, nums);
    }
}
