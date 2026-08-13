package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC3661_Maximum_Walls_Destroyed_By_Robots_Test {

    @Test
    public void testExample1() {
        LC3661_Maximum_Walls_Destroyed_By_Robots solver = new LC3661_Maximum_Walls_Destroyed_By_Robots();
        int[] robots = {1, 5, 10};
        int[] distance = {3, 3, 3};
        int[] walls = {2, 4, 7, 9, 11};
        assertEquals(4, solver.maxWalls(robots, distance, walls));
    }

    @Test
    public void testExample2() {
        LC3661_Maximum_Walls_Destroyed_By_Robots solver = new LC3661_Maximum_Walls_Destroyed_By_Robots();
        int[] robots = {2, 5};
        int[] distance = {1, 1};
        int[] walls = {3, 4};
        assertEquals(2, solver.maxWalls(robots, distance, walls));
    }
}
