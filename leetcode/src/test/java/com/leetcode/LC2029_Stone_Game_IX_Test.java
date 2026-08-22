package com.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class LC2029_Stone_Game_IX_Test {

    private final LC2029_Stone_Game_IX solver = new LC2029_Stone_Game_IX();

    @Test
    public void testExample1() {
        int[] param1 = new int[]{2,1};
        boolean expected = true;
        boolean actual = solver.stoneGameIX(param1);
        assertEquals(expected, actual);
    }

    @Test
    public void testExample2() {
        int[] param1 = new int[]{2};
        boolean expected = false;
        boolean actual = solver.stoneGameIX(param1);
        assertEquals(expected, actual);
    }

    @Test
    public void testExample3() {
        int[] param1 = new int[]{5,1,2,4,3};
        boolean expected = false;
        boolean actual = solver.stoneGameIX(param1);
        assertEquals(expected, actual);
    }
}