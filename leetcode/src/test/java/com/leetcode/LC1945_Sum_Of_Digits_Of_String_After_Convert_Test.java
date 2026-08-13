package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC1945_Sum_Of_Digits_Of_String_After_Convert_Test {

    @Test
    public void testStandardCase() {
        assertEquals(36, LC1945_Sum_Of_Digits_Of_String_After_Convert.getLucky("iiii", 1));
    }

    @Test
    public void testMultipleTransforms() {
        assertEquals(6, LC1945_Sum_Of_Digits_Of_String_After_Convert.getLucky("leetcode", 2));
    }
}
