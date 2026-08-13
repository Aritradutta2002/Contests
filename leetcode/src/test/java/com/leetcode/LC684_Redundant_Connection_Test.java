package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC684_Redundant_Connection_Test {

    @Test
    public void testFindRedundantConnectionExample1() {
        int[][] edges = {{1, 2}, {1, 3}, {2, 3}};
        int[] expected = {2, 3};
        LC684_Redundant_Connection solver = new LC684_Redundant_Connection();
        assertArrayEquals(expected, solver.findRedundantConnection(edges));
    }

    @Test
    public void testFindRedundantConnectionExample2() {
        int[][] edges = {{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
        int[] expected = {1, 4};
        LC684_Redundant_Connection solver = new LC684_Redundant_Connection();
        assertArrayEquals(expected, solver.findRedundantConnection(edges));
    }

    @Test
    public void testFindRedundantConnectionExample3() {
        int[][] edges = {{1, 2}, {2, 3}, {3, 1}};
        int[] expected = {3, 1};
        LC684_Redundant_Connection solver = new LC684_Redundant_Connection();
        assertArrayEquals(expected, solver.findRedundantConnection(edges));
    }
}
