package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC2226_Maximum_Candies_Allocated_To_K_Children_Test {

    @Test
    public void testStandardCase() {
        int[] candies = {5,8,6};
        assertEquals(5, LC2226_Maximum_Candies_Allocated_To_K_Children.maximumCandies(candies, 3));
    }

    @Test
    public void testImpossibleCase() {
        int[] candies = {1,2,3};
        assertEquals(2, LC2226_Maximum_Candies_Allocated_To_K_Children.maximumCandies(candies, 2));
    }
}
