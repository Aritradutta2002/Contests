package com.leetcode;

import java.util.*;

/*
 * [113] Path Sum II
 *
 * Given the root of a binary tree and an integer targetSum, return all root-to-leaf
 * paths where the sum of the node values in the path equals targetSum.
 */
class LC113_Path_Sum_II {

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
