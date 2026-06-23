package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC3838_Weighted_Word_Mapping_Test {

    private final LC3838_Weighted_Word_Mapping solver = new LC3838_Weighted_Word_Mapping();

    @Test
    public void testStandardExample() {
        String[] words = {"abcd", "def", "xyz"};
        int[] weights = {5, 3, 12, 14, 1, 2, 3, 2, 10, 6, 6, 9, 7, 8, 7, 10, 8, 9, 6, 9, 9, 8, 3, 7, 7, 2};
        assertEquals("rij", solver.mapWordWeights(words, weights));
    }

    @Test
    public void testUniformWeights() {
        String[] words = {"a", "b", "c"};
        int[] weights = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        assertEquals("yyy", solver.mapWordWeights(words, weights));
    }

    @Test
    public void testSingleWord() {
        String[] words = {"abcd"};
        int[] weights = {7, 5, 3, 4, 3, 5, 4, 9, 4, 2, 2, 7, 10, 2, 5, 10, 6, 1, 2, 2, 4, 1, 3, 4, 4, 5};
        assertEquals("g", solver.mapWordWeights(words, weights));
    }
}
