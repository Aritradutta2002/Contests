package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC2553_Separate_The_Digits_In_An_Array_Test {

    @Test
    public void testStandardCase() {
        int[] nums = {13,25,83,77};
        int[] expected = {1,3,2,5,8,3,7,7};
        assertArrayEquals(expected, LC2553_Separate_The_Digits_In_An_Array.separateDigits(nums));
    }

    @Test
    public void testSingleDigit() {
        int[] nums = {7};
        int[] expected = {7};
        assertArrayEquals(expected, LC2553_Separate_The_Digits_In_An_Array.separateDigits(nums));
    }
}
