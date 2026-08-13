package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC2540_Minimum_Common_Value_Test {

    @Test
    public void testStandardCase() {
        LC2540_Minimum_Common_Value solver = new LC2540_Minimum_Common_Value();
        int[] nums1 = {1,2,3};
        int[] nums2 = {2,4};
        assertEquals(2, solver.getCommon(nums1, nums2));
    }

    @Test
    public void testNoCommon() {
        LC2540_Minimum_Common_Value solver = new LC2540_Minimum_Common_Value();
        int[] nums1 = {1,3,5};
        int[] nums2 = {2,4,6};
        assertEquals(-1, solver.getCommon(nums1, nums2));
    }
}
