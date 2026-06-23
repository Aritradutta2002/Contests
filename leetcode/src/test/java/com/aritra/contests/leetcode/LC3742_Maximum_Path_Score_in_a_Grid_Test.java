package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC3742_Maximum_Path_Score_in_a_Grid_Test {

    @Test
    public void testExample1() {
        LC3742_Maximum_Path_Score_in_a_Grid solver = new LC3742_Maximum_Path_Score_in_a_Grid();
        int[][] grid = {{0, 1, 0}, {2, 0, 1}, {0, 2, 0}};
        int k = 2;
        assertEquals(4, solver.maxPathScore(grid, k));
    }

    @Test
    public void testExample2() {
        LC3742_Maximum_Path_Score_in_a_Grid solver = new LC3742_Maximum_Path_Score_in_a_Grid();
        int[][] grid = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        int k = 0;
        assertEquals(0, solver.maxPathScore(grid, k));
    }
}
