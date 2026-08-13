package com.codeforces;
import java.util.*;
import java.io.*;

public class A_Greg_and_Array {
    static Scanner sc = new Scanner(System.in);public static void solve() {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        long[] A = new long[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextLong();
        }
        int[] l = new int[m];
        int[] r = new int[m];
        long[] d = new long[m];
        for (int i = 0; i < m; i++) {
            l[i] = sc.nextInt() - 1; // 0-indexed
            r[i] = sc.nextInt() - 1; // 0-indexed
            d[i] = sc.nextLong();
        }

        long[] opDiff = new long[m + 1];
        for (int i = 0; i < k; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            opDiff[x]++;
            if (y + 1 < m) {
                opDiff[y + 1]--;
            }
        }

        long[] freq = new long[m];
        long runningOps = 0;
        for (int i = 0; i < m; i++) {
            runningOps += opDiff[i];
            freq[i] = runningOps;
        }

        long[] arrDiff = new long[n + 1];
        for (int i = 0; i < m; i++) {
            long add = d[i] * freq[i];
            if (add == 0) continue;
            arrDiff[l[i]] += add;
            if (r[i] + 1 < n) {
                arrDiff[r[i] + 1] -= add;
            }
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arrDiff[i];
            A[i] += sum;
        }

        printArray(A);
    }
    public static void printArray(long[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (i > 0)
                sb.append(' ');
            sb.append(arr[i]);
        }
        System.out.println(sb);
    }
}