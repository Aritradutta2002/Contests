package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/*
 * Tests for 3499. Maximize Active Section with Trade I
 */
public class LC3499_Maximize_Active_Section_With_Trade_I_Test {

    @Test
    public void testExample1_NoTradePossible() {
        // s = "01" -> No block of '1's surrounded by '0's, so no valid trade.
        // Maximum active sections = 1.
        LC3499_Maximize_Active_Section_With_Trade_I solver =
                new LC3499_Maximize_Active_Section_With_Trade_I();
        assertEquals(1, solver.maxActiveSectionsAfterTrade("01"));
    }

    @Test
    public void testExample2_TurnAllOnes() {
        // s = "0100" -> Augmented "101001". Convert "1" (surrounded by '0's) to '0',
        // then convert "0000" (surrounded by '1's) to '1111' -> final "1111".
        // Maximum active sections = 4.
        LC3499_Maximize_Active_Section_With_Trade_I solver =
                new LC3499_Maximize_Active_Section_With_Trade_I();
        assertEquals(4, solver.maxActiveSectionsAfterTrade("0100"));
    }

    @Test
    public void testExample3_AllOnesAfterTrade() {
        // s = "1000100" -> Augmented "110001001". After trade final string is
        // "1111111" -> Maximum active sections = 7.
        LC3499_Maximize_Active_Section_With_Trade_I solver =
                new LC3499_Maximize_Active_Section_With_Trade_I();
        assertEquals(7, solver.maxActiveSectionsAfterTrade("1000100"));
    }

    @Test
    public void testExample4_AlternatingPattern() {
        // s = "01010" -> Augmented "1010101". After trade final string is
        // "11110" -> Maximum active sections = 4.
        LC3499_Maximize_Active_Section_With_Trade_I solver =
                new LC3499_Maximize_Active_Section_With_Trade_I();
        assertEquals(4, solver.maxActiveSectionsAfterTrade("01010"));
    }
}
