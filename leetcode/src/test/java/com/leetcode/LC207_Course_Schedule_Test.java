package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC207_Course_Schedule_Test {

    private final LC207_Course_Schedule solver = new LC207_Course_Schedule();

    @Test
    public void testPossible() {
        assertTrue(solver.canFinish(2, new int[][]{{1, 0}}));
    }

    @Test
    public void testImpossible() {
        assertFalse(solver.canFinish(2, new int[][]{{1, 0}, {0, 1}}));
    }

    @Test
    public void testMultiplePrereqs() {
        assertTrue(solver.canFinish(5, new int[][]{{1, 4}, {2, 4}, {3, 1}, {3, 2}}));
    }
}
