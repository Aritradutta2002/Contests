package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC63_Unique_Paths_II_Test {

    @Test
    public void testWithObstacle() {
        int[][] grid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        assertEquals(2, LC63_Unique_Paths_II.uniquePathsWithObstacles(grid));
    }

    @Test
    public void testNoObstacle() {
        int[][] grid = {{0, 0}, {0, 0}};
        assertEquals(2, LC63_Unique_Paths_II.uniquePathsWithObstacles(grid));
    }

    @Test
    public void testBlockedStart() {
        int[][] grid = {{1, 0}};
        assertEquals(0, LC63_Unique_Paths_II.uniquePathsWithObstacles(grid));
    }
}
