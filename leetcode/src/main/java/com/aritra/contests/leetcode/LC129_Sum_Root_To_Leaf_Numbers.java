package com.aritra.contests.leetcode;

/*
 * 129. Sum Root to Leaf Numbers
 *
 * You are given the root of a binary tree containing digits from 0 to 9 only. Each root-to-leaf path
 * represents a number. Return the total sum of all root-to-leaf numbers.
 *
 * Constraints:
 * - The number of nodes in the tree is in the range [1, 1000]
 * - 0 <= Node.val <= 9
 * - The depth of the tree will not exceed 10
 */
public class LC129_Sum_Root_To_Leaf_Numbers {
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

