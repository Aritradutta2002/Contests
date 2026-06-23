package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC2839_Check_If_Strings_Can_Be_Made_Equal_With_Operations_I_Test {

    @Test
    public void testCanBeEqual() {
        assertTrue(LC2839_Check_If_Strings_Can_Be_Made_Equal_With_Operations_I.canBeEqual("abcd", "cdab"));
    }

    @Test
    public void testCannotBeEqual() {
        assertTrue(LC2839_Check_If_Strings_Can_Be_Made_Equal_With_Operations_I.canBeEqual("abcd", "abcd"));
    }
}
