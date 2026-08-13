package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC3826_Minimum_Partition_Score_Test {

    @Test
    public void testExample1() {
        LC3826_Minimum_Partition_Score solver = new LC3826_Minimum_Partition_Score();
        int[] nums = {1, 2, 3, 4};
        int k = 2;
        assertEquals(31, solver.minPartitionScore(nums, k));
    }

    @Test
    public void testExample2() {
        LC3826_Minimum_Partition_Score solver = new LC3826_Minimum_Partition_Score();
        int[] nums = {4, 3, 2, 1};
        int k = 2;
        assertEquals(31, solver.minPartitionScore(nums, k));
    }

    @Test
    public void testSinglePartition() {
        LC3826_Minimum_Partition_Score solver = new LC3826_Minimum_Partition_Score();
        int[] nums = {5, 2, 3};
        int k = 1;
        assertEquals(55, solver.minPartitionScore(nums, k));
    }
}
