package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC1578_Minimum_Time_To_Make_Rope_Colorful_Test {

    @Test
    public void testMinCostExample1() {
        String colors = "abaac";
        int[] neededTime = {1, 2, 3, 4, 5};
        assertEquals(3, LC1578_Minimum_Time_To_Make_Rope_Colorful.Solution.minCost(colors, neededTime));
    }

    @Test
    public void testMinCostExample2() {
        String colors = "abc";
        int[] neededTime = {1, 2, 3};
        assertEquals(0, LC1578_Minimum_Time_To_Make_Rope_Colorful.Solution.minCost(colors, neededTime));
    }

    @Test
    public void testMinCostExample3() {
        String colors = "aabaa";
        int[] neededTime = {1, 2, 3, 4, 1};
        assertEquals(2, LC1578_Minimum_Time_To_Make_Rope_Colorful.Solution.minCost(colors, neededTime));
    }

    @Test
    public void testMinCostAllSame() {
        String colors = "aaaa";
        int[] neededTime = {5, 3, 7, 2};
        assertEquals(10, LC1578_Minimum_Time_To_Make_Rope_Colorful.Solution.minCost(colors, neededTime));
    }
}
