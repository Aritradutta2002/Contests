package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC3658_GCD_of_Odd_and_Even_Sums_Test {

    @Test
    // Example 1: n = 4 -> sumOdd = 16, sumEven = 20, GCD = 4
    public void testExample1() {
        LC3658_GCD_of_Odd_and_Even_Sums solution = new LC3658_GCD_of_Odd_and_Even_Sums();
        assertEquals(4, solution.gcdOfOddEvenSums(4));
    }

    @Test
    // Example 2: n = 5 -> sumOdd = 25, sumEven = 30, GCD = 5
    public void testExample2() {
        LC3658_GCD_of_Odd_and_Even_Sums solution = new LC3658_GCD_of_Odd_and_Even_Sums();
        assertEquals(5, solution.gcdOfOddEvenSums(5));
    }

    @Test
    // Edge case: n = 1 -> sumOdd = 1, sumEven = 2, GCD = 1
    public void testMinimumN() {
        LC3658_GCD_of_Odd_and_Even_Sums solution = new LC3658_GCD_of_Odd_and_Even_Sums();
        assertEquals(1, solution.gcdOfOddEvenSums(1));
    }
}
