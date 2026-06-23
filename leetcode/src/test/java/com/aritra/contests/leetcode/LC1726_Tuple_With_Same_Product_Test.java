package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC1726_Tuple_With_Same_Product_Test {

    @Test
    public void testStandardCase() {
        int[] nums = {2,3,4,6};
        assertEquals(0, LC1726_Tuple_With_Same_Product.tupleSameProduct(nums));
    }
}
