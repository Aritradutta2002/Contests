package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC3225_Maximum_Score_From_Grid_Operations_Test {

    @Test
    public void testExample1() {
        LC3225_Maximum_Score_From_Grid_Operations solver = new LC3225_Maximum_Score_From_Grid_Operations();
        int[][] grid = {{0, 1, 1}, {1, 0, 0}, {1, 0, 1}};
        assertEquals(4, solver.maximumScore(grid));
    }

    @Test
    public void testExample2() {
        LC3225_Maximum_Score_From_Grid_Operations solver = new LC3225_Maximum_Score_From_Grid_Operations();
        int[][] grid = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        assertEquals(0, solver.maximumScore(grid));
    }

    @Test
    public void testSingleColumn() {
        LC3225_Maximum_Score_From_Grid_Operations solver = new LC3225_Maximum_Score_From_Grid_Operations();
        int[][] grid = {{1}};
        assertEquals(0, solver.maximumScore(grid));
    }
}
