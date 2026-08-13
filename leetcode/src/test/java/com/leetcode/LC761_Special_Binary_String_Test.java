package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC761_Special_Binary_String_Test {

    @Test
    public void testMakeLargestSpecialExample1() {
        LC761_Special_Binary_String solver = new LC761_Special_Binary_String();
        assertEquals("11100100", solver.makeLargestSpecial("11011000"));
    }

    @Test
    public void testMakeLargestSpecialExample2() {
        LC761_Special_Binary_String solver = new LC761_Special_Binary_String();
        assertEquals("10", solver.makeLargestSpecial("10"));
    }

    @Test
    public void testMakeLargestSpecialEmpty() {
        LC761_Special_Binary_String solver = new LC761_Special_Binary_String();
        assertEquals("", solver.makeLargestSpecial(""));
    }
}
