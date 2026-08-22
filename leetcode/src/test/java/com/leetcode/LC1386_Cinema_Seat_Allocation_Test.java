package com.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class LC1386_Cinema_Seat_Allocation_Test {

    private final LC1386_Cinema_Seat_Allocation solver = new LC1386_Cinema_Seat_Allocation();

    @Test
    public void testExample1() {
        int param1 = 3;
        int[][] param2 = new int[][]{{1,2},{1,3},{1,8},{2,6},{3,1},{3,10}};
        int expected = 4;
        int actual = solver.maxNumberOfFamilies(param1, param2);
        assertEquals(expected, actual);
    }

    @Test
    public void testExample2() {
        int param1 = 2;
        int[][] param2 = new int[][]{{2,1},{1,8},{2,6}};
        int expected = 2;
        int actual = solver.maxNumberOfFamilies(param1, param2);
        assertEquals(expected, actual);
    }

    @Test
    public void testExample3() {
        int param1 = 4;
        int[][] param2 = new int[][]{{4,3},{1,4},{4,6},{1,7}};
        int expected = 4;
        int actual = solver.maxNumberOfFamilies(param1, param2);
        assertEquals(expected, actual);
    }
}