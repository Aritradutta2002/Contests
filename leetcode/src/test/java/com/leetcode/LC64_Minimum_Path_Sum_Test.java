package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC64_Minimum_Path_Sum_Test {

    private final LC64_Minimum_Path_Sum solution = new LC64_Minimum_Path_Sum();

    @Test
    public void test3x3() {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        assertEquals(7, solution.minPathSum(grid));
    }

    @Test
    public void test2x3() {
        int[][] grid = {{1, 2, 3}, {4, 5, 6}};
        assertEquals(12, solution.minPathSum(grid));
    }

    @Test
    public void testSingleCell() {
        int[][] grid = {{5}};
        assertEquals(5, solution.minPathSum(grid));
    }
}
