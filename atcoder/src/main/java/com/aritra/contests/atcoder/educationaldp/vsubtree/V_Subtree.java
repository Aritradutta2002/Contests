package com.aritra.contests.atcoder.educationaldp.vsubtree;

import java.io.*;
import java.util.*;

public class V_Subtree {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        
        List<Integer>[] tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            tree[x].add(y);
            tree[y].add(x);
        }
        
        // Rerooting tree DP
        // dp[v] = number of ways to paint the subtree rooted at v (v forced black)
        //         such that all black vertices form a connected subtree within that subtree
        // dp[v] = product over children c of (dp[c] + 1)
        //   where +1 means child c's subtree is all white (c is white)
        long[] dp = new long[N + 1];
        int[] parent = new int[N + 1];
        int[] order = new int[N];
        boolean[] visited = new boolean[N + 1];
        // BFS to get topological order
        int head = 0, tail = 0;
        order[tail++] = 1; visited[1] = true; parent[1] = 0;
        while (head < tail) {
            int u = order[head++];
            for (int nb : tree[u]) if (!visited[nb]) {
                visited[nb] = true; parent[nb] = u; order[tail++] = nb;
            }
        }
        // Bottom-up: compute dp[v] for subtree rooted at v
        for (int k = N - 1; k >= 0; k--) {
            int u = order[k];
            dp[u] = 1;
            for (int nb : tree[u]) if (nb != parent[u])
                dp[u] = dp[u] * ((dp[nb] + 1) % M) % M;
        }
        // Top-down rerooting: g[v] = contribution from the "upward" part
        // ans[v] = dp[v] * g[v] (v forced black, the whole tree's valid colorings)
        long[] g = new long[N + 1];
        long[] ans = new long[N + 1];
        g[1] = 1;
        for (int k = 0; k < N; k++) {
            int u = order[k];
            ans[u] = dp[u] * g[u] % M;
            // compute g for each child c of u
            // g[c] = g[u] * (product of (dp[sibling]+1) for all siblings) * ...
            // We need prefix/suffix products of (dp[child]+1) over children of u
            List<Integer> children = new ArrayList<>();
            for (int nb : tree[u]) if (nb != parent[u]) children.add(nb);
            int sz = children.size();
            long[] pre = new long[sz + 1];
            long[] suf = new long[sz + 2];
            pre[0] = 1; suf[sz] = 1;
            for (int i = 0; i < sz; i++) pre[i + 1] = pre[i] * ((dp[children.get(i)] + 1) % M) % M;
            for (int i = sz - 1; i >= 0; i--) suf[i] = suf[i + 1] * ((dp[children.get(i)] + 1) % M) % M;
            for (int i = 0; i < sz; i++) {
                int c = children.get(i);
                // g[c] = g[u] * (dp[u]/( dp[c]+1 )) ... use prefix/suffix product
                g[c] = g[u] * pre[i] % M * suf[i + 1] % M * ((g[u] == 0) ? 1 : 1) % M;
                // Actually g[c] = (g[u] * pre[i] * suf[i+1] + 1) represents:
                // the parent's black chain can either stop before c (contribute 1 way where c's subtree all white)
                // or the parent is also black => multiply by g[u]*pre[i]*suf[i+1]
                // Full formula: g[c] = g[u]*pre[i]*suf[i+1] + 1  ... no
                // Correct: g[c] = (g[u] * pre[i] % M * suf[i+1] % M + 1) % M
                g[c] = (g[u] * pre[i] % M * suf[i + 1] % M + 1) % M;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int v = 1; v <= N; v++) sb.append(ans[v]).append('\n');
        System.out.print(sb);
    }
}