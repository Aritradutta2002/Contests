package com.aritra.contests.atcoder.educationaldp.glongestpath;

import java.io.*;
import java.util.*;

public class G_LongestPath {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        List<Integer>[] graph = new ArrayList[N + 1];
        int[] inDegree = new int[N + 1];
        
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            inDegree[y]++;
        }
        
        // dp[v] = longest path starting from v; computed via topological sort
        int[] dp = new int[N + 1];
        Arrays.fill(dp, -1);
        // Topological sort using Kahn's algorithm then process in reverse
        Queue<Integer> queue = new LinkedList<>();
        for (int v = 1; v <= N; v++)
            if (inDegree[v] == 0) queue.add(v);
        int[] topoOrder = new int[N];
        int idx = 0;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            topoOrder[idx++] = u;
            for (int nb : graph[u]) {
                if (--inDegree[nb] == 0) queue.add(nb);
            }
        }
        // Process in reverse topological order
        for (int k = N - 1; k >= 0; k--) {
            int u = topoOrder[k];
            dp[u] = 0;
            for (int nb : graph[u])
                dp[u] = Math.max(dp[u], 1 + dp[nb]);
        }
        int ans = 0;
        for (int v = 1; v <= N; v++) ans = Math.max(ans, dp[v]);
        System.out.println(ans);
    }
}