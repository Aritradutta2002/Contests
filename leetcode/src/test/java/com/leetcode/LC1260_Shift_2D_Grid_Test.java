package com.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class LC1260_Shift_2D_Grid_Test {

    private final LC1260_Shift_2D_Grid solver = new LC1260_Shift_2D_Grid();

    @Test
    void testExample1_singleShift() {
        int[][] grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int k = 1;
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(9, 1, 2),
                Arrays.asList(3, 4, 5),
                Arrays.asList(6, 7, 8)
        );
        assertEquals(expected, solver.shiftGrid(grid, k));
    }

    @Test
    void testExample2_multipleShifts() {
        int[][] grid = {{3, 8, 1, 9}, {19, 7, 2, 5}, {4, 6, 11, 10}, {12, 0, 21, 13}};
        int k = 4;
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(12, 0, 21, 13),
                Arrays.asList(3, 8, 1, 9),
                Arrays.asList(19, 7, 2, 5),
                Arrays.asList(4, 6, 11, 10)
        );
        assertEquals(expected, solver.shiftGrid(grid, k));
    }

    @Test
    void testExample3_fullCycle() {
        int[][] grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int k = 9;
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );
        assertEquals(expected, solver.shiftGrid(grid, k));
    }
}
