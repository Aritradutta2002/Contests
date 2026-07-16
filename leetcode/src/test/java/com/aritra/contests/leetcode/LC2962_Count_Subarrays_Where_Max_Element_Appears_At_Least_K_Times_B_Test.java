package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC2962_Count_Subarrays_Where_Max_Element_Appears_At_Least_K_Times_B_Test {

    @Test
    public void testCountSubarraysExample1() {
        int[] nums = {1, 3, 2, 3, 3};
        assertEquals(6, LC2962_Count_Subarrays_Where_Max_Element_Appears_At_Least_K_Times_B.countSubarrays(nums, 3, 2));
    }

    @Test
    public void testCountSubarraysExample2() {
        int[] nums = {1, 4, 2, 1};
        assertEquals(0, LC2962_Count_Subarrays_Where_Max_Element_Appears_At_Least_K_Times_B.countSubarrays(nums, 4, 3));
    }
}
