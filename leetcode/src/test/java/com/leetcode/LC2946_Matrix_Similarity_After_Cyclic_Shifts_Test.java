package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC2946_Matrix_Similarity_After_Cyclic_Shifts_Test {

    @Test
    public void testStandardCase() {
        LC2946_Matrix_Similarity_After_Cyclic_Shifts solver = new LC2946_Matrix_Similarity_After_Cyclic_Shifts();
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        assertTrue(solver.areSimilar(mat, 3));
    }

    @Test
    public void testNotSimilar() {
        LC2946_Matrix_Similarity_After_Cyclic_Shifts solver = new LC2946_Matrix_Similarity_After_Cyclic_Shifts();
        int[][] mat = {{1,2,1,2},{1,2,1,2}};
        assertFalse(solver.areSimilar(mat, 1));
    }
}
