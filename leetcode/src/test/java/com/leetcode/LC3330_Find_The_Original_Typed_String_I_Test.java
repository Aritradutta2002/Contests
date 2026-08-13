package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC3330_Find_The_Original_Typed_String_I_Test {

    @Test
    public void testStandardCase() {
        assertEquals(5, LC3330_Find_The_Original_Typed_String_I.possibleStringCount("abbcccc"));
    }

    @Test
    public void testAllUnique() {
        assertEquals(1, LC3330_Find_The_Original_Typed_String_I.possibleStringCount("abc"));
    }
}
