package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC3741_Minimum_Distance_Between_Three_Equal_Elements_II_Test {

    @Test
    public void testExample1() {
        LC3741_Minimum_Distance_Between_Three_Equal_Elements_II solver = new LC3741_Minimum_Distance_Between_Three_Equal_Elements_II();
        int[] nums = {1, 2, 1, 2, 1};
        assertEquals(8, solver.minimumDistance(nums));
    }

    @Test
    public void testExample2() {
        LC3741_Minimum_Distance_Between_Three_Equal_Elements_II solver = new LC3741_Minimum_Distance_Between_Three_Equal_Elements_II();
        int[] nums = {1, 2, 3};
        assertEquals(-1, solver.minimumDistance(nums));
    }

    @Test
    public void testLargeArray() {
        LC3741_Minimum_Distance_Between_Three_Equal_Elements_II solver = new LC3741_Minimum_Distance_Between_Three_Equal_Elements_II();
        int[] nums = {1, 1, 1, 1};
        assertEquals(4, solver.minimumDistance(nums));
    }
}
