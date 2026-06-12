package com.aritra.contests.atcoder.educationaldp.pindependentset;

import java.io.*;
import java.util.*;

public class P_IndependentSet {
    static final long MOD = 1_000_000_007L;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine().trim());
        
        List<Integer>[] tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < N - 1; i++) {
            String line = br.readLine().trim();
            if (line.isEmpty()) continue;
            StringTokenizer st = new StringTokenizer(line);
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            tree[x].add(y);
            tree[y].add(x);
        }
        
        // Tree DP: dp[v][0] = ways if v is white, dp[v][1] = ways if v is black
        // Root at vertex 1, iterative DFS
        long[][] dp = new long[N + 1][2];
        int[] parent = new int[N + 1];
        int[] order = new int[N];
        boolean[] visited = new boolean[N + 1];
        int head = 0, tail = 0;
        order[tail++] = 1;
        visited[1] = true;
        parent[1] = 0;
        while (head < tail) {
            int u = order[head++];
            for (int nb : tree[u]) {
                if (!visited[nb]) {
                    visited[nb] = true;
                    parent[nb] = u;
                    order[tail++] = nb;
                }
        }}
        // Process in reverse BFS order (leaves first)
        for (int k = N - 1; k >= 0; k--) {
            int u = order[k];
            dp[u][0] = 1; // white: children can be either
            dp[u][1] = 1; // black: children must be white
            for (int nb : tree[u]) {
                if (nb == parent[u]) continue;
                dp[u][0] = dp[u][0] * ((dp[nb][0] + dp[nb][1]) % MOD) % MOD;
                dp[u][1] = dp[u][1] * dp[nb][0] % MOD;
            }
        }
        System.out.println((dp[1][0] + dp[1][1]) % MOD);
    }
}