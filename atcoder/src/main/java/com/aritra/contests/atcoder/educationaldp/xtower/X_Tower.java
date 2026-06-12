package com.aritra.contests.atcoder.educationaldp.xtower;

import java.io.*;
import java.util.*;

public class X_Tower {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine().trim());
        
        int[] w = new int[N];
        int[] s = new int[N];
        long[] v = new long[N];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            s[i] = Integer.parseInt(st.nextToken());
            v[i] = Long.parseLong(st.nextToken());
        }
        
        // Key insight: sort blocks by w[i]+s[i] ascending; optimal order is proven
        // by exchange argument. Then standard 0/1 knapsack.
        // dp[j] = max value achievable with weight sum j (j = total weight above current block)
        // Capacity for block i: it can be placed only if weight above <= s[i],
        //  i.e., dp index <= s[i]. Max useful capacity = max(w[i]+s[i]).
        Integer[] idx = new Integer[N];
        for (int i = 0; i < N; i++) idx[i] = i;
        Arrays.sort(idx, (x, y) -> (w[x] + s[x]) - (w[y] + s[y]));
        int maxCap = 0;
        for (int i = 0; i < N; i++) maxCap = Math.max(maxCap, w[i] + s[i]);
        long[] dp = new long[maxCap + 1]; // dp[j] = max value, j = weight from above
        // "above" = total weight of blocks placed ABOVE current; blocks added bottom-up
        // When we process sorted blocks bottom to top, a block at current level has
        // weight j above it iff we put j weight above.
        // Standard knapsack over capacity = weight above (iterate backwards)
        for (int ii = 0; ii < N; ii++) {
            int i = idx[ii];
            // block i can only be included if weight above <= s[i]
            for (int j = s[i]; j >= 0; j--) {
                if (j + w[i] <= maxCap)
                    dp[j + w[i]] = Math.max(dp[j + w[i]], dp[j] + v[i]);
            }
        }
        long ans = 0;
        for (long x : dp) ans = Math.max(ans, x);
        System.out.println(ans);
    }
}