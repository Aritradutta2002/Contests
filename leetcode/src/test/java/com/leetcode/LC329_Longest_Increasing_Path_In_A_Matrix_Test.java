package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC329_Longest_Increasing_Path_In_A_Matrix_Test {

    @Test
    public void testExample1() {
        LC329_Longest_Increasing_Path_In_A_Matrix solver = new LC329_Longest_Increasing_Path_In_A_Matrix();
        int[][] matrix = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        assertEquals(4, solver.longestIncreasingPath(matrix));
    }

    @Test
    public void testExample2() {
        LC329_Longest_Increasing_Path_In_A_Matrix solver = new LC329_Longest_Increasing_Path_In_A_Matrix();
        int[][] matrix = {{3, 4, 5}, {3, 2, 6}, {2, 2, 1}};
        assertEquals(4, solver.longestIncreasingPath(matrix));
    }

    @Test
    public void testExample3() {
        LC329_Longest_Increasing_Path_In_A_Matrix solver = new LC329_Longest_Increasing_Path_In_A_Matrix();
        int[][] matrix = {{1}};
        assertEquals(1, solver.longestIncreasingPath(matrix));
    }
}
