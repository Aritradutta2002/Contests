package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC325_Maximum_Size_Subarray_Sum_Equals_k_Test {

    @Test
    public void testExample1() {
        LC325_Maximum_Size_Subarray_Sum_Equals_k solver = new LC325_Maximum_Size_Subarray_Sum_Equals_k();
        int[] nums = {1, -1, 5, -2, 3};
        int k = 3;
        assertEquals(4, solver.maxSubArrayLen(nums, k));
    }

    @Test
    public void testExample2() {
        LC325_Maximum_Size_Subarray_Sum_Equals_k solver = new LC325_Maximum_Size_Subarray_Sum_Equals_k();
        int[] nums = {-2, -1, 2, 1};
        int k = 1;
        assertEquals(2, solver.maxSubArrayLen(nums, k));
    }

    @Test
    public void testNoSolution() {
        LC325_Maximum_Size_Subarray_Sum_Equals_k solver = new LC325_Maximum_Size_Subarray_Sum_Equals_k();
        int[] nums = {1, 2, 3};
        int k = 10;
        assertEquals(0, solver.maxSubArrayLen(nums, k));
    }
}
