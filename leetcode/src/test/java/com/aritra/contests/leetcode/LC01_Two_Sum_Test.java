package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC01_Two_Sum_Test {

    @Test
    public void testTwoSumStandard() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] expected = {0, 1};
        assertArrayEquals(expected, LC01_Two_Sum.twoSum(nums, target));
    }

    @Test
    public void testTwoSumNoSolution() {
        int[] nums = {1, 2, 3};
        int target = 10;
        int[] expected = {-1, -1};
        assertArrayEquals(expected, LC01_Two_Sum.twoSum(nums, target));
    }
}
