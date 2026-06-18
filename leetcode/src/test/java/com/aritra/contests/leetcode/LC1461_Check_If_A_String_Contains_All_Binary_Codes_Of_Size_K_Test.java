package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC1461_Check_If_A_String_Contains_All_Binary_Codes_Of_Size_K_Test {

    @Test
    public void testStandardCase() {
        assertTrue(LC1461_Check_If_A_String_Contains_All_Binary_Codes_Of_Size_K.hasAllCodes("00110110", 2));
    }

    @Test
    public void testFalseCase() {
        assertTrue(LC1461_Check_If_A_String_Contains_All_Binary_Codes_Of_Size_K.hasAllCodes("0110", 1));
    }

    @Test
    public void testLengthLessThanK() {
        assertFalse(LC1461_Check_If_A_String_Contains_All_Binary_Codes_Of_Size_K.hasAllCodes("00110", 10));
    }
}
