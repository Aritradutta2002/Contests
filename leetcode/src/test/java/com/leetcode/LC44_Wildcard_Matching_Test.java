package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC44_Wildcard_Matching_Test {

    @Test
    public void testIsMatchExample1() {
        LC44_Wildcard_Matching solver = new LC44_Wildcard_Matching();
        assertFalse(solver.isMatch("aa", "a"));
    }

    @Test
    public void testIsMatchExample2() {
        LC44_Wildcard_Matching solver = new LC44_Wildcard_Matching();
        assertTrue(solver.isMatch("aa", "*"));
    }

    @Test
    public void testIsMatchExample3() {
        LC44_Wildcard_Matching solver = new LC44_Wildcard_Matching();
        assertFalse(solver.isMatch("cb", "?a"));
    }

    @Test
    public void testIsMatchExample4() {
        LC44_Wildcard_Matching solver = new LC44_Wildcard_Matching();
        assertTrue(solver.isMatch("adceb", "*a*b"));
    }

    @Test
    public void testIsMatchEmptyPatternEmptyString() {
        LC44_Wildcard_Matching solver = new LC44_Wildcard_Matching();
        assertTrue(solver.isMatch("", ""));
    }

    @Test
    public void testIsMatchMultipleStars() {
        LC44_Wildcard_Matching solver = new LC44_Wildcard_Matching();
        assertFalse(solver.isMatch("acdcb", "a*c?b"));
    }
}
