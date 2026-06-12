package com.aritra.contests.atcoder.educationaldp.tpermutation;

import java.io.*;
import java.util.*;

public class T_Permutation {
    static final long MOD = 1_000_000_007L;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine().trim());
        String s = br.readLine().trim();
        
        // dp[i][j] = number of valid permutations of length i where the last element
        // is the j-th smallest among the i elements not yet fixed (rank 1..i)
        // Transition:
        //   s[i-1] == '<': dp[i+1][j] += dp[i][1..j-1]  (new element is larger)
        //   s[i-1] == '>': dp[i+1][j] += dp[i][j..i]    (new element is smaller)
        // Use prefix sums for O(N^2)
        long[] dp = new long[N + 1];
        for (int j = 1; j <= N; j++) dp[j] = 1; // base: N=1, all ranks are valid
        // Actually start from length 1
        // dp[j] for current length, j in [1..length]
        // We build up from length 1 to N
        // Reset: length=1, only rank 1
        Arrays.fill(dp, 0);
        dp[1] = 1;
        for (int i = 1; i < N; i++) {
            long[] ndp = new long[N + 1];
            // prefix sum of dp[1..i]
            long[] prefix = new long[i + 2];
            for (int j = 1; j <= i; j++) prefix[j] = (prefix[j - 1] + dp[j]) % MOD;
            if (s.charAt(i - 1) == '<') {
                // new last element is rank j in i+1 elements; previous last was any rank < j
                for (int j = 2; j <= i + 1; j++)
                    ndp[j] = prefix[j - 1];
            } else {
                // new last element is rank j; previous last was any rank >= j (in old numbering)
                // old rank k maps to new rank k if k < j, else k+1
                // previous last rank k where k >= j (old) => sum dp[j..i]
                for (int j = 1; j <= i; j++)
                    ndp[j] = (prefix[i] - prefix[j - 1] + MOD) % MOD;
            }
            dp = ndp;
        }
        long ans = 0;
        for (int j = 1; j <= N; j++) ans = (ans + dp[j]) % MOD;
        System.out.println(ans);
    }
}