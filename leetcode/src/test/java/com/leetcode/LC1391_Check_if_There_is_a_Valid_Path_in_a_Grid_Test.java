package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC1391_Check_if_There_is_a_Valid_Path_in_a_Grid_Test {

    @Test
    public void testValidPath() {
        LC1391_Check_if_There_is_a_Valid_Path_in_a_Grid solver = new LC1391_Check_if_There_is_a_Valid_Path_in_a_Grid();
        int[][] grid = {{2,4,3},{6,5,2}};
        assertTrue(solver.hasValidPath(grid));
    }

    @Test
    public void testInvalidPath() {
        LC1391_Check_if_There_is_a_Valid_Path_in_a_Grid solver = new LC1391_Check_if_There_is_a_Valid_Path_in_a_Grid();
        int[][] grid = {{1,2,1},{1,2,1}};
        assertFalse(solver.hasValidPath(grid));
    }

    @Test
    public void testSingleCell() {
        LC1391_Check_if_There_is_a_Valid_Path_in_a_Grid solver = new LC1391_Check_if_There_is_a_Valid_Path_in_a_Grid();
        int[][] grid = {{4}};
        assertTrue(solver.hasValidPath(grid));
    }
}
