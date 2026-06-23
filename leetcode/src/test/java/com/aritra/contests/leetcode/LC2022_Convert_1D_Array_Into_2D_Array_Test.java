package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC2022_Convert_1D_Array_Into_2D_Array_Test {

    @Test
    public void testStandardCase() {
        int[] original = {1,2,3,4};
        int[][] expected = {{1,2},{3,4}};
        assertArrayEquals(expected, LC2022_Convert_1D_Array_Into_2D_Array.construct2DArray(original, 2, 2));
    }
}
