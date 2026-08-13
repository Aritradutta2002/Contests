package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC1007_Minimum_Domino_Rotations_For_Equal_Row_Test {

    @Test
    public void testStandardCase() {
        int[] tops = {2,1,2,4,2,2};
        int[] bottoms = {5,2,6,2,3,2};
        assertEquals(2, LC1007_Minimum_Domino_Rotations_For_Equal_Row.minDominoRotations(tops, bottoms));
    }

    @Test
    public void testImpossibleCase() {
        int[] tops = {3,5,1,2,3};
        int[] bottoms = {3,6,3,3,4};
        assertEquals(-1, LC1007_Minimum_Domino_Rotations_For_Equal_Row.minDominoRotations(tops, bottoms));
    }
}
