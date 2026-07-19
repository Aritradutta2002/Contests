package com.aritra.contests.leetcode;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

public class LC3312_Sorted_GCD_Pair_Queries_Test {

    private final LC3312_Sorted_GCD_Pair_Queries solution = new LC3312_Sorted_GCD_Pair_Queries();

    @Test
    void testExample1_basicGcdPairs() {
        // nums = [2,3,4], queries = [0,2,2]
        // gcdPairs = [gcd(2,3), gcd(2,4), gcd(3,4)] = [1, 2, 1] -> sorted = [1, 1, 2]
        // answer = [gcdPairs[0], gcdPairs[2], gcdPairs[2]] = [1, 2, 2]
        int[] nums = {2, 3, 4};
        long[] queries = {0, 2, 2};
        int[] expected = {1, 2, 2};
        assertArrayEquals(expected, solution.gcdValues(nums, queries));
    }

    @Test
    void testExample2_multipleGcdPairs() {
        // nums = [4,4,2,1], queries = [5,3,1,0]
        // gcdPairs sorted = [1, 1, 1, 2, 2, 4]
        // answer = [gcdPairs[5], gcdPairs[3], gcdPairs[1], gcdPairs[0]] = [4, 2, 1, 1]
        int[] nums = {4, 4, 2, 1};
        long[] queries = {5, 3, 1, 0};
        int[] expected = {4, 2, 1, 1};
        assertArrayEquals(expected, solution.gcdValues(nums, queries));
    }

    @Test
    void testExample3_singlePair() {
        // nums = [2,2], queries = [0,0]
        // gcdPairs = [2]
        // answer = [2, 2]
        int[] nums = {2, 2};
        long[] queries = {0, 0};
        int[] expected = {2, 2};
        assertArrayEquals(expected, solution.gcdValues(nums, queries));
    }
}