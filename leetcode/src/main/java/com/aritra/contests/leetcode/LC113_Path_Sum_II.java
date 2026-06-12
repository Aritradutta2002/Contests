package com.aritra.contests.leetcode;

/*
 * @lc app=leetcode id=113 lang=java
 *
 * [113] Path Sum II
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.*;
class LC113_Path_Sum_II {
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

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(root, targetSum, new ArrayList<>(), ans);
        return ans;
    }

    private void dfs(TreeNode node, int remainingSum, List<Integer> path, List<List<Integer>> ans) {
        if (node == null) {
            return;
        }

        path.add(node.val);

        if (node.left == null && node.right == null && remainingSum == node.val) {
            ans.add(new ArrayList<>(path));
        } else {
            dfs(node.left, remainingSum - node.val, path, ans);
            dfs(node.right, remainingSum - node.val, path, ans);
        }

        path.remove(path.size() - 1);
    }
}
// @lc code=end

