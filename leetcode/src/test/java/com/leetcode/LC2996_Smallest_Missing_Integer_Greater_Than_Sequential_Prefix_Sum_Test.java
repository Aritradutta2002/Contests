package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC2996_Smallest_Missing_Integer_Greater_Than_Sequential_Prefix_Sum_Test {

    private final LC2996_Smallest_Missing_Integer_Greater_Than_Sequential_Prefix_Sum solver =
            new LC2996_Smallest_Missing_Integer_Greater_Than_Sequential_Prefix_Sum();

    @Test
    public void testExample1() {
        int[] nums = {1, 2, 3, 2, 5};
        assertEquals(6, solver.missingInteger(nums));
    }

    @Test
    public void testExample2() {
        int[] nums = {3, 4, 5, 1, 12, 14, 13};
        assertEquals(15, solver.missingInteger(nums));
    }

    @Test
    public void testSingleElement() {
        int[] nums = {5};
        assertEquals(6, solver.missingInteger(nums));
    }

    @Test
    public void testSumAlreadyPresent() {
        int[] nums = {1, 2, 3, 4, 10, 15};
        assertEquals(11, solver.missingInteger(nums));
    }

    @Test
    public void testNoSequentialPrefix() {
        int[] nums = {10, 5, 20};
        assertEquals(11, solver.missingInteger(nums));
    }

    @Test
    public void testAllElementsSequential() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertEquals(55, solver.missingInteger(nums));
    }
}
