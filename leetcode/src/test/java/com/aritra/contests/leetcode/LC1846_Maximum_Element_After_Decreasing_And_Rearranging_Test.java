package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC1846_Maximum_Element_After_Decreasing_And_Rearranging_Test {

    // Validates Example 1: mixed small values with possible decrements.
    @Test
    public void testExampleOne() {
        LC1846_Maximum_Element_After_Decreasing_And_Rearranging solver =
                new LC1846_Maximum_Element_After_Decreasing_And_Rearranging();
        int[] arr = {2, 2, 1, 2, 1};
        assertEquals(2, solver.maximumElementAfterDecrementingAndRearranging(arr));
    }

    // Validates Example 2: large values surrounding a small 1 force tight cap.
    @Test
    public void testExampleTwo() {
        LC1846_Maximum_Element_After_Decreasing_And_Rearranging solver =
                new LC1846_Maximum_Element_After_Decreasing_And_Rearranging();
        int[] arr = {100, 1, 1000};
        assertEquals(3, solver.maximumElementAfterDecrementingAndRearranging(arr));
    }

    // Validates Example 3: already strictly-increasing 1..n yields n as answer.
    @Test
    public void testExampleThree() {
        LC1846_Maximum_Element_After_Decreasing_And_Rearranging solver =
                new LC1846_Maximum_Element_After_Decreasing_And_Rearranging();
        int[] arr = {1, 2, 3, 4, 5};
        assertEquals(5, solver.maximumElementAfterDecrementingAndRearranging(arr));
    }

    // Validates single-element array always yields 1.
    @Test
    public void testSingleElement() {
        LC1846_Maximum_Element_After_Decreasing_And_Rearranging solver =
                new LC1846_Maximum_Element_After_Decreasing_And_Rearranging();
        int[] arr = {7};
        assertEquals(1, solver.maximumElementAfterDecrementingAndRearranging(arr));
    }

    // Validates all-ones array yields 1 (cannot increase values, only decrease).
    @Test
    public void testAllOnes() {
        LC1846_Maximum_Element_After_Decreasing_And_Rearranging solver =
                new LC1846_Maximum_Element_After_Decreasing_And_Rearranging();
        int[] arr = {1, 1, 1, 1, 1};
        assertEquals(1, solver.maximumElementAfterDecrementingAndRearranging(arr));
    }
}