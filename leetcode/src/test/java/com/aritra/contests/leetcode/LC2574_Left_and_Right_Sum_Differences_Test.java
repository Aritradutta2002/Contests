package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC2574_Left_and_Right_Sum_Differences_Test {

    @Test
    public void testStandardCase() {
        LC2574_Left_and_Right_Sum_Differences solver = new LC2574_Left_and_Right_Sum_Differences();
        int[] nums = {10,4,8,3};
        int[] expected = {15,1,11,22};
        assertArrayEquals(expected, solver.leftRightDifference(nums));
    }

    @Test
    public void testSingleElement() {
        LC2574_Left_and_Right_Sum_Differences solver = new LC2574_Left_and_Right_Sum_Differences();
        int[] nums = {5};
        int[] expected = {0};
        assertArrayEquals(expected, solver.leftRightDifference(nums));
    }
}
