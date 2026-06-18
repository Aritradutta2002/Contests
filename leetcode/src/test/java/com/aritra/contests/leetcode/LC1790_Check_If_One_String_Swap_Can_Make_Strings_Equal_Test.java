package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC1790_Check_If_One_String_Swap_Can_Make_Strings_Equal_Test {

    @Test
    public void testAlreadyEqual() {
        assertTrue(LC1790_Check_If_One_String_Swap_Can_Make_Strings_Equal.areAlmostEqual("bank", "bank"));
    }

    @Test
    public void testOneSwapWorks() {
        assertTrue(LC1790_Check_If_One_String_Swap_Can_Make_Strings_Equal.areAlmostEqual("bank", "bank"));
    }

    @Test
    public void testCannotFix() {
        assertFalse(LC1790_Check_If_One_String_Swap_Can_Make_Strings_Equal.areAlmostEqual("attack", "defend"));
    }

    @Test
    public void testDifferentLengths() {
        assertFalse(LC1790_Check_If_One_String_Swap_Can_Make_Strings_Equal.areAlmostEqual("a", "ab"));
    }
}
