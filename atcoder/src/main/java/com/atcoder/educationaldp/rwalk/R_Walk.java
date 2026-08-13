package com.atcoder.educationaldp.rwalk;

import java.io.*;
import java.util.*;

public class R_Walk {
    static final long MOD = 1_000_000_007L;
    
    static long[][] matMul(long[][] A, long[][] B, int n) {
        long[][] C = new long[n][n];
        for (int i = 0; i < n; i++)
            for (int k = 0; k < n; k++) {
                if (A[i][k] == 0) continue;
                for (int j = 0; j < n; j++)
                    C[i][j] = (C[i][j] + A[i][k] * B[k][j]) % MOD;
            }
        return C;
    }
    static long[][] matPow(long[][] A, long exp, int n) {
        long[][] result = new long[n][n];
        for (int i = 0; i < n; i++) result[i][i] = 1; // identity
        while (exp > 0) {
            if ((exp & 1) == 1) result = matMul(result, A, n);
            A = matMul(A, A, n);
            exp >>= 1;
        }
        return result;
    }
}