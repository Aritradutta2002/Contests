package com.aritra.contests.leetcode;

public class LC129_Sum_Root_To_Leaf_Numbers {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public static int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private static int dfs(TreeNode node, int current) {
        if (node == null) {
            return 0;
        }

        int next = current * 10 + node.val;
        if (node.left == null && node.right == null) {
            return next;
        }

        return dfs(node.left, next) + dfs(node.right, next);
    }
}

