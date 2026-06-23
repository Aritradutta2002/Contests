package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class LC133_Clone_Graph_Test {

    private final LC133_Clone_Graph solver = new LC133_Clone_Graph();

    private LC133_Clone_Graph.Node buildGraph(int[][] adjList) {
        if (adjList == null || adjList.length == 0) return null;
        LC133_Clone_Graph.Node[] nodes = new LC133_Clone_Graph.Node[adjList.length + 1];
        for (int i = 1; i <= adjList.length; i++) nodes[i] = new LC133_Clone_Graph.Node(i);
        for (int i = 0; i < adjList.length; i++) {
            for (int neighbor : adjList[i]) {
                nodes[i + 1].neighbors.add(nodes[neighbor]);
            }
        }
        return nodes[1];
    }

    @Test
    public void testCloneFourNodeGraph() {
        int[][] adj1 = {{2, 4}, {1, 3}, {2, 4}, {1, 3}};
        LC133_Clone_Graph.Node original = buildGraph(adj1);
        LC133_Clone_Graph.Node cloned = solver.cloneGraph(original);
        assertNotNull(cloned);
        assertNotSame(original, cloned);
        assertEquals(original.val, cloned.val);
    }

    @Test
    public void testSingleNode() {
        int[][] adj2 = {{}};
        LC133_Clone_Graph.Node original = buildGraph(adj2);
        LC133_Clone_Graph.Node cloned = solver.cloneGraph(original);
        assertNotNull(cloned);
        assertNotSame(original, cloned);
        assertTrue(cloned.neighbors.isEmpty());
    }

    @Test
    public void testNullInput() {
        assertNull(solver.cloneGraph(null));
    }
}
