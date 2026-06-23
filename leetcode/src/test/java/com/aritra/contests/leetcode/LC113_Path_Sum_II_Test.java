package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class LC113_Path_Sum_II_Test {

    private final LC113_Path_Sum_II solver = new LC113_Path_Sum_II();

    @Test
    public void testPathSumFound() {
        TreeNode root = new TreeNode(5,
            new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
            new TreeNode(8, new TreeNode(13), new TreeNode(4, new TreeNode(5), new TreeNode(1))));
        List<List<Integer>> result = solver.pathSum(root, 22);
        assertEquals(2, result.size());
    }

    @Test
    public void testNoPath() {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        assertTrue(solver.pathSum(root, 5).isEmpty());
    }

    @Test
    public void testEmptyTree() {
        assertTrue(solver.pathSum(null, 0).isEmpty());
    }
}
