package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC2075_Decode_The_Slanted_Ciphertext_Test {

    @Test
    public void testStandardCase() {
        LC2075_Decode_The_Slanted_Ciphertext solver = new LC2075_Decode_The_Slanted_Ciphertext();
        assertEquals("c h", solver.decodeCiphertext("ch   n", 3));
    }

    @Test
    public void testEmptyString() {
        LC2075_Decode_The_Slanted_Ciphertext solver = new LC2075_Decode_The_Slanted_Ciphertext();
        assertEquals("", solver.decodeCiphertext("", 1));
    }
}
