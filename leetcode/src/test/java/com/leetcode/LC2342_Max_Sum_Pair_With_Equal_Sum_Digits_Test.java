package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC2342_Max_Sum_Pair_With_Equal_Sum_Digits_Test {

    @Test
    public void testStandardCase() {
        int[] nums = {18,43,36,13,7};
        assertEquals(54, LC2342_Max_Sum_Pair_With_Equal_Sum_Digits.maximumSum(nums));
    }

    @Test
    public void testNoPair() {
        int[] nums = {10,12,19,14};
        assertEquals(-1, LC2342_Max_Sum_Pair_With_Equal_Sum_Digits.maximumSum(nums));
    }
}
