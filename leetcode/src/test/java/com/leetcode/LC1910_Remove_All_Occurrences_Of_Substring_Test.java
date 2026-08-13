package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC1910_Remove_All_Occurrences_Of_Substring_Test {

    @Test
    public void testStandardCase() {
        assertEquals("dab", LC1910_Remove_All_Occurrences_Of_Substring.removeOccurrences("daabcbaabcbc", "abc"));
    }

    @Test
    public void testNoOccurrence() {
        assertEquals("hello", LC1910_Remove_All_Occurrences_Of_Substring.removeOccurrences("hello", "xyz"));
    }

    @Test
    public void testNestedRemoval() {
        assertEquals("b", LC1910_Remove_All_Occurrences_Of_Substring.removeOccurrences("aababab", "aba"));
    }
}
