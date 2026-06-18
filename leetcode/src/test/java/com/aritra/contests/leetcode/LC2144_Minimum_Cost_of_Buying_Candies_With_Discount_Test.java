package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC2144_Minimum_Cost_of_Buying_Candies_With_Discount_Test {

    @Test
    public void testStandardCase() {
        LC2144_Minimum_Cost_of_Buying_Candies_With_Discount solver = new LC2144_Minimum_Cost_of_Buying_Candies_With_Discount();
        int[] cost = {1,2,3};
        assertThrows(UnsupportedOperationException.class, () -> solver.minimumCost(cost));
    }
}
