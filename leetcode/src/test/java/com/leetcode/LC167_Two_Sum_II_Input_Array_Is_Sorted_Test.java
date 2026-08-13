package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC167_Two_Sum_II_Input_Array_Is_Sorted_Test {

    @Test
    public void testStandardCase() {
        LC167_Two_Sum_II_Input_Array_Is_Sorted solver = new LC167_Two_Sum_II_Input_Array_Is_Sorted();
        int[] numbers = {2,7,11,15};
        int[] expected = {1,2};
        assertArrayEquals(expected, solver.twoSum(numbers, 9));
    }

    @Test
    public void testThreeNumbers() {
        LC167_Two_Sum_II_Input_Array_Is_Sorted solver = new LC167_Two_Sum_II_Input_Array_Is_Sorted();
        int[] numbers = {2,3,4};
        int[] expected = {1,3};
        assertArrayEquals(expected, solver.twoSum(numbers, 6));
    }
}
