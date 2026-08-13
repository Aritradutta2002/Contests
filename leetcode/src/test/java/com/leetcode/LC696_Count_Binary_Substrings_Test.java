package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC696_Count_Binary_Substrings_Test {

    @Test
    public void testCountBinarySubstringsExample1() {
        assertEquals(6, LC696_Count_Binary_Substrings.countBinarySubstrings("00110011"));
    }

    @Test
    public void testCountBinarySubstringsExample2() {
        assertEquals(4, LC696_Count_Binary_Substrings.countBinarySubstrings("10101"));
    }

    @Test
    public void testCountBinarySubstringsEmpty() {
        assertEquals(0, LC696_Count_Binary_Substrings.countBinarySubstrings(""));
    }

    @Test
    public void testCountBinarySubstringsAllSame() {
        assertEquals(0, LC696_Count_Binary_Substrings.countBinarySubstrings("0000"));
    }
}
