package com.aritra.contests.leetcode;
import java.util.*;
@SuppressWarnings("unused")
public class LC2338_Count_The_Number_Of_Ideal_Arrays {
    public static int idealArrays(int n, int maxValue) {
        final int MOD = 1_000_000_007;
        int maxLen = 14; // max chain length is log2(maxValue)

        // f[v][j] = number of strictly increasing divisor chains of length j ending at v
        long[][] f = new long[maxValue + 1][maxLen + 1];
        for (int v = 1; v <= maxValue; v++) {
            f[v][1] = 1;
        }
        for (int j = 2; j <= maxLen; j++) {
            for (int v = 1; v <= maxValue; v++) {
                // iterate over multiples of v
                for (int mult = 2 * v; mult <= maxValue; mult += v) {
                    f[mult][j] = (f[mult][j] + f[v][j - 1]) % MOD;
                }
            }
        }

        // Precompute C(n-1, k) for k = 0..maxLen
        long[] comb = new long[maxLen + 1];
        comb[0] = 1;
        for (int k = 1; k <= Math.min(maxLen, n - 1); k++) {
            comb[k] = comb[k - 1] % MOD * ((n - k) % MOD) % MOD * modInverse(k, MOD) % MOD;
        }

        long ans = 0;
        for (int v = 1; v <= maxValue; v++) {
            for (int j = 1; j <= maxLen; j++) {
                if (f[v][j] == 0) continue;
                if (j - 1 > n - 1) continue;
                ans = (ans + f[v][j] % MOD * comb[j - 1] % MOD) % MOD;
            }
        }
        return (int) ans;
    }
    private static long modInverse(long a, int mod) {
        return modPow(a, mod - 2, mod);
    }
    private static long modPow(long base, long exp, int mod) {
        long result = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) result = result * base % mod;
            exp >>= 1;
            base = base * base % mod;
        }
        return result;
    }
}
