package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC2094_Finding_3_Digit_Even_Numbers_Test {

    @Test
    public void testStandardCase() {
        int[] digits = {2,1,3,0};
        int[] expected = {102,120,130,132,210,230,302,310,312,320};
        assertArrayEquals(expected, LC2094_Finding_3_Digit_Even_Numbers.findEvenNumbers(digits));
    }

    @Test
    public void testLessThanThreeDigits() {
        int[] digits = {1,2};
        assertArrayEquals(new int[0], LC2094_Finding_3_Digit_Even_Numbers.findEvenNumbers(digits));
    }
}
