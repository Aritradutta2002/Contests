package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC994_Rotting_Oranges_Test {

    @Test
    public void testOrangesRottingExample1() {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        LC994_Rotting_Oranges solver = new LC994_Rotting_Oranges();
        assertEquals(4, solver.orangesRotting(grid));
    }

    @Test
    public void testOrangesRottingAllRotten() {
        int[][] grid = {{0, 2}};
        LC994_Rotting_Oranges solver = new LC994_Rotting_Oranges();
        assertEquals(0, solver.orangesRotting(grid));
    }

    @Test
    public void testOrangesRottingImpossible() {
        int[][] grid = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        LC994_Rotting_Oranges solver = new LC994_Rotting_Oranges();
        assertEquals(-1, solver.orangesRotting(grid));
    }

    @Test
    public void testOrangesRottingSingle() {
        int[][] grid = {{2}};
        LC994_Rotting_Oranges solver = new LC994_Rotting_Oranges();
        assertEquals(0, solver.orangesRotting(grid));
    }
}
