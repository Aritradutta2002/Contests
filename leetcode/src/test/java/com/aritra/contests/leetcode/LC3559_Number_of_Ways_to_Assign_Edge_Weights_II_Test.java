package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC3559_Number_of_Ways_to_Assign_Edge_Weights_II_Test {

    @Test
    public void testNotImplemented() {
        LC3559_Number_of_Ways_to_Assign_Edge_Weights_II solver = new LC3559_Number_of_Ways_to_Assign_Edge_Weights_II();
        int[][] edges = {{1, 2}, {2, 3}};
        int[][] queries = {{1, 3}};
        assertThrows(UnsupportedOperationException.class, () -> solver.assignEdgeWeights(edges, queries));
    }
}
