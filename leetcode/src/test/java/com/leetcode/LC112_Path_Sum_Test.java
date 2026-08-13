package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC112_Path_Sum_Test {

    private final LC112_Path_Sum solver = new LC112_Path_Sum();

    @Test
    public void testHasPathSum() {
        TreeNode root = new TreeNode(5,
            new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
            new TreeNode(8, new TreeNode(13), new TreeNode(4, null, new TreeNode(1))));
        assertTrue(solver.hasPathSum(root, 22));
    }

    @Test
    public void testNoPathSum() {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        assertFalse(solver.hasPathSum(root, 5));
    }

    @Test
    public void testEmptyTree() {
        assertFalse(solver.hasPathSum(null, 0));
    }
}
