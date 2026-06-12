package com.aritra.contests.atcoder.educationaldp.ldeque;

import java.io.*;
import java.util.*;

public class L_Deque {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine().trim());
        String[] parts = br.readLine().trim().split("\\s+");
        long[] a = new long[N];
        for (int i = 0; i < N; i++) {
            a[i] = Long.parseLong(parts[i]);
        }
        
        // dp[i][j] = score difference (current player - other player) for subarray [i..j]
        long[][] dp = new long[N][N];
        for (int i = 0; i < N; i++) dp[i][i] = a[i];
        for (int len = 2; len <= N; len++) {
            for (int i = 0; i <= N - len; i++) {
                int j = i + len - 1;
                dp[i][j] = Math.max(a[i] - dp[i + 1][j], a[j] - dp[i][j - 1]);
            }
        }
        System.out.println(dp[0][N - 1]);
    }
}