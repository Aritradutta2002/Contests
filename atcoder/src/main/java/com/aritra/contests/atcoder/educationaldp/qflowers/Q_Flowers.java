package com.aritra.contests.atcoder.educationaldp.qflowers;

import java.io.*;
import java.util.*;

public class Q_Flowers {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine().trim());
        String[] hStr = br.readLine().trim().split("\\s+");
        String[] aStr = br.readLine().trim().split("\\s+");
        
        int[] h = new int[N];
        long[] a = new long[N];
        for (int i = 0; i < N; i++) {
            h[i] = Integer.parseInt(hStr[i]);
            a[i] = Long.parseLong(aStr[i]);
        }
        
        // Weighted LIS where the ordering is by height (all distinct 1..N)
        // dp[i] = max beauty of increasing-height subsequence ending at flower i
        // Use BIT/Fenwick indexed by height to query max dp in height range [1..h[i]-1]
        long[] bit = new long[N + 1]; // BIT for max query
        long[] dp = new long[N];
        for (int i = 0; i < N; i++) {
            // query max dp value for heights < h[i]
            long best = queryMax(bit, h[i] - 1);
            dp[i] = best + a[i];
            updateMax(bit, h[i], dp[i], N);
        }
        long ans = 0;
        for (long x : dp) ans = Math.max(ans, x);
        System.out.println(ans);
    }

    static long queryMax(long[] bit, int i) {
        long res = 0;
        for (; i > 0; i -= i & (-i)) res = Math.max(res, bit[i]);
        return res;
    }

    static void updateMax(long[] bit, int i, long val, int n) {
        for (; i <= n; i += i & (-i)) bit[i] = Math.max(bit[i], val);
    }
}