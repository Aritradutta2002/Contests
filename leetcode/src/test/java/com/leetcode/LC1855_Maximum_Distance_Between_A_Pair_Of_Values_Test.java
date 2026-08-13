package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC1855_Maximum_Distance_Between_A_Pair_Of_Values_Test {

    @Test
    public void testStandardCase() {
        LC1855_Maximum_Distance_Between_A_Pair_Of_Values solver = new LC1855_Maximum_Distance_Between_A_Pair_Of_Values();
        int[] nums1 = {55,30,5,4,2};
        int[] nums2 = {100,20,10,10,5};
        assertEquals(2, solver.maxDistance(nums1, nums2));
    }

    @Test
    public void testNoValidPair() {
        LC1855_Maximum_Distance_Between_A_Pair_Of_Values solver = new LC1855_Maximum_Distance_Between_A_Pair_Of_Values();
        int[] nums1 = {2,2,2};
        int[] nums2 = {1,1,1};
        assertEquals(0, solver.maxDistance(nums1, nums2));
    }
}
