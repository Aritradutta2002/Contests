package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC1197_Minimum_Knight_Moves_Test {

    @Test
    public void testZeroZero() {
        assertEquals(0, LC1197_Minimum_Knight_Moves.minKnightMoves(0, 0));
    }

    @Test
    public void testTwoOne() {
        assertEquals(1, LC1197_Minimum_Knight_Moves.minKnightMoves(2, 1));
    }

    @Test
    public void testFiveFive() {
        assertEquals(4, LC1197_Minimum_Knight_Moves.minKnightMoves(5, 5));
    }
}
