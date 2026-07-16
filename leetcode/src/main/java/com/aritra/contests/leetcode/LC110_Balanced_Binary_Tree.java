package com.aritra.contests.leetcode;

/*
 * 110. Balanced Binary Tree
 *
 * Given a binary tree, determine if it is height-balanced. A height-balanced binary tree is a tree
 * in which the depth of the two subtrees of every node never differs by more than one.
 *
 * Constraints:
 * - The number of nodes in the tree is in the range [0, 5000]
 * - -10^4 <= Node.val <= 10^4
 */
public class LC110_Balanced_Binary_Tree {
    public static boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }
    private static int checkHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) return -1;

        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}

