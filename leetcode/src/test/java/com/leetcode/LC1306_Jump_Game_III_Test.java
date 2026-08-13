package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC1306_Jump_Game_III_Test {

    @Test
    public void testCanReachZero() {
        LC1306_Jump_Game_III solver = new LC1306_Jump_Game_III();
        int[] arr = {4,2,3,0,3,1,2};
        assertTrue(solver.canReach(arr, 5));
    }

    @Test
    public void testCannotReachZero() {
        LC1306_Jump_Game_III solver = new LC1306_Jump_Game_III();
        int[] arr = {3,0,2,1,2};
        assertFalse(solver.canReach(arr, 2));
    }

    @Test
    public void testStartAtZero() {
        LC1306_Jump_Game_III solver = new LC1306_Jump_Game_III();
        int[] arr = {0,1};
        assertTrue(solver.canReach(arr, 0));
    }
}
