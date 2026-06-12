package com.aritra.contests.atcoder.educationaldp.nslimes;

import java.io.*;
import java.util.*;

public class N_Slimes {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine().trim());
        String[] parts = br.readLine().trim().split("\\s+");
        long[] a = new long[N];
        for (int i = 0; i < N; i++) {
            a[i] = Long.parseLong(parts[i]);
        }
        
        // Interval DP: dp[i][j] = min cost to merge slimes i..j
        // prefix sums for range sum
        long[] prefix = new long[N + 1];
        for (int i = 0; i < N; i++) prefix[i + 1] = prefix[i] + a[i];
        long[][] dp = new long[N][N];
        for (long[] row : dp) Arrays.fill(row, Long.MAX_VALUE / 2);
        for (int i = 0; i < N; i++) dp[i][i] = 0;
        for (int len = 2; len <= N; len++) {
            for (int i = 0; i <= N - len; i++) {
                int j = i + len - 1;
                long rangeSum = prefix[j + 1] - prefix[i];
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + rangeSum);
                }
            }
        }
        System.out.println(dp[0][N - 1]);
    }
}