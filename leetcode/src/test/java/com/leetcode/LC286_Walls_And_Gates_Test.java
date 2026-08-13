package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC286_Walls_And_Gates_Test {

    @Test
    public void testWallsAndGatesExample1() {
        LC286_Walls_And_Gates solver = new LC286_Walls_And_Gates();
        int INF = Integer.MAX_VALUE;
        int[][] rooms = {
            {INF, -1, 0, INF},
            {INF, INF, INF, -1},
            {INF, -1, INF, -1},
            {0, -1, INF, INF}
        };
        int[][] expected = {
            {3, -1, 0, 1},
            {2, 2, 1, -1},
            {1, -1, 2, -1},
            {0, -1, 3, 4}
        };
        solver.wallsAndGates(rooms);
        assertArrayEquals(expected, rooms);
    }

    @Test
    public void testWallsAndGatesSingleWall() {
        LC286_Walls_And_Gates solver = new LC286_Walls_And_Gates();
        int[][] rooms = {{-1}};
        int[][] expected = {{-1}};
        solver.wallsAndGates(rooms);
        assertArrayEquals(expected, rooms);
    }

    @Test
    public void testWallsAndGatesSingleGate() {
        LC286_Walls_And_Gates solver = new LC286_Walls_And_Gates();
        int[][] rooms = {{0}};
        int[][] expected = {{0}};
        solver.wallsAndGates(rooms);
        assertArrayEquals(expected, rooms);
    }
}
