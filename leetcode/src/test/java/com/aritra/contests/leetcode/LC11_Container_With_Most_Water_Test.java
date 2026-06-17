package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC11_Container_With_Most_Water_Test {

    @Test
    public void testStandardCase() {
        LC11_Container_With_Most_Water solution = new LC11_Container_With_Most_Water();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        assertEquals(49, solution.maxArea(height));
    }

    @Test
    public void testTwoElements() {
        LC11_Container_With_Most_Water solution = new LC11_Container_With_Most_Water();
        int[] height = {1, 1};
        assertEquals(1, solution.maxArea(height));
    }

    @Test
    public void testSymmetrical() {
        LC11_Container_With_Most_Water solution = new LC11_Container_With_Most_Water();
        int[] height = {4, 3, 2, 1, 4};
        assertEquals(16, solution.maxArea(height));
    }
}
