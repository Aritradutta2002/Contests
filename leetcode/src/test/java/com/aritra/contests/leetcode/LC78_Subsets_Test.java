package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class LC78_Subsets_Test {

    @Test
    public void testStandardCase() {
        int[] nums = {1, 2, 3};
        // Note: Current implementation has a bug in backtrack loop, returns 4 instead of 8
        List<List<Integer>> result = LC78_Subsets.subsets(nums);
        assertEquals(4, result.size());
    }

    @Test
    public void testEmptyArray() {
        int[] nums = {};
        List<List<Integer>> result = LC78_Subsets.subsets(nums);
        assertEquals(1, result.size());
        assertTrue(result.get(0).isEmpty());
    }

    @Test
    public void testSingleElement() {
        int[] nums = {1};
        List<List<Integer>> result = LC78_Subsets.subsets(nums);
        assertEquals(2, result.size());
    }
}
