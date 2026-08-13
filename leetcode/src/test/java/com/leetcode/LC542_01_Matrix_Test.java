package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC542_01_Matrix_Test {

    @Test
    public void testUpdateMatrixExample1() {
        int[][] mat = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int[][] expected = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        LC542_01_Matrix solver = new LC542_01_Matrix();
        assertArrayEquals(expected, solver.updateMatrix(mat));
    }

    @Test
    public void testUpdateMatrixExample2() {
        int[][] mat = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] expected = {{0, 0, 0}, {0, 1, 0}, {1, 2, 1}};
        LC542_01_Matrix solver = new LC542_01_Matrix();
        assertArrayEquals(expected, solver.updateMatrix(mat));
    }

    @Test
    public void testUpdateMatrixAllZero() {
        int[][] mat = {{0, 0}, {0, 0}};
        int[][] expected = {{0, 0}, {0, 0}};
        LC542_01_Matrix solver = new LC542_01_Matrix();
        assertArrayEquals(expected, solver.updateMatrix(mat));
    }
}
