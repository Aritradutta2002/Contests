package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC73_Set_Matrix_Zeroes_Test {

    @Test
    public void testStandardCase() {
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] expected = {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
        LC73_Set_Matrix_Zeroes.setZeroes(matrix);
        assertArrayEquals(expected, matrix);
    }

    @Test
    public void testAnotherCase() {
        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        int[][] expected = {{0, 0, 0, 0}, {0, 4, 5, 0}, {0, 3, 1, 0}};
        LC73_Set_Matrix_Zeroes.setZeroes(matrix);
        assertArrayEquals(expected, matrix);
    }
}
