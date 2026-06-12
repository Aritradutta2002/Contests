package com.aritra.contests.leetcode;
import java.util.*;
/*
 * LeetCode 547. Number of Provinces
 *
 * Description:
 * There are n cities represented by an n x n adjacency matrix isConnected,
 * where isConnected[i][j] = 1 means city i and city j are directly connected,
 * and 0 otherwise. A province is a group of directly or indirectly connected
 * cities with no cities outside the group.
 *
 * Return the total number of provinces.
 *
 * Constraints:
 * 1 <= n <= 200
 * n == isConnected.length
 * n == isConnected[i].length
 * isConnected[i][j] is 0 or 1
 * isConnected[i][i] == 1
 * isConnected[i][j] == isConnected[j][i]
 */
public class LC547_Number_Of_Provinces {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int connectedComponent = countConnectedDFS(isConnected, n);
        return connectedComponent;
    }

    public int countConnectedDFS(int[][] connected, int n) {
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, visited, connected);
                count++;
            }
        }
        return count;
    }

    public void dfs(int node, boolean[] visited, int[][] connected){
        int n = connected.length;
        visited[node] = true;
        for(int neighbor = 0; neighbor < n; neighbor++){
            if(connected[node][neighbor] == 1 && !visited[neighbor]){
                dfs(neighbor, visited, connected);
            }
        }
    }

    public static void main(String[] args) {
        LC547_Number_Of_Provinces solver = new LC547_Number_Of_Provinces();

        TestCase[] tests = new TestCase[] {
                new TestCase(
                        new int[][] {
                                { 1, 1, 0 },
                                { 1, 1, 0 },
                                { 0, 0, 1 }
                        },
                        2),
                new TestCase(
                        new int[][] {
                                { 1, 0, 0 },
                                { 0, 1, 0 },
                                { 0, 0, 1 }
                        },
                        3),
                new TestCase(
                        new int[][] {
                                { 1 }
                        },
                        1)
        };

        runAllTests(solver, tests);
    }

    private static void runAllTests(LC547_Number_Of_Provinces solver, TestCase[] tests) {
        int passed = 0;
        int skipped = 0;

        for (int i = 0; i < tests.length; i++) {
            TestCase tc = tests[i];
            try {
                int actual = solver.findCircleNum(tc.isConnected);
                boolean ok = actual == tc.expected;
                if (ok) {
                    passed++;
                }

                System.out.printf(
                        "Test %d | isConnected=%s | expected=%d, actual=%d | %s%n",
                        i + 1,
                        Arrays.deepToString(tc.isConnected),
                        tc.expected,
                        actual,
                        ok ? "PASS" : "FAIL");
            } catch (UnsupportedOperationException ex) {
                skipped++;
                System.out.printf(
                        "Test %d | isConnected=%s | expected=%d | SKIPPED (%s)%n",
                        i + 1,
                        Arrays.deepToString(tc.isConnected),
                        tc.expected,
                        ex.getMessage());
            }
        }

        System.out.printf("Summary: %d/%d passed, %d skipped.%n", passed, tests.length, skipped);
    }

    private static class TestCase {
        int[][] isConnected;
        int expected;

        TestCase(int[][] isConnected, int expected) {
            this.isConnected = isConnected;
            this.expected = expected;
        }
    }
}
