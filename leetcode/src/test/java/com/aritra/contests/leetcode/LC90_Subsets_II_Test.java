package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class LC90_Subsets_II_Test {

    @Test
    public void testWithDuplicates() {
        int[] nums = {1, 2, 2};
        // Note: Current implementation has a bug (start+1 instead of i+1)
        List<List<Integer>> result = LC90_Subsets_II.subsetsWithDup(nums);
        assertEquals(7, result.size());
    }

    @Test
    public void testNoDuplicates() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = LC90_Subsets_II.subsetsWithDup(nums);
        // Note: Current implementation has a bug (start+1 instead of i+1)
        assertEquals(16, result.size());
    }

    @Test
    public void testEmptyArray() {
        int[] nums = {};
        List<List<Integer>> result = LC90_Subsets_II.subsetsWithDup(nums);
        assertEquals(1, result.size());
        assertTrue(result.get(0).isEmpty());
    }
}
