package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC1559_Detect_Cycles_in_2D_Grid_Test {

    @Test
    public void testContainsCycle() {
        LC1559_Detect_Cycles_in_2D_Grid solver = new LC1559_Detect_Cycles_in_2D_Grid();
        char[][] grid = {
            {'a','a','a','a'},
            {'a','b','b','a'},
            {'a','b','b','a'},
            {'a','a','a','a'}
        };
        assertTrue(solver.containsCycle(grid));
    }

    @Test
    public void testNoCycle() {
        LC1559_Detect_Cycles_in_2D_Grid solver = new LC1559_Detect_Cycles_in_2D_Grid();
        char[][] grid = {
            {'a','b'},
            {'b','a'}
        };
        assertFalse(solver.containsCycle(grid));
    }
}
