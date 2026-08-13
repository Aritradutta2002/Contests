package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC1009_Complement_Of_Base_10_Integer_Test {

    @Test
    public void testStandardCase() {
        LC1009_Complement_Of_Base_10_Integer solver = new LC1009_Complement_Of_Base_10_Integer();
        assertEquals(2, solver.bitwiseComplement(5));
    }

    @Test
    public void testCaseSeven() {
        LC1009_Complement_Of_Base_10_Integer solver = new LC1009_Complement_Of_Base_10_Integer();
        assertEquals(0, solver.bitwiseComplement(7));
    }

    @Test
    public void testCaseTen() {
        LC1009_Complement_Of_Base_10_Integer solver = new LC1009_Complement_Of_Base_10_Integer();
        assertEquals(5, solver.bitwiseComplement(10));
    }
}
