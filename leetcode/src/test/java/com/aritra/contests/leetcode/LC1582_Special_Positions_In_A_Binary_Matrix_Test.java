package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC1582_Special_Positions_In_A_Binary_Matrix_Test {

    @Test
    public void testStandardCase() {
        LC1582_Special_Positions_In_A_Binary_Matrix solver = new LC1582_Special_Positions_In_A_Binary_Matrix();
        int[][] mat = {{1,0,0},{0,0,1},{1,0,0}};
        assertEquals(1, solver.numSpecial(mat));
    }

    @Test
    public void testAllSpecial() {
        LC1582_Special_Positions_In_A_Binary_Matrix solver = new LC1582_Special_Positions_In_A_Binary_Matrix();
        int[][] mat = {{1,0,0},{0,1,0},{0,0,1}};
        assertEquals(3, solver.numSpecial(mat));
    }
}
