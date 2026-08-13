package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class LC15_Three_Sum_Test {

    @Test
    public void testStandardCase() {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = LC15_Three_Sum.threeSum(nums);
        assertEquals(2, result.size());
    }

    @Test
    public void testNoTriplets() {
        int[] nums = {0, 1, 1};
        List<List<Integer>> result = LC15_Three_Sum.threeSum(nums);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testAllZeros() {
        int[] nums = {0, 0, 0};
        List<List<Integer>> result = LC15_Three_Sum.threeSum(nums);
        assertEquals(1, result.size());
    }
}
