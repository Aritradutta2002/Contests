package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC342_Power_Of_Four_Test {

    @Test
    public void testPowerOfFour() {
        LC342_Power_Of_Four solver = new LC342_Power_Of_Four();
        assertTrue(solver.isPowerOfFour(16));
    }

    @Test
    public void testNotPowerOfFour() {
        LC342_Power_Of_Four solver = new LC342_Power_Of_Four();
        assertFalse(solver.isPowerOfFour(5));
    }

    @Test
    public void testOne() {
        LC342_Power_Of_Four solver = new LC342_Power_Of_Four();
        assertTrue(solver.isPowerOfFour(1));
    }

    @Test
    public void testZero() {
        LC342_Power_Of_Four solver = new LC342_Power_Of_Four();
        assertFalse(solver.isPowerOfFour(0));
    }
}
