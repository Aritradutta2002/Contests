package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC3016_Minimum_Number_of_Pushes_to_Type_Word_II_Test {

    private final LC3016_Minimum_Number_of_Pushes_to_Type_Word_II solver = new LC3016_Minimum_Number_of_Pushes_to_Type_Word_II();

    @Test
    public void testExample1() {
        // Example 1 from LeetCode
        // Input param 1: "abcde"
        assertEquals(5, solver.minimumPushes("abcde"));
    }

    @Test
    public void testExample2() {
        // Example 2 from LeetCode
        // Input param 1: "xyzxyzxyzxyz"
        assertEquals(12, solver.minimumPushes("xyzxyzxyzxyz"));
    }

    @Test
    public void testExample3() {
        // Example 3 from LeetCode
        // Input param 1: "aabbccddeeffgghhiiiiii"
        assertEquals(24, solver.minimumPushes("aabbccddeeffgghhiiiiii"));
    }

    @Test
    public void testSingleCharacter() {
        assertEquals(1, solver.minimumPushes("a"));
    }

    @Test
    public void testAllSameCharacter() {
        // 4 pushes for the same letter repeated 4 times
        assertEquals(4, solver.minimumPushes("aaaa"));
    }

    @Test
    public void testAllDistinctLetters() {
        // 26 distinct letters, each once: 8 keys at 1 push, 8 at 2, 8 at 3, 2 at 4
        assertEquals(56, solver.minimumPushes("abcdefghijklmnopqrstuvwxyz"));
    }

    @Test
    public void testAllLettersTwice() {
        // 26 distinct letters, each twice: 2 * 56 = 112
        assertEquals(112, solver.minimumPushes("aabbccddeeffgghhiijjkkllmmnnooppqqrrssttuuvvwwxxyyzz"));
    }

    @Test
    public void testMoreThanEightDistinctLetters() {
        // 9 distinct letters, each once: 8 at 1 push, 1 at 2 pushes
        assertEquals(10, solver.minimumPushes("abcdefghi"));
    }

    @Test
    public void testFrequencyDrivenAssignment() {
        // "aaabbcc" -> a appears 3 times, b and c twice each
        // a gets level 1 (3), b and c get level 1 (2+2) => 7
        assertEquals(7, solver.minimumPushes("aaabbcc"));
    }
}
