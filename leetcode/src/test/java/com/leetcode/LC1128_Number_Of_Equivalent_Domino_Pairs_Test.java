package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC1128_Number_Of_Equivalent_Domino_Pairs_Test {

    @Test
    public void testStandardCase() {
        int[][] dominoes = {{1,2},{2,1},{3,4},{5,6}};
        assertEquals(1, LC1128_Number_Of_Equivalent_Domino_Pairs.numEquivDominoPairs(dominoes));
    }

    @Test
    public void testNoPairs() {
        int[][] dominoes = {{1,2},{3,4},{5,6}};
        assertEquals(0, LC1128_Number_Of_Equivalent_Domino_Pairs.numEquivDominoPairs(dominoes));
    }
}
