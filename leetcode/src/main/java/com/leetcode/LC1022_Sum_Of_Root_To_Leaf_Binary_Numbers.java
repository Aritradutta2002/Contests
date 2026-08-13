package com.leetcode;
/*
 * 1022. Sum of Root To Leaf Binary Numbers
 *
 * You are given the root of a binary tree where each node has a value 0 or 1. Each root-to-leaf path
 * represents a binary number starting with the most significant bit. Return the sum of all root-to-leaf
 * numbers modulo 10^9 + 7.
 *
 * Constraints:
 * - The number of nodes in the tree is in the range [1, 1000]
 * - Node.val is 0 or 1
 */
public class LC1022_Sum_Of_Root_To_Leaf_Binary_Numbers {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }
    public int dfs(TreeNode node, int curr){
        if(node == null) return 0;

        curr = (curr << 1) | node.val;

        if(node.left == null && node.right == null) return curr;

        return dfs(node.left, curr) + dfs(node.right, curr);
    }
}
