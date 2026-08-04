package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC486_Predict_the_Winner_Test {

    private final LC486_Predict_the_Winner solver = new LC486_Predict_the_Winner();

    @Test
    public void testExample1() {
        int[] nums = {1, 5, 2};
        assertFalse(solver.predictTheWinner(nums));
    }

    @Test
    public void testExample2() {
        int[] nums = {1, 5, 233, 7};
        assertTrue(solver.predictTheWinner(nums));
    }
}