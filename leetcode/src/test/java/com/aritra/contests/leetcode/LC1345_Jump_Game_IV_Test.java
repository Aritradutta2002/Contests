package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC1345_Jump_Game_IV_Test {

    @Test
    public void testStandardCase() {
        LC1345_Jump_Game_IV solver = new LC1345_Jump_Game_IV();
        int[] arr = {100,-23,-23,404,100,23,23,23,3,404};
        assertEquals(3, solver.minimumJumps(arr));
    }

    @Test
    public void testSingleElement() {
        LC1345_Jump_Game_IV solver = new LC1345_Jump_Game_IV();
        int[] arr = {7};
        assertEquals(0, solver.minimumJumps(arr));
    }

    @Test
    public void testSimpleCase() {
        LC1345_Jump_Game_IV solver = new LC1345_Jump_Game_IV();
        int[] arr = {7,6,9,6,9,6,9,7};
        assertEquals(1, solver.minimumJumps(arr));
    }
}
