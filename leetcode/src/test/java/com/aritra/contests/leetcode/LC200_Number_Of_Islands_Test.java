package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC200_Number_Of_Islands_Test {

    private final LC200_Number_Of_Islands solver = new LC200_Number_Of_Islands();

    private char[][] deepCopy(char[][] original) {
        char[][] copy = new char[original.length][];
        for (int i = 0; i < original.length; i++) {
            copy[i] = original[i].clone();
        }
        return copy;
    }

    @Test
    public void testOneIsland() {
        char[][] grid = {
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
        };
        assertEquals(1, solver.numIslands(deepCopy(grid)));
    }

    @Test
    public void testThreeIslands() {
        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };
        assertEquals(3, solver.numIslands(deepCopy(grid)));
    }

    @Test
    public void testOnlyWater() {
        char[][] grid = {{'0'}};
        assertEquals(0, solver.numIslands(deepCopy(grid)));
    }
}
