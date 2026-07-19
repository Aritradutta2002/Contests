package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC1979_Find_Greatest_Common_Divisor_Of_Array_Test {

    private final LC1979_Find_Greatest_Common_Divisor_Of_Array solution = new LC1979_Find_Greatest_Common_Divisor_Of_Array();

    @Test
    void testExample1_StandardCase() {
        // nums = [2,5,6,9,10] -> min=2, max=10, GCD=2
        int[] nums = {2, 5, 6, 9, 10};
        assertEquals(2, solution.findGCD(nums));
    }

    @Test
    void testExample2_CoprimeNumbers() {
        // nums = [7,5,6,8,3] -> min=3, max=8, GCD=1
        int[] nums = {7, 5, 6, 8, 3};
        assertEquals(1, solution.findGCD(nums));
    }

    @Test
    void testExample3_SameElements() {
        // nums = [3,3] -> min=3, max=3, GCD=3
        int[] nums = {3, 3};
        assertEquals(3, solution.findGCD(nums));
    }
}