package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC657_Robot_Return_To_Origin_Test {

    @Test
    public void testReturnsToOrigin() {
        LC657_Robot_Return_To_Origin solver = new LC657_Robot_Return_To_Origin();
        assertTrue(solver.judgeCircle("UD"));
    }

    @Test
    public void testDoesNotReturn() {
        LC657_Robot_Return_To_Origin solver = new LC657_Robot_Return_To_Origin();
        assertFalse(solver.judgeCircle("LL"));
    }

    @Test
    public void testComplexPath() {
        LC657_Robot_Return_To_Origin solver = new LC657_Robot_Return_To_Origin();
        assertTrue(solver.judgeCircle("LRUD"));
    }
}
