package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class LC3286_Find_a_Safe_Walk_Through_a_Grid_Test {

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
    public void testSafePathExists() {
        int[][] grid = {
            {0, 1, 0, 0, 0},
            {0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0}
        };
        int health = 1;
        assertTrue(LC3286_Find_a_Safe_Walk_Through_a_Grid.findSafeWalk(toList(grid), health));
    }

    @Test
    public void testNoSafePathPossible() {
        int[][] grid = {
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
        };
        // The path with minimum 1s has at least 4 ones:
        // (0,0)->(1,0)->(1,1)->(1,2)->(2,2) is 1->1->0->1->1 which has 4 ones.
        // What if health is 4? Minimum loss is 4, remaining is 0 (not >= 1), so false.
        assertFalse(LC3286_Find_a_Safe_Walk_Through_a_Grid.findSafeWalk(toList(grid), 4));
        assertTrue(LC3286_Find_a_Safe_Walk_Through_a_Grid.findSafeWalk(toList(grid), 5));
    }

    @Test
    public void testAllOnesGrid() {
        int[][] grid = {
            {1, 1},
            {1, 1}
        };
        // Path (0,0) -> (0,1) -> (1,1) is 1 -> 1 -> 1 (loss 3)
        // Path (0,0) -> (1,0) -> (1,1) is 1 -> 1 -> 1 (loss 3)
        // With health 3, remaining is 0, so false.
        // With health 4, remaining is 1, so true.
        assertFalse(LC3286_Find_a_Safe_Walk_Through_a_Grid.findSafeWalk(toList(grid), 3));
        assertTrue(LC3286_Find_a_Safe_Walk_Through_a_Grid.findSafeWalk(toList(grid), 4));
    }

    @Test
    public void testSingleCellGrid() {
        int[][] grid1 = {{0}};
        assertTrue(LC3286_Find_a_Safe_Walk_Through_a_Grid.findSafeWalk(toList(grid1), 1));
        
        int[][] grid2 = {{1}};
        assertFalse(LC3286_Find_a_Safe_Walk_Through_a_Grid.findSafeWalk(toList(grid2), 1));
        assertTrue(LC3286_Find_a_Safe_Walk_Through_a_Grid.findSafeWalk(toList(grid2), 2));
    }
}
