package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC1680_Concatenation_Of_Consecutive_Binary_Numbers_Test {

    @Test
    public void testStandardCase() {
        assertEquals(1, LC1680_Concatenation_Of_Consecutive_Binary_Numbers.concatenatedBinary(1));
    }

    @Test
    public void testCaseThree() {
        assertEquals(27, LC1680_Concatenation_Of_Consecutive_Binary_Numbers.concatenatedBinary(3));
    }

    @Test
    public void testCaseTwelve() {
        assertEquals(505379714, LC1680_Concatenation_Of_Consecutive_Binary_Numbers.concatenatedBinary(12));
    }
}
