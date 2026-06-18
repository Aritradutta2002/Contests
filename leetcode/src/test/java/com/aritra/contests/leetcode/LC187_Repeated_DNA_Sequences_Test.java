package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class LC187_Repeated_DNA_Sequences_Test {

    @Test
    public void testStandardCase() {
        List<String> expected = Arrays.asList("AAAAACCCCC","CCCCCAAAAA");
        assertEquals(expected, LC187_Repeated_DNA_Sequences.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }

    @Test
    public void testNoRepeats() {
        List<String> result = LC187_Repeated_DNA_Sequences.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        assertFalse(result.isEmpty());
    }
}
