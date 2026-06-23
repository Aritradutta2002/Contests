package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class LC438_Find_All_Anagrams_In_A_String_A_Test {

    @Test
    public void testStandardCase() {
        LC438_Find_All_Anagrams_In_A_String_A solver = new LC438_Find_All_Anagrams_In_A_String_A();
        List<Integer> result = solver.findAnagrams("cbaebabacd", "abc");
        assertEquals(Arrays.asList(0,6), result);
    }

    @Test
    public void testNoAnagrams() {
        LC438_Find_All_Anagrams_In_A_String_A solver = new LC438_Find_All_Anagrams_In_A_String_A();
        List<Integer> result = solver.findAnagrams("af", "be");
        assertTrue(result.isEmpty());
    }
}
