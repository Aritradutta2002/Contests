package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC1545_Find_Kth_Bit_In_Nth_Binary_String_Test {

    @Test
    public void testStandardCase() {
        LC1545_Find_Kth_Bit_In_Nth_Binary_String solver = new LC1545_Find_Kth_Bit_In_Nth_Binary_String();
        assertEquals('0', solver.findKthBit(3, 1));
    }

    @Test
    public void testMiddleBit() {
        LC1545_Find_Kth_Bit_In_Nth_Binary_String solver = new LC1545_Find_Kth_Bit_In_Nth_Binary_String();
        assertEquals('1', solver.findKthBit(4, 11));
    }

    @Test
    public void testFirstLevel() {
        LC1545_Find_Kth_Bit_In_Nth_Binary_String solver = new LC1545_Find_Kth_Bit_In_Nth_Binary_String();
        assertEquals('0', solver.findKthBit(1, 1));
    }
}
