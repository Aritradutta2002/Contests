package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC1331_Rank_Transform_Of_An_Array_Test {

    @Test
    // Validates that each element is replaced by its rank in a mixed-value array.
    public void testStandardCase() {
        LC1331_Rank_Transform_Of_An_Array solver = new LC1331_Rank_Transform_Of_An_Array();
        int[] arr = {40, 10, 20, 30};
        int[] expected = {4, 1, 2, 3};
        assertArrayEquals(expected, solver.arrayRankTransform(arr));
    }

    @Test
    // Validates that equal elements share the same rank.
    public void testAllEqualElements() {
        LC1331_Rank_Transform_Of_An_Array solver = new LC1331_Rank_Transform_Of_An_Array();
        int[] arr = {100, 100, 100};
        int[] expected = {1, 1, 1};
        assertArrayEquals(expected, solver.arrayRankTransform(arr));
    }

    @Test
    // Validates ranking with duplicates and a larger array of distinct values.
    public void testWithDuplicatesAndLargerArray() {
        LC1331_Rank_Transform_Of_An_Array solver = new LC1331_Rank_Transform_Of_An_Array();
        int[] arr = {37, 12, 28, 9, 100, 56, 80, 5, 12};
        int[] expected = {5, 3, 4, 2, 8, 6, 7, 1, 3};
        assertArrayEquals(expected, solver.arrayRankTransform(arr));
    }
}
