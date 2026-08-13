package com.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class LC3754_Concatenate_Non_Zero_Digits_And_Multiply_By_Sum_I_Test {

    @Test
    public void testExampleOne() {
        assertEquals(12340L, LC3754_Concatenate_Non_Zero_Digits_And_Multiply_By_Sum_I.concatenateNonZeroDigitsAndMultiplyBySum(10203004));
    }

    @Test
    public void testExampleTwo() {
        assertEquals(1L, LC3754_Concatenate_Non_Zero_Digits_And_Multiply_By_Sum_I.concatenateNonZeroDigitsAndMultiplyBySum(1000));
    }

    @Test
    public void testAllZeros() {
        assertEquals(0L, LC3754_Concatenate_Non_Zero_Digits_And_Multiply_By_Sum_I.concatenateNonZeroDigitsAndMultiplyBySum(0));
    }

    @Test
    public void testOverflowSensitiveCase() {
        assertEquals(44444444445L, LC3754_Concatenate_Non_Zero_Digits_And_Multiply_By_Sum_I.concatenateNonZeroDigitsAndMultiplyBySum(987654321));
    }
}