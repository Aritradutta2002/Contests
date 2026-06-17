package com.aritra.contests.atcoder.educationaldp.ygrid2;

import java.io.*;
import java.util.*;

public class Y_Grid2 {
    static final long MOD = 1_000_000_007L;
    
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