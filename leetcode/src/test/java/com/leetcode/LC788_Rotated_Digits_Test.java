package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC788_Rotated_Digits_Test {

    @Test
    public void testRotatedDigitsExample1() {
        LC788_Rotated_Digits solver = new LC788_Rotated_Digits();
        assertEquals(4, solver.rotatedDigits(10));
    }

    @Test
    public void testRotatedDigitsExample2() {
        LC788_Rotated_Digits solver = new LC788_Rotated_Digits();
        assertEquals(0, solver.rotatedDigits(1));
    }

    @Test
    public void testRotatedDigitsUptoTwo() {
        LC788_Rotated_Digits solver = new LC788_Rotated_Digits();
        assertEquals(1, solver.rotatedDigits(2));
    }
}
