package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC4242_Sum_of_GCD_of_Formed_Pairs_Test {

    @Test
    // Example 1: nums = [2,6,4] -> prefixGcd = [2,6,2], sorted = [2,2,6],
    // pair gcd(2,6)=2, middle 2 ignored, sum = 2
    public void testExample1() {
        LC4242_Sum_of_GCD_of_Formed_Pairs solution = new LC4242_Sum_of_GCD_of_Formed_Pairs();
        assertEquals(2L, solution.gcdSum(new int[]{2, 6, 4}));
    }

    @Test
    // Example 2: nums = [3,6,2,8] -> prefixGcd = [3,6,2,8], sorted = [2,3,6,8],
    // pairs: gcd(2,8)=2, gcd(3,6)=3, sum = 5
    public void testExample2() {
        LC4242_Sum_of_GCD_of_Formed_Pairs solution = new LC4242_Sum_of_GCD_of_Formed_Pairs();
        assertEquals(5L, solution.gcdSum(new int[]{3, 6, 2, 8}));
    }

    @Test
    // Edge case: single element n=1 -> prefixGcd = [nums[0]], odd length,
    // middle element ignored, no pairs formed, sum = 0
    public void testSingleElement() {
        LC4242_Sum_of_GCD_of_Formed_Pairs solution = new LC4242_Sum_of_GCD_of_Formed_Pairs();
        assertEquals(0L, solution.gcdSum(new int[]{7}));
    }
}