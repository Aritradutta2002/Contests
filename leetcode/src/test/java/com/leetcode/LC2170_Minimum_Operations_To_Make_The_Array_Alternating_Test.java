package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC2170_Minimum_Operations_To_Make_The_Array_Alternating_Test {

    @Test
    public void testMinimumOperationsExample1() {
        int[] nums = {3, 1, 3, 2, 4, 3};
        assertEquals(3, LC2170_Minimum_Operations_To_Make_The_Array_Alternating.minimumOperations(nums));
    }

    @Test
    public void testMinimumOperationsExample2() {
        int[] nums = {1, 2, 2, 2, 2};
        assertEquals(2, LC2170_Minimum_Operations_To_Make_The_Array_Alternating.minimumOperations(nums));
    }
}
