package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC3423_Maximum_Difference_Between_Adjacent_Elements_In_A_Circular_Array_Test {

    @Test
    public void testExample1() {
        int[] nums = {1, 2, 4};
        assertEquals(3, LC3423_Maximum_Difference_Between_Adjacent_Elements_In_A_Circular_Array.maxAdjacentDistance(nums));
    }

    @Test
    public void testExample2() {
        int[] nums = {-5, -10, 0};
        assertEquals(10, LC3423_Maximum_Difference_Between_Adjacent_Elements_In_A_Circular_Array.maxAdjacentDistance(nums));
    }

    @Test
    public void testTwoElements() {
        int[] nums = {10, 20};
        assertEquals(10, LC3423_Maximum_Difference_Between_Adjacent_Elements_In_A_Circular_Array.maxAdjacentDistance(nums));
    }
}
