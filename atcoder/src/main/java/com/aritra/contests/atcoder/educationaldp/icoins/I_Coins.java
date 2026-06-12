package com.aritra.contests.atcoder.educationaldp.icoins;

import java.io.*;
import java.util.*;

public class I_Coins {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine().trim());
        double[] p = new double[N];
        
        String[] parts = br.readLine().trim().split("\\s+");
        for (int i = 0; i < N; i++) {
            p[i] = Double.parseDouble(parts[i]);
        }
        
        // dp[i][j] = probability that first i coins give exactly j heads
        double[][] dp = new double[N + 1][N + 1];
        dp[0][0] = 1.0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[i][j] == 0) continue;
                dp[i + 1][j + 1] += dp[i][j] * p[i];       // heads
                dp[i + 1][j]     += dp[i][j] * (1 - p[i]); // tails
            }
        }
        double ans = 0;
        for (int j = (N + 1) / 2; j <= N; j++) ans += dp[N][j];
        System.out.printf("%.12f%n", ans);
    }
}