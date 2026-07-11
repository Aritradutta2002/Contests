package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LC2685_Count_The_Number_Of_Complete_Components_Test {

    private final LC2685_Count_The_Number_Of_Complete_Components solver =
            new LC2685_Count_The_Number_Of_Complete_Components();

    @Test
    public void testMixedComponents() {
        int n = 6;
        int[][] edges = {
                {0, 1}, {0, 2}, {1, 2},
                {3, 4}
        };

        assertEquals(3, solver.countCompleteComponents(n, edges));
    }

    @Test
    public void testOneIncompleteComponent() {
        int n = 6;
        int[][] edges = {
                {0, 1}, {0, 2}, {1, 2},
                {3, 4}, {3, 5}
        };

        assertEquals(1, solver.countCompleteComponents(n, edges));
    }

    @Test
    public void testAllIsolatedNodes() {
        int n = 4;
        int[][] edges = {};

        assertEquals(4, solver.countCompleteComponents(n, edges));
    }

    @Test
    public void testSingleCompleteComponent() {
        int n = 5;
        int[][] edges = {
                {0, 1}, {0, 2}, {0, 3}, {0, 4},
                {1, 2}, {1, 3}, {1, 4},
                {2, 3}, {2, 4},
                {3, 4}
        };

        assertEquals(1, solver.countCompleteComponents(n, edges));
    }
}