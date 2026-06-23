package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC3546_Equal_Sum_Grid_Partition_I_Test {

    @Test
    public void testExample1() {
        LC3546_Equal_Sum_Grid_Partition_I solver = new LC3546_Equal_Sum_Grid_Partition_I();
        int[][] grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        assertFalse(solver.canPartitionGrid(grid));
    }

    @Test
    public void testExample2() {
        LC3546_Equal_Sum_Grid_Partition_I solver = new LC3546_Equal_Sum_Grid_Partition_I();
        int[][] grid = {{1, 1, 1}, {1, 1, 1}};
        assertTrue(solver.canPartitionGrid(grid));
    }

    @Test
    public void testSingleSplitHorizontal() {
        LC3546_Equal_Sum_Grid_Partition_I solver = new LC3546_Equal_Sum_Grid_Partition_I();
        int[][] grid = {{2, 2}, {2, 2}};
        assertTrue(solver.canPartitionGrid(grid));
    }
}
