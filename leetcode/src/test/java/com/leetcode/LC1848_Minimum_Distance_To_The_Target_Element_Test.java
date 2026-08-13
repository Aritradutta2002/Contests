package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC1848_Minimum_Distance_To_The_Target_Element_Test {

    @Test
    public void testStandardCase() {
        LC1848_Minimum_Distance_To_The_Target_Element solver = new LC1848_Minimum_Distance_To_The_Target_Element();
        int[] nums = {1,2,3,4,5};
        assertEquals(1, solver.getMinDistance(nums, 5, 3));
    }

    @Test
    public void testSameIndex() {
        LC1848_Minimum_Distance_To_The_Target_Element solver = new LC1848_Minimum_Distance_To_The_Target_Element();
        int[] nums = {1};
        assertEquals(0, solver.getMinDistance(nums, 1, 0));
    }
}
