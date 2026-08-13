package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC3234_Check_If_Strings_Can_Be_Made_Equal_With_Operations_II_Test {

    @Test
    public void testCanBeEqual() {
        LC3234_Check_If_Strings_Can_Be_Made_Equal_With_Operations_II solver = new LC3234_Check_If_Strings_Can_Be_Made_Equal_With_Operations_II();
        assertTrue(solver.checkStrings("abcdba", "cabdab"));
    }

    @Test
    public void testCannotBeEqual() {
        LC3234_Check_If_Strings_Can_Be_Made_Equal_With_Operations_II solver = new LC3234_Check_If_Strings_Can_Be_Made_Equal_With_Operations_II();
        assertFalse(solver.checkStrings("abe", "bea"));
    }
}
