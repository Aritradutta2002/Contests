package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC3464_Maximize_The_Distance_Between_Points_On_A_Square_Test {

    @Test
    public void testExample1() {
        LC3464_Maximize_The_Distance_Between_Points_On_A_Square solver = new LC3464_Maximize_The_Distance_Between_Points_On_A_Square();
        int side = 2;
        int[][] points = {{0, 2}, {2, 0}, {2, 2}, {0, 0}};
        int k = 4;
        assertEquals(2, solver.maxDistance(side, points, k));
    }

    @Test
    public void testExample2() {
        LC3464_Maximize_The_Distance_Between_Points_On_A_Square solver = new LC3464_Maximize_The_Distance_Between_Points_On_A_Square();
        int side = 2;
        int[][] points = {{0, 0}, {1, 2}, {2, 0}, {2, 2}, {0, 2}};
        int k = 3;
        assertEquals(2, solver.maxDistance(side, points, k));
    }
}
