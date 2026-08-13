package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class LC42_Trapping_Rain_Water_Test {

    @Test
    public void testStandardCase() {
        LC42_Trapping_Rain_Water solution = new LC42_Trapping_Rain_Water();
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        assertEquals(6, solution.trap(height));
    }

    @Test
    public void testAnotherCase() {
        LC42_Trapping_Rain_Water solution = new LC42_Trapping_Rain_Water();
        int[] height = {4, 2, 0, 3, 2, 5};
        assertEquals(9, solution.trap(height));
    }

    @Test
    public void testAdditionalCase() {
        LC42_Trapping_Rain_Water solution = new LC42_Trapping_Rain_Water();
        int[] height = {3, 0, 2, 0, 4};
        assertEquals(7, solution.trap(height));
    }
}
