package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC2033_Minimum_Operations_to_Make_a_Uni_Value_Grid_Test {

    @Test
    public void testStandardCase() {
        LC2033_Minimum_Operations_to_Make_a_Uni_Value_Grid solver = new LC2033_Minimum_Operations_to_Make_a_Uni_Value_Grid();
        int[][] grid = {{2,4},{6,8}};
        assertEquals(4, solver.minOperations(grid, 2));
    }

    @Test
    public void testImpossibleCase() {
        LC2033_Minimum_Operations_to_Make_a_Uni_Value_Grid solver = new LC2033_Minimum_Operations_to_Make_a_Uni_Value_Grid();
        int[][] grid = {{1,5},{2,3}};
        assertEquals(-1, solver.minOperations(grid, 2));
    }
}
