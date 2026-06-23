package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC236_Lowest_Common_Ancestor_Of_Binary_Tree_Test {

    private LC236_Lowest_Common_Ancestor_Of_Binary_Tree.TreeNode createTree(Integer[] values, int index) {
        if (index >= values.length || values[index] == null) return null;
        LC236_Lowest_Common_Ancestor_Of_Binary_Tree.TreeNode node = new LC236_Lowest_Common_Ancestor_Of_Binary_Tree.TreeNode(values[index]);
        node.left = createTree(values, 2 * index + 1);
        node.right = createTree(values, 2 * index + 2);
        return node;
    }

    @Test
    public void testLowestCommonAncestorExample1() {
        Integer[] treeVals = {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        LC236_Lowest_Common_Ancestor_Of_Binary_Tree.TreeNode root = createTree(treeVals, 0);
        LC236_Lowest_Common_Ancestor_Of_Binary_Tree.TreeNode p = root.left;
        LC236_Lowest_Common_Ancestor_Of_Binary_Tree.TreeNode q = root.right;
        assertEquals(root, LC236_Lowest_Common_Ancestor_Of_Binary_Tree.lowestCommonAncestor(root, p, q));
    }

    @Test
    public void testLowestCommonAncestorExample2() {
        Integer[] treeVals = {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        LC236_Lowest_Common_Ancestor_Of_Binary_Tree.TreeNode root = createTree(treeVals, 0);
        LC236_Lowest_Common_Ancestor_Of_Binary_Tree.TreeNode p = root.left;
        LC236_Lowest_Common_Ancestor_Of_Binary_Tree.TreeNode q = root.left.right.right;
        assertEquals(p, LC236_Lowest_Common_Ancestor_Of_Binary_Tree.lowestCommonAncestor(root, p, q));
    }
}
