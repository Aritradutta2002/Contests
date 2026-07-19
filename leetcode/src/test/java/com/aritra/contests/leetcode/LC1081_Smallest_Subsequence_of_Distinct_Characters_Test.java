package com.aritra.contests.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/*
 * Test class for LC1081: Smallest Subsequence of Distinct Characters
 */
public class LC1081_Smallest_Subsequence_of_Distinct_Characters_Test {

    private final LC1081_Smallest_Subsequence_of_Distinct_Characters solution =
        new LC1081_Smallest_Subsequence_of_Distinct_Characters();

    @Test
    public void testExample1() {
        // Input: s = "bcabc", Output: "abc"
        // The distinct characters are 'a', 'b', 'c'.
        // "abc" is the lexicographically smallest subsequence containing all distinct chars.
        assertEquals("abc", solution.smallestSubsequence("bcabc"));
    }

    @Test
    public void testExample2() {
        // Input: s = "cbacdcbc", Output: "acdb"
        // The distinct characters are 'a', 'b', 'c', 'd'.
        // "acdb" is the lexicographically smallest subsequence containing all distinct chars.
        assertEquals("acdb", solution.smallestSubsequence("cbacdcbc"));
    }

    @Test
    public void testSingleCharacter() {
        // Input: s = "a", Output: "a"
        // Only one distinct character, so the result is the character itself.
        assertEquals("a", solution.smallestSubsequence("a"));
    }

    @Test
    public void testAllDistinct() {
        // Input: s = "abc", Output: "abc"
        // All characters are already distinct, so the result is the string itself.
        assertEquals("abc", solution.smallestSubsequence("abc"));
    }

    @Test
    public void testRepeatedSingleChar() {
        // Input: s = "aaaaa", Output: "a"
        // Only one distinct character 'a', result is just "a".
        assertEquals("a", solution.smallestSubsequence("aaaaa"));
    }
}