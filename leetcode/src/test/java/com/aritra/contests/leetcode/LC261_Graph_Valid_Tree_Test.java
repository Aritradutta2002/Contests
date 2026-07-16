package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC261_Graph_Valid_Tree_Test {

    @Test
    public void testValidTreeExample1() {
        LC261_Graph_Valid_Tree solver = new LC261_Graph_Valid_Tree();
        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        assertTrue(solver.validTree(5, edges));
    }

    @Test
    public void testValidTreeExample2() {
        LC261_Graph_Valid_Tree solver = new LC261_Graph_Valid_Tree();
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
        assertFalse(solver.validTree(5, edges));
    }

    @Test
    public void testValidTreeExample3() {
        LC261_Graph_Valid_Tree solver = new LC261_Graph_Valid_Tree();
        int[][] edges = {{0, 1}, {2, 3}};
        assertFalse(solver.validTree(4, edges));
    }
}
