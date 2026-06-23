package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC2566_Maximum_Difference_By_Remapping_A_Digit_Test {

    @Test
    public void testStandardCase() {
        assertEquals(999, LC2566_Maximum_Difference_By_Remapping_A_Digit.minMaxDifference(555));
    }

    @Test
    public void testSimpleCase() {
        assertEquals(9, LC2566_Maximum_Difference_By_Remapping_A_Digit.minMaxDifference(9));
    }
}
