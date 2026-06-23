package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC1079_Letter_Tile_Possibilities_Test {

    @Test
    public void testStandardCase() {
        assertEquals(8, LC1079_Letter_Tile_Possibilities.numTilePossibilities("AAB"));
    }

    @Test
    public void testCaseTwo() {
        assertEquals(188, LC1079_Letter_Tile_Possibilities.numTilePossibilities("AAABBC"));
    }

    @Test
    public void testSingleChar() {
        assertEquals(1, LC1079_Letter_Tile_Possibilities.numTilePossibilities("V"));
    }
}
