package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class LC417_Pacific_Atlantic_Water_Flow_Test {

    @Test
    public void testPacificAtlanticExample1() {
        int[][] heights = {
            {1, 2, 2, 3, 5},
            {3, 2, 3, 4, 4},
            {2, 4, 5, 3, 1},
            {6, 7, 1, 4, 5},
            {5, 1, 1, 2, 4}
        };
        List<List<Integer>> expected = Arrays.asList(
            Arrays.asList(0, 4), Arrays.asList(1, 3), Arrays.asList(1, 4),
            Arrays.asList(2, 2), Arrays.asList(3, 0), Arrays.asList(3, 1),
            Arrays.asList(4, 0)
        );
        LC417_Pacific_Atlantic_Water_Flow solver = new LC417_Pacific_Atlantic_Water_Flow();
        List<List<Integer>> actual = solver.pacificAtlantic(heights);
        assertEquals(expected.size(), actual.size());
        assertTrue(actual.containsAll(expected));
    }

    @Test
    public void testPacificAtlanticSingleCell() {
        int[][] heights = {{1}};
        List<List<Integer>> expected = Arrays.asList(Arrays.asList(0, 0));
        LC417_Pacific_Atlantic_Water_Flow solver = new LC417_Pacific_Atlantic_Water_Flow();
        assertEquals(expected, solver.pacificAtlantic(heights));
    }

    @Test
    public void testPacificAtlanticAllEqual() {
        int[][] heights = {{1, 1}, {1, 1}};
        List<List<Integer>> expected = Arrays.asList(
            Arrays.asList(0, 0), Arrays.asList(0, 1),
            Arrays.asList(1, 0), Arrays.asList(1, 1)
        );
        LC417_Pacific_Atlantic_Water_Flow solver = new LC417_Pacific_Atlantic_Water_Flow();
        List<List<Integer>> actual = solver.pacificAtlantic(heights);
        assertEquals(expected.size(), actual.size());
        assertTrue(actual.containsAll(expected));
    }
}
