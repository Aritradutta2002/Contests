package com.aritra.contests.atcoder.educationaldp.jsushi;

import java.io.*;
import java.util.*;

public class J_Sushi {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine().trim());
        String[] parts = br.readLine().trim().split("\\s+");
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(parts[i]);
        }
        
        // Count dishes by number of sushi pieces
        // cnt[k] = number of dishes with k pieces (k=1,2,3)
        int[] cnt = new int[4];
        for (int x : a) cnt[x]++;
        // State: (c1, c2, c3) = number of dishes with 1, 2, 3 pieces remaining
        // E[c1][c2][c3] = expected rolls from this state
        // Let n1=cnt[1], n2=cnt[2], n3=cnt[3], total dishes = N
        // Recurrence (by linearity of expectation):
        // E = 1 + (N - c1 - c2 - c3)/N * E  (rolls that hit empty dish, no change)
        //       + c1/N * E[c1-1][c2][c3]
        //       + c2/N * E[c1][c2-1+1... wait
        // Simplify: let t = c1+c2+c3 (total non-empty dishes)
        // E[c1,c2,c3] = N/t + c1/t*E[c1-1,c2,c3] + c2/t*E[c1+1,c2-1,c3] + c3/t*E[c1,c2+1,c3-1]
        int n1 = cnt[1], n2 = cnt[2], n3 = cnt[3];
        double[][][] E = new double[n1 + n2 + n3 + 1][n2 + n3 + 1][n3 + 1];
        // fill in increasing order of total dishes remaining (c1+c2+c3)
        // base: E[0][0][0] = 0
        for (int c3 = 0; c3 <= n3; c3++)
            for (int c2 = 0; c2 <= n2 + (n3 - c3); c2++)
                for (int c1 = 0; c1 <= n1 + (n2 - c2) + (n3 - c3); c1++) {
                    if (c1 == 0 && c2 == 0 && c3 == 0) continue;
                    double t = c1 + c2 + c3;
                    double val = (double) N / t;
                    if (c1 > 0) val += (c1 / t) * E[c1 - 1][c2][c3];
                    if (c2 > 0) val += (c2 / t) * E[c1 + 1][c2 - 1][c3];
                    if (c3 > 0) val += (c3 / t) * E[c1][c2 + 1][c3 - 1];
                    E[c1][c2][c3] = val;
                }
        System.out.printf("%.12f%n", E[n1][n2][n3]);
    }
}