package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC3174_Clear_Digits_Test {

    @Test
    public void testStandardCase() {
        assertEquals("abc", LC3174_Clear_Digits.clearDigits("abc"));
    }

    @Test
    public void testDigitsCleared() {
        assertEquals("", LC3174_Clear_Digits.clearDigits("cb34"));
    }

    @Test
    public void testMixedCase() {
        assertEquals("", LC3174_Clear_Digits.clearDigits("a1b2c3"));
    }
}
