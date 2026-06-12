package com.aritra.contests.atcoder.educationaldp.ygrid2;

import java.io.*;
import java.util.*;

public class Y_Grid2 {
    static final long MOD = 1_000_000_007L;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        int[] r = new int[N];
        int[] c = new int[N];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            r[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());
        }
        
        // Inclusion-exclusion over the N wall squares
        // Sort walls by (row, col). Let f[i] = paths from (1,1) to wall i NOT passing through any wall j<i.
        // dp[i] = C(r[i]+c[i]-2, r[i]-1) - sum_{j<i, j can reach i} dp[j]*C(r[i]-r[j]+c[i]-c[j], r[i]-r[j])
        // Answer = C(H+W-2, H-1) - sum over walls i that can reach (H,W) of dp[i]*C(H-r[i]+W-c[i], H-r[i])
        // Precompute factorials and inverse factorials
        int MAXN = H + W + 10;
        long[] fact = new long[MAXN];
        long[] inv_fact = new long[MAXN];
        fact[0] = 1;
        for (int i = 1; i < MAXN; i++) fact[i] = fact[i - 1] * i % MOD;
        inv_fact[MAXN - 1] = modPow(fact[MAXN - 1], MOD - 2, MOD);
        for (int i = MAXN - 2; i >= 0; i--) inv_fact[i] = inv_fact[i + 1] * (i + 1) % MOD;
        // Sort walls
        int[] wr = new int[N + 1], wc = new int[N + 1];
        for (int i = 0; i < N; i++) { wr[i] = r[i]; wc[i] = c[i]; }
        wr[N] = H; wc[N] = W; // add destination as a pseudo-wall
        Integer[] order = new Integer[N + 1];
        for (int i = 0; i <= N; i++) order[i] = i;
        Arrays.sort(order, (x, y) -> wr[x] != wr[y] ? wr[x] - wr[y] : wc[x] - wc[y]);
        // dp[i] in order: bad paths ending at wall order[i]
        long[] dp = new long[N + 1];
        for (int ii = 0; ii <= N; ii++) {
            int i = order[ii];
            dp[ii] = comb(fact, inv_fact, wr[i] + wc[i] - 2, wr[i] - 1);
            for (int jj = 0; jj < ii; jj++) {
                int j = order[jj];
                if (wr[j] <= wr[i] && wc[j] <= wc[i]) {
                    dp[ii] = (dp[ii] - dp[jj] * comb(fact, inv_fact,
                        (wr[i]-wr[j])+(wc[i]-wc[j]), wr[i]-wr[j]) % MOD + MOD) % MOD;
                }
            }
        }
        // answer is dp[index of (H,W)] = last in sorted order if (H,W) is last
        // Actually answer = dp[ii where order[ii]== N]
        int ansIdx = 0;
        for (int ii = 0; ii <= N; ii++) if (order[ii] == N) { ansIdx = ii; break; }
        System.out.println(dp[ansIdx]);
    }

    static long comb(long[] fact, long[] inv_fact, int n, int k) {
        if (k < 0 || k > n) return 0;
        return fact[n] * inv_fact[k] % MOD * inv_fact[n - k] % MOD;
    }

    static long modPow(long base, long exp, long mod) {
        long result = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) result = result * base % mod;
            base = base * base % mod;
            exp >>= 1;
        }
        return result;
    }
}