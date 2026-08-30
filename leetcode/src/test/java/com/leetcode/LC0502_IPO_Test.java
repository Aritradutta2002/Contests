package com.leetcode;

import java.util.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC0502_IPO_Test {

    private final LC0502_IPO solver = new LC0502_IPO();

    @Test
    public void testExample1() {
        int param1 = 2;
        int param2 = 0;
        int[] param3 = new int[]{1,2,3};
        int[] param4 = new int[]{0,1,1};
        int expected = 4;
        int actual = solver.findMaximizedCapital(param1, param2, param3, param4);
        assertEquals(expected, actual);
    }

    @Test
    public void testExample2() {
        int param1 = 3;
        int param2 = 0;
        int[] param3 = new int[]{1,2,3};
        int[] param4 = new int[]{0,1,2};
        int expected = 6;
        int actual = solver.findMaximizedCapital(param1, param2, param3, param4);
        assertEquals(expected, actual);
    }
}