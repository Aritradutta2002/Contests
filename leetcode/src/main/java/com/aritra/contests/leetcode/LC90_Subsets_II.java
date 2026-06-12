package com.aritra.contests.leetcode;
/*
 * Author  : Aritra Dutta
 * Target  : Codeforces Expert / CSES
 * Created : 21.02.2026 20:49
 */
import java.io.*;
import java.util.*;

public class LC90_Subsets_II {
    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;

    static final int MOD = 1_000_000_007;
    static final int MOD2 = 998244353;
    static final long INF = (long) 1e18;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new BufferedOutputStream(System.out));

        int n = nextInt();
        int[] nums = nextIntArray(n);

        subsetsWithDup(nums);

        out.flush();
        out.close();
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        backtrackWithDup(nums, 0, new ArrayList<>(), ans);

        return ans;
    }

    public static void backtrackWithDup(int[] nums, int start, List<Integer> temp, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1])
                continue;
            temp.add(nums[i]);
            backtrackWithDup(nums, start + 1, temp, ans);
            temp.remove(temp.size() - 1);
        }
    }




    
    // ========== FAST I/O ==========
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

    // ========== ARRAY INPUT ==========
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

    // ========== ARRAY OUTPUT ==========
    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            out.print(arr[i]);
            if (i < arr.length - 1)
                out.print(" ");
        }
        out.println();
    }

    static void printArray(long[] arr) {
        for (int i = 0; i < arr.length; i++) {
            out.print(arr[i]);
            if (i < arr.length - 1)
                out.print(" ");
        }
        out.println();
    }

    static void printArray(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            out.print(arr[i]);
            if (i < arr.length - 1)
                out.print(" ");
        }
        out.println();
    }

    static void yes() {
        out.println("YES");
    }

    static void no() {
        out.println("NO");
    }

    // ========== UTILITY ==========
    static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    static long power(long x, long y, long mod) {
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
        return power(a, mod - 2, mod);
    }

    static void shuffleSort(int[] arr) {
        Random r = new Random();
        for (int i = arr.length - 1; i > 0; i--) {
            int j = r.nextInt(i + 1);
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }
        Arrays.sort(arr);
    }

    static void shuffleSort(long[] arr) {
        Random r = new Random();
        for (int i = arr.length - 1; i > 0; i--) {
            int j = r.nextInt(i + 1);
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