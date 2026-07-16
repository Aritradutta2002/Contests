package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC1752_Check_If_Array_Is_Sorted_And_Rotated_Test {

    @Test
    public void testCheckExample1() {
        LC1752_Check_If_Array_Is_Sorted_And_Rotated solver = new LC1752_Check_If_Array_Is_Sorted_And_Rotated();
        int[] nums = {3, 4, 5, 1, 2};
        assertTrue(solver.check(nums));
    }

    @Test
    public void testCheckExample2() {
        LC1752_Check_If_Array_Is_Sorted_And_Rotated solver = new LC1752_Check_If_Array_Is_Sorted_And_Rotated();
        int[] nums = {2, 1, 3, 4};
        assertFalse(solver.check(nums));
    }

    @Test
    public void testCheckExample3() {
        LC1752_Check_If_Array_Is_Sorted_And_Rotated solver = new LC1752_Check_If_Array_Is_Sorted_And_Rotated();
        int[] nums = {1, 2, 3};
        assertTrue(solver.check(nums));
    }

    @Test
    public void testCheckWithDuplicates() {
        LC1752_Check_If_Array_Is_Sorted_And_Rotated solver = new LC1752_Check_If_Array_Is_Sorted_And_Rotated();
        int[] nums = {1, 1, 1};
        assertTrue(solver.check(nums));
    }
}
