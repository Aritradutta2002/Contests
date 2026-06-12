package com.aritra.contests.atcoder.educationaldp.eknapsack2;

import java.io.*;
import java.util.*;

public class E_Knapsack2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        long W = Long.parseLong(st.nextToken());
        
        int[] w = new int[N];
        int[] v = new int[N];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }
        
        // W can be up to 1e9 but max total value <= N*1000 = 100000
        // dp[val] = min weight to achieve total value val
        int maxVal = N * 1000;
        long[] dp = new long[maxVal + 1];
        Arrays.fill(dp, Long.MAX_VALUE / 2);
        dp[0] = 0;
        for (int i = 0; i < N; i++) {
            for (int j = maxVal; j >= v[i]; j--) {
                dp[j] = Math.min(dp[j], dp[j - v[i]] + w[i]);
            }
        }
        long ans = 0;
        for (int j = maxVal; j >= 0; j--) {
            if (dp[j] <= W) {
                ans = j;
                break;
            }
        }
        System.out.println(ans);
    }
}