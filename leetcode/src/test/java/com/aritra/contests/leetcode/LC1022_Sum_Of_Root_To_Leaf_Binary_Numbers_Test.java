package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC1022_Sum_Of_Root_To_Leaf_Binary_Numbers_Test {

    private LC1022_Sum_Of_Root_To_Leaf_Binary_Numbers.TreeNode createTree() {
        LC1022_Sum_Of_Root_To_Leaf_Binary_Numbers.TreeNode root = new LC1022_Sum_Of_Root_To_Leaf_Binary_Numbers.TreeNode(1);
        root.left = new LC1022_Sum_Of_Root_To_Leaf_Binary_Numbers.TreeNode(0);
        root.right = new LC1022_Sum_Of_Root_To_Leaf_Binary_Numbers.TreeNode(1);
        root.left.left = new LC1022_Sum_Of_Root_To_Leaf_Binary_Numbers.TreeNode(0);
        root.left.right = new LC1022_Sum_Of_Root_To_Leaf_Binary_Numbers.TreeNode(1);
        root.right.left = new LC1022_Sum_Of_Root_To_Leaf_Binary_Numbers.TreeNode(0);
        root.right.right = new LC1022_Sum_Of_Root_To_Leaf_Binary_Numbers.TreeNode(1);
        return root;
    }

    @Test
    public void testStandardCase() {
        LC1022_Sum_Of_Root_To_Leaf_Binary_Numbers solver = new LC1022_Sum_Of_Root_To_Leaf_Binary_Numbers();
        assertEquals(22, solver.sumRootToLeaf(createTree()));
    }

    @Test
    public void testSingleNode() {
        LC1022_Sum_Of_Root_To_Leaf_Binary_Numbers solver = new LC1022_Sum_Of_Root_To_Leaf_Binary_Numbers();
        LC1022_Sum_Of_Root_To_Leaf_Binary_Numbers.TreeNode root = new LC1022_Sum_Of_Root_To_Leaf_Binary_Numbers.TreeNode(0);
        assertEquals(0, solver.sumRootToLeaf(root));
    }
}
