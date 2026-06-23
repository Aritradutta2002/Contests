package com.aritra.contests.leetcode;
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
