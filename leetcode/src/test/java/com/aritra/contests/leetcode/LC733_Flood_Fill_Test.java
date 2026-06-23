package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC733_Flood_Fill_Test {

    private final LC733_Flood_Fill solver = new LC733_Flood_Fill();

    private int[][] deepCopy(int[][] original) {
        int[][] copy = new int[original.length][];
        for (int i = 0; i < original.length; i++) {
            copy[i] = original[i].clone();
        }
        return copy;
    }

    @Test
    public void testStandardCase() {
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int[][] expected = {{2, 2, 2}, {2, 2, 0}, {2, 0, 1}};
        assertArrayEquals(expected, solver.floodFill(deepCopy(image), 1, 1, 2));
    }

    @Test
    public void testSameColor() {
        int[][] image = {{0, 0, 0}, {0, 0, 0}};
        int[][] expected = {{0, 0, 0}, {0, 0, 0}};
        assertArrayEquals(expected, solver.floodFill(deepCopy(image), 0, 0, 0));
    }

    @Test
    public void testAlreadyTargetColor() {
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int[][] expected = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        assertArrayEquals(expected, solver.floodFill(deepCopy(image), 1, 1, 1));
    }
}
