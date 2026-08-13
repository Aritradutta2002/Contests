package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC1967_Number_of_Strings_That_Appear_as_Substrings_in_Word_Test {

    @Test
    public void testExample1() {
        // Validates that "a", "abc", and "bc" appear as substrings in "abc", while "d" does not
        LC1967_Number_of_Strings_That_Appear_as_Substrings_in_Word solver =
                new LC1967_Number_of_Strings_That_Appear_as_Substrings_in_Word();
        String[] patterns = {"a", "abc", "bc", "d"};
        assertEquals(3, solver.numOfStrings(patterns, "abc"));
    }

    @Test
    public void testExample2() {
        // Validates that "a" and "b" appear as substrings, but "c" does not
        LC1967_Number_of_Strings_That_Appear_as_Substrings_in_Word solver =
                new LC1967_Number_of_Strings_That_Appear_as_Substrings_in_Word();
        String[] patterns = {"a", "b", "c"};
        assertEquals(2, solver.numOfStrings(patterns, "aaaaabbbbb"));
    }

    @Test
    public void testExample3() {
        // Validates that duplicate patterns are each counted separately
        LC1967_Number_of_Strings_That_Appear_as_Substrings_in_Word solver =
                new LC1967_Number_of_Strings_That_Appear_as_Substrings_in_Word();
        String[] patterns = {"a", "a", "a"};
        assertEquals(3, solver.numOfStrings(patterns, "ab"));
    }
}
