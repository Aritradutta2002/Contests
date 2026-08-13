package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC1544_Make_The_String_Great_Test {

    @Test
    public void testStandardCase() {
        assertEquals("leetcode", LC1544_Make_The_String_Great.makeGood("leEeetcode"));
    }

    @Test
    public void testEmptyString() {
        assertEquals("", LC1544_Make_The_String_Great.makeGood("abBAcC"));
    }

    @Test
    public void testNoChange() {
        assertEquals("abc", LC1544_Make_The_String_Great.makeGood("abc"));
    }
}
