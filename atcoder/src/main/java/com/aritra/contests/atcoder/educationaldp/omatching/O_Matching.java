package com.aritra.contests.atcoder.educationaldp.omatching;

import java.io.*;
import java.util.*;

public class O_Matching {
    static final long MOD = 1_000_000_007L;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine().trim());
        int[][] a = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            String[] parts = br.readLine().trim().split("\\s+");
            for (int j = 0; j < N; j++) {
                a[i][j] = Integer.parseInt(parts[j]);
            }
        }
        
        // Bitmask DP: dp[mask] = number of ways to match first popcount(mask) men
        // to women indicated by mask
        long[] dp = new long[1 << N];
        dp[0] = 1;
        for (int mask = 0; mask < (1 << N); mask++) {
            if (dp[mask] == 0) continue;
            int man = Integer.bitCount(mask); // next man to assign (0-indexed)
            if (man == N) continue;
            for (int woman = 0; woman < N; woman++) {
                if ((mask & (1 << woman)) == 0 && a[man][woman] == 1) {
                    dp[mask | (1 << woman)] = (dp[mask | (1 << woman)] + dp[mask]) % MOD;
                }
            }
        }
        System.out.println(dp[(1 << N) - 1]);
    }
}