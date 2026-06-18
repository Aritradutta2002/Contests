package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC1021_Remove_Outermost_Parentheses_Test {

    @Test
    public void testStandardCase() {
        assertEquals("()()()", LC1021_Remove_Outermost_Parentheses.removeOuterParentheses("(()())(())"));
    }

    @Test
    public void testCaseTwo() {
        assertEquals("()()()()(())", LC1021_Remove_Outermost_Parentheses.removeOuterParentheses("(()())(())(()(()))"));
    }

    @Test
    public void testSinglePrimitive() {
        assertEquals("", LC1021_Remove_Outermost_Parentheses.removeOuterParentheses("()"));
    }
}
