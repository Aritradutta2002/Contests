package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC3488_Closest_Equal_Element_Queries_Test {

    @Test
    public void testExample1() {
        LC3488_Closest_Equal_Element_Queries solver = new LC3488_Closest_Equal_Element_Queries();
        int[] nums = {1, 2, 3, 2, 1};
        int[] queries = {0, 1, 2, 3, 4};
        int[] expected = {1, 2, -1, 2, 1};
        assertArrayEquals(expected, solver.closestEqual(nums, queries));
    }

    @Test
    public void testExample2() {
        LC3488_Closest_Equal_Element_Queries solver = new LC3488_Closest_Equal_Element_Queries();
        int[] nums = {1, 1, 1, 1};
        int[] queries = {0, 1, 2, 3};
        int[] expected = {1, 1, 1, 1};
        assertArrayEquals(expected, solver.closestEqual(nums, queries));
    }
}
