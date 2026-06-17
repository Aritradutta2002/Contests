package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC130_Surrounded_Regions_Test {

    private final LC130_Surrounded_Regions solver = new LC130_Surrounded_Regions();

    @Test
    public void testStandardCase() {
        char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        assertThrows(UnsupportedOperationException.class, () -> solver.solve(board));
    }

    @Test
    public void testSingleX() {
        char[][] board = {{'X'}};
        assertThrows(UnsupportedOperationException.class, () -> solver.solve(board));
    }

    @Test
    public void testSingleO() {
        char[][] board = {{'O'}};
        assertThrows(UnsupportedOperationException.class, () -> solver.solve(board));
    }
}
