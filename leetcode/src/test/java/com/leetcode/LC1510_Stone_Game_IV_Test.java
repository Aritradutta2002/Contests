package com.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class LC1510_Stone_Game_IV_Test {

    private final LC1510_Stone_Game_IV solver = new LC1510_Stone_Game_IV();

    @Test
    public void testExample1() {
        int param1 = 1;
        boolean expected = true;
        boolean actual = solver.winnerSquareGame(param1);
        assertEquals(expected, actual);
    }

    @Test
    public void testExample2() {
        int param1 = 2;
        boolean expected = false;
        boolean actual = solver.winnerSquareGame(param1);
        assertEquals(expected, actual);
    }

    @Test
    public void testExample3() {
        int param1 = 4;
        boolean expected = true;
        boolean actual = solver.winnerSquareGame(param1);
        assertEquals(expected, actual);
    }
}