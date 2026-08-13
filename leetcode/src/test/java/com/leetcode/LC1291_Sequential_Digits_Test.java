package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class LC1291_Sequential_Digits_Test {

    @Test
    // Validates the first LeetCode example: low = 100, high = 300
    public void testExample1() {
        LC1291_Sequential_Digits solution = new LC1291_Sequential_Digits();
        List<Integer> expected = Arrays.asList(123, 234);
        assertEquals(expected, solution.sequentialDigits(100, 300));
    }

    @Test
    // Validates the second LeetCode example: low = 1000, high = 13000
    public void testExample2() {
        LC1291_Sequential_Digits solution = new LC1291_Sequential_Digits();
        List<Integer> expected = Arrays.asList(1234, 2345, 3456, 4567, 5678, 6789, 12345);
        assertEquals(expected, solution.sequentialDigits(1000, 13000));
    }

    @Test
    // Validates a narrow range that contains a single sequential number
    public void testSingleSequentialNumber() {
        LC1291_Sequential_Digits solution = new LC1291_Sequential_Digits();
        List<Integer> expected = Arrays.asList(6789);
        assertEquals(expected, solution.sequentialDigits(6000, 7000));
    }
}
