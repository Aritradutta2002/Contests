package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC110_Balanced_Binary_Tree_Test {

    @Test
    public void testBalancedTree() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        assertTrue(LC110_Balanced_Binary_Tree.isBalanced(root));
    }

    @Test
    public void testUnbalancedTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        assertFalse(LC110_Balanced_Binary_Tree.isBalanced(root));
    }

    @Test
    public void testEmptyTree() {
        assertTrue(LC110_Balanced_Binary_Tree.isBalanced(null));
    }
}
