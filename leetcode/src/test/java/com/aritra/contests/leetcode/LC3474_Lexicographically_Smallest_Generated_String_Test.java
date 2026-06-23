package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC3474_Lexicographically_Smallest_Generated_String_Test {

    @Test
    public void testExample1() {
        LC3474_Lexicographically_Smallest_Generated_String solver = new LC3474_Lexicographically_Smallest_Generated_String();
        assertEquals("ababa", solver.generateString("TFTF", "ab"));
    }

    @Test
    public void testExample2() {
        LC3474_Lexicographically_Smallest_Generated_String solver = new LC3474_Lexicographically_Smallest_Generated_String();
        assertEquals("b", solver.generateString("F", "a"));
    }

    @Test
    public void testExample3() {
        LC3474_Lexicographically_Smallest_Generated_String solver = new LC3474_Lexicographically_Smallest_Generated_String();
        assertEquals("a", solver.generateString("T", "a"));
    }
}
