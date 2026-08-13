package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC210_Course_Schedule_II_Test {

    @Test
    public void testFindOrderExample1() {
        LC210_Course_Schedule_II solver = new LC210_Course_Schedule_II();
        int[][] prerequisites = {{1, 0}};
        int[] result = solver.findOrder(2, prerequisites);
        assertArrayEquals(new int[]{0, 1}, result);
    }

    @Test
    public void testFindOrderExample3() {
        LC210_Course_Schedule_II solver = new LC210_Course_Schedule_II();
        int[][] prerequisites = {};
        int[] result = solver.findOrder(1, prerequisites);
        assertArrayEquals(new int[]{0}, result);
    }

    @Test
    public void testFindOrderImpossible() {
        LC210_Course_Schedule_II solver = new LC210_Course_Schedule_II();
        int[][] prerequisites = {{1, 0}, {0, 1}};
        int[] result = solver.findOrder(2, prerequisites);
        assertArrayEquals(new int[]{}, result);
    }
}
