package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC2615_Sum_Of_Distances_Test {

    @Test
    public void testStandardCase() {
        LC2615_Sum_Of_Distances solver = new LC2615_Sum_Of_Distances();
        int[] nums = {1,3,1,1,2};
        long[] expected = {5,0,3,4,0};
        assertArrayEquals(expected, solver.distance(nums));
    }

    @Test
    public void testAllUnique() {
        LC2615_Sum_Of_Distances solver = new LC2615_Sum_Of_Distances();
        int[] nums = {0,5,3};
        long[] expected = {0,0,0};
        assertArrayEquals(expected, solver.distance(nums));
    }
}
