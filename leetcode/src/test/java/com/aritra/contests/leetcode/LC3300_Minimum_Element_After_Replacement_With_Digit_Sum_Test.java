package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC3300_Minimum_Element_After_Replacement_With_Digit_Sum_Test {

    @Test
    public void testStandardCase() {
        LC3300_Minimum_Element_After_Replacement_With_Digit_Sum solver = new LC3300_Minimum_Element_After_Replacement_With_Digit_Sum();
        int[] nums = {10,12,13,14};
        assertEquals(1, solver.minElement(nums));
    }

    @Test
    public void testAllSame() {
        LC3300_Minimum_Element_After_Replacement_With_Digit_Sum solver = new LC3300_Minimum_Element_After_Replacement_With_Digit_Sum();
        int[] nums = {1,1,1};
        assertEquals(1, solver.minElement(nums));
    }
}
