package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC1277_Count_Square_Submatrices_With_All_Ones_Test {

    @Test
    public void testStandardCase() {
        int[][] matrix = {
            {0,1,1,1},
            {1,1,1,1},
            {0,1,1,1}
        };
        assertEquals(15, LC1277_Count_Square_Submatrices_With_All_Ones.countSquares(matrix));
    }

    @Test
    public void testSimpleCase() {
        int[][] matrix = {
            {1,0,1},
            {1,1,0},
            {1,1,0}
        };
        assertEquals(7, LC1277_Count_Square_Submatrices_With_All_Ones.countSquares(matrix));
    }
}
