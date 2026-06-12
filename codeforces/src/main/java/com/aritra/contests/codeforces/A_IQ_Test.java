package com.aritra.contests.codeforces;
/*
 * Author  : Aritra Dutta
 * Target  : Codeforces Expert / CSES
 * Created : 29.03.2026
 */
import java.io.*;
import java.util.*;

public class A_IQ_Test {
    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new BufferedOutputStream(System.out));

        solve();

        out.flush();
        out.close();
    }

    static void solve() throws IOException {
        int n = nextInt();
        int[] arr = new int[n];

        int evenCount = 0;
        int oddCount = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = nextInt();
            if ((arr[i] & 1) == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        boolean needOddIndex = evenCount > oddCount;
        for (int i = 0; i < n; i++) {
            boolean isOdd = (arr[i] & 1) == 1;
            if (isOdd == needOddIndex) {
                out.println(i + 1);
                return;
            }
        }
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }
}