package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC1914_Cyclically_Rotating_a_Grid_Test {

    @Test
    public void testStandardCase() {
        int[][] grid = {{40,10},{30,20}};
        int[][] expected = {{10,20},{40,30}};
        assertArrayEquals(expected, LC1914_Cyclically_Rotating_a_Grid.rotateGrid(grid, 1));
    }

    @Test
    public void testMultipleRotations() {
        int[][] grid = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] result = LC1914_Cyclically_Rotating_a_Grid.rotateGrid(grid, 2);
        assertEquals(3, result[0][0]);
    }
}
