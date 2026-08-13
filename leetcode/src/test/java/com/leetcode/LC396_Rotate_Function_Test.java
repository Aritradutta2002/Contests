package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC396_Rotate_Function_Test {

    @Test
    public void testStandardCase() {
        LC396_Rotate_Function solver = new LC396_Rotate_Function();
        int[] nums = {4,3,2,6};
        assertEquals(26, solver.maxRotateFunction(nums));
    }

    @Test
    public void testSingleElement() {
        LC396_Rotate_Function solver = new LC396_Rotate_Function();
        int[] nums = {100};
        assertEquals(0, solver.maxRotateFunction(nums));
    }
}
