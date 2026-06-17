package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC2099_Find_Subsequence_Of_Length_K_With_The_Largest_Sum_Test {

    @Test
    public void testStandardCase() {
        int[] nums = {2, 1, 3, 3};
        int[] result = LC2099_Find_Subsequence_Of_Length_K_With_The_Largest_Sum.maxSubsequence(nums, 2);
        assertArrayEquals(new int[]{3, 3}, result);
    }

    @Test
    public void testAnotherCase() {
        int[] nums = {-1, -2, 3, 4};
        int[] result = LC2099_Find_Subsequence_Of_Length_K_With_The_Largest_Sum.maxSubsequence(nums, 3);
        assertArrayEquals(new int[]{-1, 3, 4}, result);
    }

    @Test
    public void testSingleElement() {
        int[] nums = {3, 4, 3, 3};
        int[] result = LC2099_Find_Subsequence_Of_Length_K_With_The_Largest_Sum.maxSubsequence(nums, 2);
        assertArrayEquals(new int[]{3, 4}, result);
    }
}
