package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC3761_Minimum_Absolute_Distance_Between_Mirror_Pairs_Test {

    @Test
    public void testExample1() {
        LC3761_Minimum_Absolute_Distance_Between_Mirror_Pairs solver = new LC3761_Minimum_Absolute_Distance_Between_Mirror_Pairs();
        int[] nums = {12, 21, 45, 33, 54};
        assertEquals(1, solver.minMirrorPairDistance(nums));
    }

    @Test
    public void testExample2() {
        LC3761_Minimum_Absolute_Distance_Between_Mirror_Pairs solver = new LC3761_Minimum_Absolute_Distance_Between_Mirror_Pairs();
        int[] nums = {120, 21};
        assertEquals(1, solver.minMirrorPairDistance(nums));
    }

    @Test
    public void testExample3() {
        LC3761_Minimum_Absolute_Distance_Between_Mirror_Pairs solver = new LC3761_Minimum_Absolute_Distance_Between_Mirror_Pairs();
        int[] nums = {21, 120};
        assertEquals(-1, solver.minMirrorPairDistance(nums));
    }
}
