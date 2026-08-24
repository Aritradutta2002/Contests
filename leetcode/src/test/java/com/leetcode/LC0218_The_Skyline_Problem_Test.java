package com.leetcode;

import java.util.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC0218_The_Skyline_Problem_Test {

    private final LC0218_The_Skyline_Problem solver = new LC0218_The_Skyline_Problem();

    @Test
    public void testExample1() {
        int[][] param1 = new int[][]{{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
        List<List<Integer>> expected = List.of(List.of(2,10), List.of(3,15), List.of(7,12), List.of(12,0), List.of(15,10), List.of(20,8), List.of(24,0));
        List<List<Integer>> actual = solver.getSkyline(param1);
        assertEquals(expected, actual);
    }

    @Test
    public void testExample2() {
        int[][] param1 = new int[][]{{0,2,3},{2,5,3}};
        List<List<Integer>> expected = List.of(List.of(0,3), List.of(5,0));
        List<List<Integer>> actual = solver.getSkyline(param1);
        assertEquals(expected, actual);
    }

    @Test
    public void testSegmentTreeMatchesExamples() {
        assertEquals(
            List.of(List.of(2,10), List.of(3,15), List.of(7,12), List.of(12,0), List.of(15,10), List.of(20,8), List.of(24,0)),
            solver.getSkylineSegmentTree(new int[][]{{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}}));
        assertEquals(
            List.of(List.of(0,3), List.of(5,0)),
            solver.getSkylineSegmentTree(new int[][]{{0,2,3},{2,5,3}}));
    }

    @Test
    public void testEdgeCases() {
        int max = Integer.MAX_VALUE;
        int[][][] inputs = {
            {{1,5,7}},                        // single building
            {{0,10,5},{2,4,3}},               // shorter fully nested inside taller
            {{1,3,4},{1,3,4}},                // exact duplicates
            {{1,2,3},{5,6,3}},                // gap must dip to ground
            {{0,5,1},{1,6,2},{2,7,3}},        // staircase up, then all end under the tallest
            {{0,5,10},{5,10,3}},              // shorter starts exactly where taller ends
            {{0,5,3},{5,10,10}},              // taller starts exactly where shorter ends
            {{0,max,max},{0,max,max}},        // constraint extremes
        };
        List<List<List<Integer>>> expected = List.of(
            List.of(List.of(1,7), List.of(5,0)),
            List.of(List.of(0,5), List.of(10,0)),
            List.of(List.of(1,4), List.of(3,0)),
            List.of(List.of(1,3), List.of(2,0), List.of(5,3), List.of(6,0)),
            List.of(List.of(0,1), List.of(1,2), List.of(2,3), List.of(7,0)),
            List.of(List.of(0,10), List.of(5,3), List.of(10,0)),
            List.of(List.of(0,3), List.of(5,10), List.of(10,0)),
            List.of(List.of(0,max), List.of(max,0)));

        for (int i = 0; i < inputs.length; i++) {
            assertEquals(expected.get(i), solver.getSkylineSweepLine(inputs[i]), "sweep line, case " + i);
            assertEquals(expected.get(i), solver.getSkylineSegmentTree(inputs[i]), "segment tree, case " + i);
        }
    }

    /* Both approaches must agree with each other and with a naive per-interval maximum. */
    @Test
    public void testApproachesAgreeOnRandomInput() {
        Random random = new Random(42);
        for (int iteration = 0; iteration < 500; iteration++) {
            int n = 1 + random.nextInt(30);
            int[][] buildings = new int[n][];
            for (int i = 0; i < n; i++) {
                int left = random.nextInt(50);
                buildings[i] = new int[]{left, left + 1 + random.nextInt(10), 1 + random.nextInt(20)};
            }
            Arrays.sort(buildings, (a, b) -> Integer.compare(a[0], b[0]));

            List<List<Integer>> expected = bruteForceSkyline(buildings);
            String label = "buildings=" + Arrays.deepToString(buildings);
            assertEquals(expected, solver.getSkylineSweepLine(buildings), "sweep line, " + label);
            assertEquals(expected, solver.getSkylineSegmentTree(buildings), "segment tree, " + label);
        }
    }

    /* Oracle: scan every unit x slice and record where the tallest covering building changes. */
    private List<List<Integer>> bruteForceSkyline(int[][] buildings) {
        int maxX = 0;
        for (int[] b : buildings) {
            maxX = Math.max(maxX, b[1]);
        }
        List<List<Integer>> skyline = new ArrayList<>();
        int prevHeight = 0;
        for (int x = 0; x <= maxX; x++) {
            int height = 0;
            for (int[] b : buildings) {
                if (b[0] <= x && x < b[1]) {
                    height = Math.max(height, b[2]);
                }
            }
            if (height != prevHeight) {
                skyline.add(List.of(x, height));
                prevHeight = height;
            }
        }
        return skyline;
    }
}