package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC129_Sum_Root_To_Leaf_Numbers_Test {

    @Test
    public void testStandardCase() {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        assertEquals(25, LC129_Sum_Root_To_Leaf_Numbers.sumNumbers(root));
    }

    @Test
    public void testAnotherCase() {
        TreeNode root = new TreeNode(4,
            new TreeNode(9, new TreeNode(5), new TreeNode(1)),
            new TreeNode(0));
        assertEquals(1026, LC129_Sum_Root_To_Leaf_Numbers.sumNumbers(root));
    }

    @Test
    public void testEmptyTree() {
        assertEquals(0, LC129_Sum_Root_To_Leaf_Numbers.sumNumbers(null));
    }
}
