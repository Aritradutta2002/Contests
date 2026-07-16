package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC695_Max_Area_Of_Island_Test {

    @Test
    public void testMaxAreaOfIslandExample1() {
        int[][] grid = {
            {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
            {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
            {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };
        LC695_Max_Area_Of_Island solver = new LC695_Max_Area_Of_Island();
        assertEquals(6, solver.maxAreaOfIsland(grid));
    }

    @Test
    public void testMaxAreaOfIslandNoIsland() {
        int[][] grid = {{0, 0, 0, 0, 0, 0, 0, 0}};
        LC695_Max_Area_Of_Island solver = new LC695_Max_Area_Of_Island();
        assertEquals(0, solver.maxAreaOfIsland(grid));
    }

    @Test
    public void testMaxAreaOfIslandSingleCell() {
        int[][] grid = {{1}};
        LC695_Max_Area_Of_Island solver = new LC695_Max_Area_Of_Island();
        assertEquals(1, solver.maxAreaOfIsland(grid));
    }
}
