package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC1758_Minimum_Changes_To_Make_Alternating_Binary_String_Test {

    @Test
    public void testStandardCase() {
        LC1758_Minimum_Changes_To_Make_Alternating_Binary_String solver = new LC1758_Minimum_Changes_To_Make_Alternating_Binary_String();
        assertEquals(1, solver.minOperations("0100"));
    }

    @Test
    public void testAlreadyAlternating() {
        LC1758_Minimum_Changes_To_Make_Alternating_Binary_String solver = new LC1758_Minimum_Changes_To_Make_Alternating_Binary_String();
        assertEquals(0, solver.minOperations("10"));
    }

    @Test
    public void testAllOnes() {
        LC1758_Minimum_Changes_To_Make_Alternating_Binary_String solver = new LC1758_Minimum_Changes_To_Make_Alternating_Binary_String();
        assertEquals(2, solver.minOperations("1111"));
    }
}
