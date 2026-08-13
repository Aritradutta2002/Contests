package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC323_Number_Of_Connected_Components_In_An_Undirected_Graph_Test {

    @Test
    public void testExample1() {
        LC323_Number_Of_Connected_Components_In_An_Undirected_Graph solver = new LC323_Number_Of_Connected_Components_In_An_Undirected_Graph();
        int n = 5;
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
        assertEquals(2, solver.countComponents(n, edges));
    }

    @Test
    public void testExample2() {
        LC323_Number_Of_Connected_Components_In_An_Undirected_Graph solver = new LC323_Number_Of_Connected_Components_In_An_Undirected_Graph();
        int n = 5;
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 4}};
        assertEquals(1, solver.countComponents(n, edges));
    }

    @Test
    public void testExample3() {
        LC323_Number_Of_Connected_Components_In_An_Undirected_Graph solver = new LC323_Number_Of_Connected_Components_In_An_Undirected_Graph();
        int n = 5;
        int[][] edges = {};
        assertEquals(5, solver.countComponents(n, edges));
    }
}
