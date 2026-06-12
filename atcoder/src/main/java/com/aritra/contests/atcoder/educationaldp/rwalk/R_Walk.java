package com.aritra.contests.atcoder.educationaldp.rwalk;

import java.io.*;
import java.util.*;

public class R_Walk {
    static final long MOD = 1_000_000_007L;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        
        long[][] a = new long[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                a[i][j] = Long.parseLong(st.nextToken());
            }
        }
        
        // Matrix exponentiation: count paths of length K = sum of A^K entries
        long[][] result = matPow(a, K, N);
        long ans = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                ans = (ans + result[i][j]) % MOD;
        System.out.println(ans);
    }

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