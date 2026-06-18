package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC2145_Count_The_Hidden_Sequences_Test {

    @Test
    public void testStandardCase() {
        int[] differences = {1,-3,4};
        assertEquals(2, LC2145_Count_The_Hidden_Sequences.numberOfArrays(differences, 1, 6));
    }

    @Test
    public void testNoPossibleArrays() {
        int[] differences = {3,-4,5};
        assertEquals(0, LC2145_Count_The_Hidden_Sequences.numberOfArrays(differences, 1, 2));
    }
}
