package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC1886_Determine_Whether_Matrix_Can_Be_Obtained_By_Rotation_Test {

    @Test
    public void testCanRotate() {
        LC1886_Determine_Whether_Matrix_Can_Be_Obtained_By_Rotation solver = new LC1886_Determine_Whether_Matrix_Can_Be_Obtained_By_Rotation();
        int[][] mat = {{0,1},{1,0}};
        int[][] target = {{1,0},{0,1}};
        assertTrue(solver.findRotation(mat, target));
    }

    @Test
    public void testCannotRotate() {
        LC1886_Determine_Whether_Matrix_Can_Be_Obtained_By_Rotation solver = new LC1886_Determine_Whether_Matrix_Can_Be_Obtained_By_Rotation();
        int[][] mat = {{0,1},{1,1}};
        int[][] target = {{1,0},{0,1}};
        assertFalse(solver.findRotation(mat, target));
    }
}
