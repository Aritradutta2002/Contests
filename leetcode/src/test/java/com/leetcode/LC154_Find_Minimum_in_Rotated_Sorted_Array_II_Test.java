package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC154_Find_Minimum_in_Rotated_Sorted_Array_II_Test {

    @Test
    public void testStandardCase() {
        LC154_Find_Minimum_in_Rotated_Sorted_Array_II solver = new LC154_Find_Minimum_in_Rotated_Sorted_Array_II();
        int[] nums = {1,3,5};
        assertEquals(1, solver.findMin(nums));
    }

    @Test
    public void testRotatedArray() {
        LC154_Find_Minimum_in_Rotated_Sorted_Array_II solver = new LC154_Find_Minimum_in_Rotated_Sorted_Array_II();
        int[] nums = {2,2,2,0,1};
        assertEquals(0, solver.findMin(nums));
    }

    @Test
    public void testAllDuplicates() {
        LC154_Find_Minimum_in_Rotated_Sorted_Array_II solver = new LC154_Find_Minimum_in_Rotated_Sorted_Array_II();
        int[] nums = {3,3,3,3,3};
        assertEquals(3, solver.findMin(nums));
    }
}
