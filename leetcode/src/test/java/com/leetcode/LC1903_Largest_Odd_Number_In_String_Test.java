package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC1903_Largest_Odd_Number_In_String_Test {

    @Test
    public void testStandardCase() {
        assertEquals("5", LC1903_Largest_Odd_Number_In_String.largeOddNum("52"));
    }

    @Test
    public void testCaseThree() {
        assertEquals("35427", LC1903_Largest_Odd_Number_In_String.largeOddNum("35427"));
    }

    @Test
    public void testLeadingZeroOdd() {
        // Function internally calls Integer.parseInt which can throw on empty substring;
        // this test validates that a valid odd number is still found
        String result = LC1903_Largest_Odd_Number_In_String.largeOddNum("102");
        assertFalse(result.isEmpty());
    }
}
