package com.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class LC3517_Smallest_Palindromic_Rearrangement_I_Test {

    private final LC3517_Smallest_Palindromic_Rearrangement_I solution = new LC3517_Smallest_Palindromic_Rearrangement_I();

    @Test
    void testSingleCharacterPalindrome() {
        // A string of only one character is already the lexicographically smallest palindrome.
        assertEquals("z", solution.smallestPalindrome("z"));
    }

    @Test
    void testOddLengthPalindrome() {
        // Rearranging "babab" -> "abbba" gives the smallest lexicographic palindrome.
        assertEquals("abbba", solution.smallestPalindrome("babab"));
    }

    @Test
    void testEvenLengthPalindrome() {
        // Rearranging "daccad" -> "acddca" gives the smallest lexicographic palindrome.
        assertEquals("acddca", solution.smallestPalindrome("daccad"));
    }
}
