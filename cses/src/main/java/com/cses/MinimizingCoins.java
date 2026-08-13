package com.cses;
/*
 * Author  : Aritra Dutta
 * Target  : Codeforces Expert / CSES
 * Created : 06.03.2026 00:17
 */

/*
 * Problem : Minimizing Coins
 * Link    : https://cses.fi/problemset/task/1634
 *
 * Description:
 *   Consider a money system consisting of n coins. Each coin has a positive
 *   integer value. Your task is to produce a sum of money x using the
 *   available coins in such a way that the number of coins is minimal.
 *   For example, if the coins are {1, 5, 7} and the desired sum is 11,
 *   an optimal solution is 5 + 5 + 1 which requires 3 coins.
 *
 * Input:
 *   The first input line has two integers n and x: the number of coins
 *   and the desired sum of money.
 *   The second line has n distinct integers c1, c2, ..., cn: the value
 *   of each coin.
 *
 * Output:
 *   Print one integer: the minimum number of coins.
 *   If it is not possible to produce the desired sum, print -1.
 *
 * Constraints:
 *   1 <= n <= 100
 *   1 <= x <= 10^6
 *   1 <= c_i <= 10^6
 *
 * Example:
 *   Input:  3 11 \n 1 5 7
 *   Output: 3
 */

import java.io.*;
import java.util.*;

public class MinimizingCoins {
    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static final Random RNG = new Random();

    static final int MOD = 1_000_000_007;
    static final int MOD2 = 998244353;
    static final long INF = (long) 1e18;
    static int solve(int n, int x, int[] coins, int[] dp) {
        if (n == 0)
            return 0;
        dp[0] = 0;
        for (int i = 1; i <= x; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }

            }
        }
        return dp[x] != MOD ? dp[x] : -1;
    }
    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }
    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }
    static long nextLong() throws IOException {
        return Long.parseLong(next());
    }
    static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
    static String nextLine() throws IOException {
        return br.readLine();
    }
    static char nextChar() throws IOException {
        return next().charAt(0);
    }
    static int[] nextIntArray(int n) throws IOException {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = nextInt();
        return arr;
    }
    static long[] nextLongArray(int n) throws IOException {
        long[] arr = new long[n];
        for (int i = 0; i < n; i++)
            arr[i] = nextLong();
        return arr;
    }
    static String[] nextStringArray(int n) throws IOException {
        String[] arr = new String[n];
        for (int i = 0; i < n; i++)
            arr[i] = next();
        return arr;
    }
    static double[] nextDoubleArray(int n) throws IOException {
        double[] arr = new double[n];
        for (int i = 0; i < n; i++)
            arr[i] = nextDouble();
        return arr;
    }
    static int[][] nextInt2DArray(int rows, int cols) throws IOException {
        int[][] arr = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                arr[i][j] = nextInt();
        return arr;
    }
    static void printArray(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (i > 0)
                sb.append(' ');
            sb.append(arr[i]);
        }
        out.println(sb);
    }
    static void printArray(long[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (i > 0)
                sb.append(' ');
            sb.append(arr[i]);
        }
        out.println(sb);
    }
    static void printArray(String[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (i > 0)
                sb.append(' ');
            sb.append(arr[i]);
        }
        out.println(sb);
    }
    static void yes() {
        out.println("YES");
    }
    static void no() {
        out.println("NO");
    }
    static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }
    static long modPow(long x, long y, long mod) {
        long res = 1;
        x %= mod;
        while (y > 0) {
            if ((y & 1) == 1)
                res = res * x % mod;
            x = x * x % mod;
            y >>= 1;
        }
        return res;
    }
    static long modInv(long a, long mod) {
        return modPow(a, mod - 2, mod);
    }
    static void shuffleSort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            int j = RNG.nextInt(i + 1);
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }
        Arrays.sort(arr);
    }
    static void shuffleSort(long[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            int j = RNG.nextInt(i + 1);
            long t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }
        Arrays.sort(arr);
    }
    static long sumArray(int[] arr) {
        long sum = 0;
        for (int val : arr)
            sum += val;
        return sum;
    }
    static long sumArray(long[] arr) {
        long sum = 0;
        for (long val : arr)
            sum += val;
        return sum;
    }
    static int minArray(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int val : arr)
            min = Math.min(min, val);
        return min;
    }
    static int maxArray(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int val : arr)
            max = Math.max(max, val);
        return max;
    }
    static int lowerBound(int[] arr, int key) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < key)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
    static int upperBound(int[] arr, int key) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= key)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
    static void debug(Object... obj) {
        System.err.println(Arrays.deepToString(obj));
    }
}
