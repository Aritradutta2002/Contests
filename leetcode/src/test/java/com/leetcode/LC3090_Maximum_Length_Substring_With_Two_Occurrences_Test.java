package com.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class LC3090_Maximum_Length_Substring_With_Two_Occurrences_Test {

    private final LC3090_Maximum_Length_Substring_With_Two_Occurrences solver = new LC3090_Maximum_Length_Substring_With_Two_Occurrences();

    @Test
    public void testExample1() {
        String param1 = "bcbbbcba";
        int expected = 4;
        int actual = solver.maximumLengthSubstring(param1);
        assertEquals(expected, actual);
    }

    @Test
    public void testExample2() {
        String param1 = "aaaa";
        int expected = 2;
        int actual = solver.maximumLengthSubstring(param1);
        assertEquals(expected, actual);
    }
}