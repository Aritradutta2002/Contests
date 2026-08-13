package com.leetcode;

@SuppressWarnings("unused")
/*
 * 236. Lowest Common Ancestor of a Binary Tree
 *
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes p and q in the tree.
 *
 * Constraints:
 * - The number of nodes in the tree is in the range [2, 10^5]
 * - -10^9 <= Node.val <= 10^9
 * - All Node.val are unique
 * - p != q
 * - p and q exist in the tree
 */
public class LC236_Lowest_Common_Ancestor_Of_Binary_Tree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }
}

