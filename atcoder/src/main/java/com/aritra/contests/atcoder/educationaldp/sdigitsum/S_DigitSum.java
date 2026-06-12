package com.aritra.contests.atcoder.educationaldp.sdigitsum;

import java.io.*;
import java.util.*;

public class S_DigitSum {
    static final long MOD = 1_000_000_007L;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String K = br.readLine().trim();
        int D = Integer.parseInt(br.readLine().trim());
        
        // Digit DP on string K
        // dp[r] = count of numbers seen so far with digit sum ≡ r (mod D), tight constraint
        // State: (position, remainder, tight)
        int len = K.length();
        // dp[tight][rem]
        long[][] dp = new long[2][D];
        dp[1][0] = 1; // start: empty prefix, tight=true, rem=0
        for (int pos = 0; pos < len; pos++) {
            long[][] ndp = new long[2][D];
            for (int tight = 0; tight <= 1; tight++) {
                for (int rem = 0; rem < D; rem++) {
                    if (dp[tight][rem] == 0) continue;
                    int limit = (tight == 1) ? (K.charAt(pos) - '0') : 9;
                    for (int d = 0; d <= limit; d++) {
                        int nRem = (rem + d) % D;
                        int nTight = (tight == 1 && d == limit) ? 1 : 0;
                        ndp[nTight][nRem] = (ndp[nTight][nRem] + dp[tight][rem]) % MOD;
                    }
                }
            }
            dp = ndp;
        }
        // sum counts for rem==0, but subtract 1 for the number 0 (not in range [1,K])
        long ans = (dp[0][0] + dp[1][0] - 1 + MOD) % MOD;
        System.out.println(ans);
    }
}