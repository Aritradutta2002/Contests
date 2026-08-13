package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC2028_Find_Missing_Observations_Test {

    @Test
    public void testStandardCase() {
        int[] rolls = {3,2,4,3};
        int[] result = LC2028_Find_Missing_Observations.missingRolls(rolls, 4, 2);
        assertEquals(2, result.length);
    }

    @Test
    public void testImpossibleCase() {
        int[] rolls = {1,5,6};
        int[] result = LC2028_Find_Missing_Observations.missingRolls(rolls, 3, 4);
        assertEquals(4, result.length);
    }
}
