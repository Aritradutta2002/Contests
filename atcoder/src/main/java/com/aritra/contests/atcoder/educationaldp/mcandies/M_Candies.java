package com.aritra.contests.atcoder.educationaldp.mcandies;

import java.io.*;
import java.util.*;

public class M_Candies {
    static final long MOD = 1_000_000_007L;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] a = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        
        // dp[i][j] = ways to give j total candies to first i children
        // Use prefix sum to handle upper bound efficiently: O(N*K)
        long[] dp = new long[K + 1];
        dp[0] = 1;
        for (int i = 0; i < N; i++) {
            // prefix sum of current dp
            long[] prefix = new long[K + 2];
            for (int j = 0; j <= K; j++)
                prefix[j + 1] = (prefix[j] + dp[j]) % MOD;
            long[] ndp = new long[K + 1];
            for (int j = 0; j <= K; j++) {
                // sum dp[j - a[i] .. j] = prefix[j+1] - prefix[max(0, j-a[i])]
                int lo = Math.max(0, j - a[i]);
                ndp[j] = (prefix[j + 1] - prefix[lo] + MOD) % MOD;
            }
            dp = ndp;
        }
        System.out.println(dp[K]);
    }
}