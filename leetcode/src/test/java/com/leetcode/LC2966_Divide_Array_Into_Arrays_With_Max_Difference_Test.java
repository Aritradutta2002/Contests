package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC2966_Divide_Array_Into_Arrays_With_Max_Difference_Test {

    @Test
    public void testDivideArray() {
        int[] nums = {1, 3, 4, 8, 7, 9, 3, 5, 1};
        int[][] result = LC2966_Divide_Array_Into_Arrays_With_Max_Difference.divideArray(nums, 3);
        assertEquals(3, result.length);
    }
}
