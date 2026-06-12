package com.aritra.contests.leetcode;
import java.util.*;
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
 *
 * Input format (method):
 * TreeNode root
 *
 * Output format (method):
 * int maximum path sum
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

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private static TreeNode buildTreeFromLevelOrder(Integer[] values) {
        if (values == null || values.length == 0 || values[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int idx = 1;
        while (!queue.isEmpty() && idx < values.length) {
            TreeNode current = queue.poll();

            if (idx < values.length && values[idx] != null) {
                current.left = new TreeNode(values[idx]);
                queue.offer(current.left);
            }
            idx++;

            if (idx < values.length && values[idx] != null) {
                current.right = new TreeNode(values[idx]);
                queue.offer(current.right);
            }
            idx++;
        }

        return root;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.close();

        runTest("Example 1", buildTreeFromLevelOrder(new Integer[] {1, 2, 3}), 6);
        runTest("Example 2", buildTreeFromLevelOrder(new Integer[] {-10, 9, 20, null, null, 15, 7}), 42);
        runTest("Example 3", buildTreeFromLevelOrder(new Integer[] {2, -1}), 2);
    }

    private static void runTest(String testName, TreeNode root, int expected) {
        try {
            int actual = maxPathSum(root);
            if (actual == expected) {
                System.out.println(testName + ": PASS (expected=" + expected + ", actual=" + actual + ")");
            } else {
                System.out.println(testName + ": FAIL (expected=" + expected + ", actual=" + actual + ")");
            }
        } catch (UnsupportedOperationException ex) {
            System.out.println(testName + ": SKIPPED (Not implemented yet.)");
        }
    }
}
