package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

public class LC438_Find_All_Anagrams_In_A_String_B_Test {

    @Test
    public void testFindAnagramsExample1() {
        LC438_Find_All_Anagrams_In_A_String_B solver = new LC438_Find_All_Anagrams_In_A_String_B();
        assertEquals(Arrays.asList(0, 6), solver.findAnagrams("cbaebabacd", "abc"));
    }

    @Test
    public void testFindAnagramsExample2() {
        LC438_Find_All_Anagrams_In_A_String_B solver = new LC438_Find_All_Anagrams_In_A_String_B();
        assertEquals(Arrays.asList(0, 1, 2), solver.findAnagrams("abab", "ab"));
    }

    @Test
    public void testFindAnagramsNoMatch() {
        LC438_Find_All_Anagrams_In_A_String_B solver = new LC438_Find_All_Anagrams_In_A_String_B();
        assertTrue(solver.findAnagrams("af", "be").isEmpty());
    }

    @Test
    public void testFindAnagramsPShorter() {
        LC438_Find_All_Anagrams_In_A_String_B solver = new LC438_Find_All_Anagrams_In_A_String_B();
        assertTrue(solver.findAnagrams("a", "ab").isEmpty());
    }
}
