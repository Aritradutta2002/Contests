package com.aritra.contests.leetcode;

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

