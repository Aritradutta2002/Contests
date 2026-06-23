package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC057_Insert_Interval_Test {

    @Test
    public void testInsertStandard() {
        LC057_Insert_Interval solver = new LC057_Insert_Interval();
        int[][] intervals = {{1,3},{6,9}};
        int[] newInterval = {2,5};
        int[][] expected = {{1,5},{6,9}};
        assertThrows(UnsupportedOperationException.class, () -> solver.insert(intervals, newInterval));
    }

    @Test
    public void testInsertEmptyIntervals() {
        LC057_Insert_Interval solver = new LC057_Insert_Interval();
        int[][] intervals = {};
        int[] newInterval = {5,7};
        assertThrows(UnsupportedOperationException.class, () -> solver.insert(intervals, newInterval));
    }
}
