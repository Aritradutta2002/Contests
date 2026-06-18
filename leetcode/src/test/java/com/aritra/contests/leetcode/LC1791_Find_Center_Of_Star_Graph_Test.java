package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC1791_Find_Center_Of_Star_Graph_Test {

    @Test
    public void testStandardCase() {
        int[][] edges = {{1,2},{2,3},{4,2}};
        assertEquals(2, LC1791_Find_Center_Of_Star_Graph.findCenter(edges));
    }

    @Test
    public void testSimpleStar() {
        int[][] edges = {{1,2},{5,1},{1,3},{1,4}};
        assertEquals(1, LC1791_Find_Center_Of_Star_Graph.findCenter(edges));
    }
}
