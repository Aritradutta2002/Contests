package com.aritra.contests.atcoder.educationaldp.dknapsack1;

import java.io.*;
import java.util.*;

public class D_Knapsack1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        
        int[] w = new int[N];
        long[] v = new long[N];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Long.parseLong(st.nextToken());
        }
        
        // dp[j] = max value with capacity j
        long[] dp = new long[W + 1];
        for (int i = 0; i < N; i++) {
            for (int j = W; j >= w[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
            }
        }
        System.out.println(dp[W]);
    }
}