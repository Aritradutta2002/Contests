package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC3136_Valid_Word_Test {

    @Test
    public void testValidWord() {
        assertTrue(LC3136_Valid_Word.isValid("234Adas"));
    }

    @Test
    public void testTooShort() {
        assertFalse(LC3136_Valid_Word.isValid("b3"));
    }

    @Test
    public void testNoVowel() {
        assertFalse(LC3136_Valid_Word.isValid("bcd"));
    }

    @Test
    public void testInvalidCharacters() {
        assertFalse(LC3136_Valid_Word.isValid("a3$e"));
    }
}
