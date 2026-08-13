package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC3014_Minimum_Number_of_Pushes_to_Type_Word_I_Test {

    private final LC3014_Minimum_Number_of_Pushes_to_Type_Word_I solver = new LC3014_Minimum_Number_of_Pushes_to_Type_Word_I();

    @Test
    public void testExample1() {
        // Example 1 from LeetCode
        // Input param 1: "abcde"
        assertEquals(5, solver.minimumPushes("abcde"));
    }

    @Test
    public void testExample2() {
        // Example 2 from LeetCode
        // Input param 1: "xycdefghij"
        assertEquals(12, solver.minimumPushes("xycdefghij"));
    }

    @Test
    public void testSingleCharacter() {
        assertEquals(1, solver.minimumPushes("a"));
    }

    @Test
    public void testExactlyEightDistinctLetters() {
        // 8 letters, one per key at 1 push
        assertEquals(8, solver.minimumPushes("abcdefgh"));
    }

    @Test
    public void testNineDistinctLetters() {
        // 8 letters at 1 push, 1 letter at 2 pushes
        assertEquals(10, solver.minimumPushes("abcdefghi"));
    }

    @Test
    public void testSixteenDistinctLetters() {
        // 8 at 1 push, 8 at 2 pushes
        assertEquals(24, solver.minimumPushes("abcdefghijklmnop"));
    }

    @Test
    public void testAllDistinctLetters() {
        // 26 distinct letters: 8 at 1 push, 8 at 2, 8 at 3, 2 at 4
        assertEquals(56, solver.minimumPushes("abcdefghijklmnopqrstuvwxyz"));
    }
}
