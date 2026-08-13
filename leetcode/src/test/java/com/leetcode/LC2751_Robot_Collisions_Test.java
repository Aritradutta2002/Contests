package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class LC2751_Robot_Collisions_Test {

    @Test
    public void testSurvivedRobotsHealthsExample1() {
        LC2751_Robot_Collisions solver = new LC2751_Robot_Collisions();
        int[] positions = {5, 4, 3, 2, 1};
        int[] healths = {2, 17, 9, 15, 10};
        String directions = "RRRRR";
        List<Integer> result = solver.survivedRobotsHealths(positions, healths, directions);
        assertEquals(List.of(2, 17, 9, 15, 10), result);
    }

    @Test
    public void testSurvivedRobotsHealthsExample2() {
        LC2751_Robot_Collisions solver = new LC2751_Robot_Collisions();
        int[] positions = {3, 5, 2, 6};
        int[] healths = {10, 10, 15, 12};
        String directions = "RLRL";
        List<Integer> result = solver.survivedRobotsHealths(positions, healths, directions);
        assertEquals(List.of(14), result);
    }

    @Test
    public void testSurvivedRobotsHealthsExample3() {
        LC2751_Robot_Collisions solver = new LC2751_Robot_Collisions();
        int[] positions = {1, 2, 5, 6};
        int[] healths = {10, 10, 11, 11};
        String directions = "RLRL";
        List<Integer> result = solver.survivedRobotsHealths(positions, healths, directions);
        assertTrue(result.isEmpty());
    }
}
