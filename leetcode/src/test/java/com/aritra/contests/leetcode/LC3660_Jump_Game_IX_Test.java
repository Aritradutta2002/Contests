package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC3660_Jump_Game_IX_Test {

    @Test
    public void testExample1() {
        LC3660_Jump_Game_IX solver = new LC3660_Jump_Game_IX();
        int[] nums = {3, 1, 4, 1, 5, 9, 2, 6};
        int[] expected = {9, 9, 9, 9, 9, 9, 9, 9};
        assertArrayEquals(expected, solver.maxValue(nums));
    }

    @Test
    public void testExample2() {
        LC3660_Jump_Game_IX solver = new LC3660_Jump_Game_IX();
        int[] nums = {5, 4, 3, 2, 1};
        int[] expected = {5, 5, 5, 5, 5};
        assertArrayEquals(expected, solver.maxValue(nums));
    }

    @Test
    public void testSingleElement() {
        LC3660_Jump_Game_IX solver = new LC3660_Jump_Game_IX();
        int[] nums = {7};
        int[] expected = {7};
        assertArrayEquals(expected, solver.maxValue(nums));
    }
}
