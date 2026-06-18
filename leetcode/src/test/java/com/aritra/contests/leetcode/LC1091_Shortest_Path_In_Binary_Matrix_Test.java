package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC1091_Shortest_Path_In_Binary_Matrix_Test {

    @Test
    public void testStandardCase() {
        int[][] grid = {{0,1},{1,0}};
        assertEquals(2, LC1091_Shortest_Path_In_Binary_Matrix.shortestPathBinaryMatrix(grid));
    }

    @Test
    public void testBlockedStart() {
        int[][] grid = {{1,0},{0,0}};
        assertEquals(-1, LC1091_Shortest_Path_In_Binary_Matrix.shortestPathBinaryMatrix(grid));
    }

    @Test
    public void testSingleCell() {
        int[][] grid = {{0}};
        assertEquals(1, LC1091_Shortest_Path_In_Binary_Matrix.shortestPathBinaryMatrix(grid));
    }
}
