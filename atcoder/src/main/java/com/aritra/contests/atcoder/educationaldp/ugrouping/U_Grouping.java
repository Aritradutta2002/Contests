package com.aritra.contests.atcoder.educationaldp.ugrouping;

import java.io.*;
import java.util.*;

public class U_Grouping {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine().trim());
        long[][] a = new long[N][N];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                a[i][j] = Long.parseLong(st.nextToken());
            }
        }
        
        // Bitmask DP over subsets of N rabbits (N<=16)
        // score[mask] = total score for putting all rabbits in mask into one group
        long[] score = new long[1 << N];
        for (int mask = 1; mask < (1 << N); mask++) {
            // find lowest set bit rabbit i, add its score with all others in mask
            int i = Integer.numberOfTrailingZeros(mask);
            int rest = mask ^ (1 << i);
            score[mask] = score[rest];
            for (int j = 0; j < N; j++) {
                if ((rest & (1 << j)) != 0) score[mask] += a[i][j];
            }
        }
        // dp[mask] = max total score partitioning rabbits in mask into optimal groups
        long[] dp = new long[1 << N];
        for (int mask = 1; mask < (1 << N); mask++) {
            // try all non-empty subsets of mask containing the lowest-bit rabbit
            int lowest = mask & (-mask);
            for (int sub = mask; sub > 0; sub = (sub - 1) & mask) {
                if ((sub & lowest) != 0) {
                    dp[mask] = Math.max(dp[mask], score[sub] + dp[mask ^ sub]);
                }
            }
        }
        System.out.println(dp[(1 << N) - 1]);
    }
}