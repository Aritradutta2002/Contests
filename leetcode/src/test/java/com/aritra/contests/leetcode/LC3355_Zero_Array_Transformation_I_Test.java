package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC3355_Zero_Array_Transformation_I_Test {

    @Test
    public void testExample1() {
        int[] nums = {1, 0, 1};
        int[][] queries = {{0, 2}};
        assertTrue(LC3355_Zero_Array_Transformation_I.isZeroArray(nums, queries));
    }

    @Test
    public void testExample2() {
        int[] nums = {4, 3, 2, 1};
        int[][] queries = {{1, 3}, {0, 2}};
        assertFalse(LC3355_Zero_Array_Transformation_I.isZeroArray(nums, queries));
    }

    @Test
    public void testExample3() {
        int[] nums = {1, 2, 3, 4};
        int[][] queries = {{0, 1}};
        assertFalse(LC3355_Zero_Array_Transformation_I.isZeroArray(nums, queries));
    }
}
