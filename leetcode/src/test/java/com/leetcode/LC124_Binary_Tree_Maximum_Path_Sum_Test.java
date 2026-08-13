package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC124_Binary_Tree_Maximum_Path_Sum_Test {

    @Test
    public void testSimpleTree() {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        assertEquals(6, LC124_Binary_Tree_Maximum_Path_Sum.maxPathSum(root));
    }

    @Test
    public void testNegativeValues() {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        assertEquals(42, LC124_Binary_Tree_Maximum_Path_Sum.maxPathSum(root));
    }

    @Test
    public void testSingleNode() {
        TreeNode root = new TreeNode(2, new TreeNode(-1), null);
        assertEquals(2, LC124_Binary_Tree_Maximum_Path_Sum.maxPathSum(root));
    }
}
