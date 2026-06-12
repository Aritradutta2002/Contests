package com.aritra.contests.atcoder.educationaldp.bfrog2;

import java.io.*;
import java.util.*;

public class B_Frog2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        String[] heightsStr = br.readLine().trim().split("\\s+");
        long[] h = new long[N];
        for (int i = 0; i < N; i++) {
            h[i] = Long.parseLong(heightsStr[i]);
        }
        
        // dp[i] = min cost to reach stone i (0-indexed)
        long[] dp = new long[N];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= K && i - j >= 0; j++) {
                if (dp[i - j] != Long.MAX_VALUE)
                    dp[i] = Math.min(dp[i], dp[i - j] + Math.abs(h[i] - h[i - j]));
            }
        }
        System.out.println(dp[N - 1]);
    }
}