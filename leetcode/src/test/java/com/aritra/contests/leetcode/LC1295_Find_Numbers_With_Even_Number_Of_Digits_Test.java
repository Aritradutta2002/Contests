package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC1295_Find_Numbers_With_Even_Number_Of_Digits_Test {

    @Test
    public void testStandardCase() {
        int[] nums = {12,345,2,6,7896};
        assertEquals(2, LC1295_Find_Numbers_With_Even_Number_Of_Digits.findNumbers(nums));
    }

    @Test
    public void testAllOddDigits() {
        int[] nums = {555,901,482,1771};
        assertEquals(1, LC1295_Find_Numbers_With_Even_Number_Of_Digits.findNumbers(nums));
    }
}
