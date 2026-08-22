package com.leetcode;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

public class LC3559_Number_of_Ways_to_Assign_Edge_Weights_II_Test {

    @Test
    public void testPathWithTwoEdges() {
        LC3559_Number_of_Ways_to_Assign_Edge_Weights_II solver = new LC3559_Number_of_Ways_to_Assign_Edge_Weights_II();
        int[][] edges = {{1, 2}, {2, 3}};
        int[][] queries = {{1, 3}};
        assertArrayEquals(new int[]{2}, solver.assignEdgeWeights(edges, queries));
    }
}
