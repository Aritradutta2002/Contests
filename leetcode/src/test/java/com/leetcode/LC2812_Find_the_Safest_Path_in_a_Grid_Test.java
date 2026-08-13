package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class LC2812_Find_the_Safest_Path_in_a_Grid_Test {

    private List<List<Integer>> toList(int[][] grid) {
        List<List<Integer>> res = new ArrayList<>();
        for (int[] row : grid) {
            List<Integer> r = new ArrayList<>();
            for (int val : row) {
                r.add(val);
            }
            res.add(r);
        }
        return res;
    }

    @Test
    public void testThiefAtStartOrEnd() {
        int[][] gridStartThief = {
            {1, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };
        assertEquals(0, LC2812_Find_the_Safest_Path_in_a_Grid.maximumSafenessFactor(toList(gridStartThief)));

        int[][] gridEndThief = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 1}
        };
        assertEquals(0, LC2812_Find_the_Safest_Path_in_a_Grid.maximumSafenessFactor(toList(gridEndThief)));
    }

    @Test
    public void testSingleThiefCorner() {
        int[][] grid = {
            {0, 0, 1},
            {0, 0, 0},
            {0, 0, 0}
        };
        // Best path: (0,0) -> (1,0) -> (2,0) -> (2,1) -> (2,2)
        // Manhattan distances from (0,2):
        // (0,0): 2, (1,0): 3, (2,0): 4, (2,1): 3, (2,2): 2.
        // Min distance on path is 2.
        assertEquals(2, LC2812_Find_the_Safest_Path_in_a_Grid.maximumSafenessFactor(toList(grid)));
    }

    @Test
    public void testMultipleThiefs() {
        int[][] grid = {
            {0, 0, 0, 1},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {1, 0, 0, 0}
        };
        // Path (0,0) -> (1,0) -> (1,1) -> (2,1) -> (2,2) -> (2,3) -> (3,3)
        // Manhattan distance from any thief (at (0,3) and (3,0)):
        // (0,0): 3 (dist to (3,0))
        // (1,0): 2
        // (1,1): 2 (dist to (0,3) is 1+2=3, to (3,0) is 2+1=3) -> wait:
        // dist from (1,1) to (0,3): |1-0| + |1-3| = 1 + 2 = 3.
        // dist from (1,1) to (3,0): |1-3| + |1-0| = 2 + 1 = 3.
        // Wait, what is distance of (2,2) to (3,0): |2-3| + |2-0| = 1 + 2 = 3.
        // to (0,3): |2-0| + |2-3| = 2 + 1 = 3.
        // Let's verify best path minimum safeness. It should be 2.
        assertEquals(2, LC2812_Find_the_Safest_Path_in_a_Grid.maximumSafenessFactor(toList(grid)));
    }
}
