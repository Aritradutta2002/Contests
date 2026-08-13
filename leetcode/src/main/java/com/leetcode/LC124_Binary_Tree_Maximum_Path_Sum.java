package com.leetcode;

/*
 * 124. Binary Tree Maximum Path Sum
 *
 * Description:
 * A path in a binary tree is a sequence of nodes where each pair of adjacent
 * nodes has an edge connecting them. A node can appear in the sequence at most once.
 * The path does not need to pass through the root.
 *
 * Return the maximum path sum of any non-empty path.
 *
 * Constraints:
 * The number of nodes is in the range [1, 3 * 10^4].
 * -1000 <= Node.val <= 1000
 */
public class LC124_Binary_Tree_Maximum_Path_Sum {
    public static int maxPathSum(TreeNode root) {
        int[] maxSum = new int[]{Integer.MIN_VALUE};
        dfs(root, maxSum);
        return maxSum[0];
    }
    private static int dfs(TreeNode node, int[] maxSum) {
        if (node == null) return 0;
        int left = Math.max(0, dfs(node.left, maxSum));
        int right = Math.max(0, dfs(node.right, maxSum));
        int pathThroughNode = node.val + left + right;
        maxSum[0] = Math.max(maxSum[0], pathThroughNode);
        return node.val + Math.max(left, right);
    }
}
