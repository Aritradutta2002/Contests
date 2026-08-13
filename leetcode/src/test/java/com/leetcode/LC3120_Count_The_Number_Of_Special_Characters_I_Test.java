package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC3120_Count_The_Number_Of_Special_Characters_I_Test {

    @Test
    public void testStandardCase() {
        assertEquals(3, LC3120_Count_The_Number_Of_Special_Characters_I.numberOfSpecialChars("aaAbcBC"));
    }

    @Test
    public void testNoSpecialChars() {
        assertEquals(0, LC3120_Count_The_Number_Of_Special_Characters_I.numberOfSpecialChars("abc"));
    }
}
