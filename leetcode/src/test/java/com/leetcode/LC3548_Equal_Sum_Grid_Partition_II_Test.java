package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC3548_Equal_Sum_Grid_Partition_II_Test {

    @Test
    public void testExample1() {
        LC3548_Equal_Sum_Grid_Partition_II solver = new LC3548_Equal_Sum_Grid_Partition_II();
        int[][] grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        assertFalse(solver.canPartitionGrid(grid));
    }

    @Test
    public void testExample2() {
        LC3548_Equal_Sum_Grid_Partition_II solver = new LC3548_Equal_Sum_Grid_Partition_II();
        int[][] grid = {{1, 1}, {1, 1}};
        assertTrue(solver.canPartitionGrid(grid));
    }

    @Test
    public void testOddTotal() {
        LC3548_Equal_Sum_Grid_Partition_II solver = new LC3548_Equal_Sum_Grid_Partition_II();
        int[][] grid = {{1, 2}, {3, 4}};
        assertTrue(solver.canPartitionGrid(grid));
    }
}
