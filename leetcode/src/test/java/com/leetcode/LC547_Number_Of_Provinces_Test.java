package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC547_Number_Of_Provinces_Test {

    private final LC547_Number_Of_Provinces solver = new LC547_Number_Of_Provinces();

    @Test
    public void testTwoProvinces() {
        int[][] isConnected = {
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 1}
        };
        assertEquals(2, solver.findCircleNum(isConnected));
    }

    @Test
    public void testThreeProvinces() {
        int[][] isConnected = {
            {1, 0, 0},
            {0, 1, 0},
            {0, 0, 1}
        };
        assertEquals(3, solver.findCircleNum(isConnected));
    }

    @Test
    public void testSingleCity() {
        int[][] isConnected = {{1}};
        assertEquals(1, solver.findCircleNum(isConnected));
    }
}
