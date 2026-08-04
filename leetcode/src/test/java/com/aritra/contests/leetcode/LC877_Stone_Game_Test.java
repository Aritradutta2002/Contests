package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC877_Stone_Game_Test {

    private final LC877_Stone_Game solver = new LC877_Stone_Game();

    @Test
    public void testExample1() {
        int[] piles = {5, 3, 4, 5};
        assertTrue(solver.stoneGame(piles));
    }

    @Test
    public void testExample2() {
        int[] piles = {3, 7, 2, 3};
        assertTrue(solver.stoneGame(piles));
    }
}