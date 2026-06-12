package com.aritra.contests.atcoder.educationaldp.afrog1;
import java.io.*;
import java.util.*;

public class A_Frog1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine().trim());
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
            if (dp[i - 1] != Long.MAX_VALUE)
                dp[i] = Math.min(dp[i], dp[i - 1] + Math.abs(h[i] - h[i - 1]));
            if (i >= 2 && dp[i - 2] != Long.MAX_VALUE)
                dp[i] = Math.min(dp[i], dp[i - 2] + Math.abs(h[i] - h[i - 2]));
        }
        System.out.println(dp[N - 1]);
    }
}