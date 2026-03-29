package CodeChef;
import java.io.*;
import java.util.*;
public class Codechef {
    static final FastScanner fs = new FastScanner(System.in);
    static final StringBuilder sb = new StringBuilder();
    static final Random RNG = new Random();
    static final int MOD = 1_000_000_007;
    static final int MOD2 = 998244353;
    static final long INF = (long) 4e18;
    public static void main(String[] args) throws Exception {
        int t = fs.nextInt();
        while (t-- > 0) solve();
        System.out.print(sb);
    }
    static void solve() throws Exception {
        // write here aritra ... 
    }

    static String next() throws IOException { return fs.next(); }
    static int nextInt() throws IOException { return fs.nextInt(); }
    static long nextLong() throws IOException { return fs.nextLong(); }
    static double nextDouble() throws IOException { return fs.nextDouble(); }
    static char nextChar() throws IOException { return fs.nextChar(); }
    static int[] nextIntArray(int n) throws IOException { int[] a = new int[n]; for (int i = 0; i < n; i++) a[i] = fs.nextInt(); return a; }
    static long[] nextLongArray(int n) throws IOException { long[] a = new long[n]; for (int i = 0; i < n; i++) a[i] = fs.nextLong(); return a; }
    static String[] nextStringArray(int n) throws IOException { String[] a = new String[n]; for (int i = 0; i < n; i++) a[i] = fs.next(); return a; }
    static int[][] nextIntMatrix(int n, int m) throws IOException { int[][] a = new int[n][m]; for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) a[i][j] = fs.nextInt(); return a; }
    static long[][] nextLongMatrix(int n, int m) throws IOException { long[][] a = new long[n][m]; for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) a[i][j] = fs.nextLong(); return a; }
    static void print(int x) { sb.append(x).append('\n'); }
    static void print(long x) { sb.append(x).append('\n'); }
    static void print(String x) { sb.append(x).append('\n'); }
    static void yes() { sb.append("YES\n"); }
    static void no() { sb.append("NO\n"); }
    static void yesNo(boolean ok) { sb.append(ok ? "YES\n" : "NO\n"); }
    static void printArray(int[] a) { for (int i = 0; i < a.length; i++) { if (i > 0) sb.append(' '); sb.append(a[i]); } sb.append('\n'); }
    static void printArray(long[] a) { for (int i = 0; i < a.length; i++) { if (i > 0) sb.append(' '); sb.append(a[i]); } sb.append('\n'); }
    static void printList(List<?> a) { for (int i = 0; i < a.size(); i++) { if (i > 0) sb.append(' '); sb.append(a.get(i)); } sb.append('\n'); }
    static long gcd(long a, long b) { a = Math.abs(a); b = Math.abs(b); while (b != 0) { long t = a % b; a = b; b = t; } return a; }
    static long lcm(long a, long b) { return a / gcd(a, b) * b; }
    static long modPow(long a, long e, long mod) { long r = 1 % mod; a %= mod; while (e > 0) { if ((e & 1) == 1) r = r * a % mod; a = a * a % mod; e >>= 1; } return r; }
    static long modInverse(long a, long mod) { return modPow(a, mod - 2, mod); }
    static long ceilDiv(long a, long b) { return a >= 0 ? (a + b - 1) / b : a / b; }
    static void sort(int[] a) { Arrays.sort(a); }
    static void sort(long[] a) { Arrays.sort(a); }
    static void reverse(int[] a) { for (int l = 0, r = a.length - 1; l < r; l++, r--) { int t = a[l]; a[l] = a[r]; a[r] = t; } }
    static void reverse(long[] a) { for (int l = 0, r = a.length - 1; l < r; l++, r--) { long t = a[l]; a[l] = a[r]; a[r] = t; } }
    static void shuffleSort(int[] a) { for (int i = a.length - 1; i > 0; i--) { int j = RNG.nextInt(i + 1), t = a[i]; a[i] = a[j]; a[j] = t; } Arrays.sort(a); }
    static void shuffleSort(long[] a) { for (int i = a.length - 1; i > 0; i--) { int j = RNG.nextInt(i + 1); long t = a[i]; a[i] = a[j]; a[j] = t; } Arrays.sort(a); }
    static long sum(int[] a) { long r = 0; for (int x : a) r += x; return r; }
    static long sum(long[] a) { long r = 0; for (long x : a) r += x; return r; }
    static int min(int[] a) { int r = Integer.MAX_VALUE; for (int x : a) r = Math.min(r, x); return r; }
    static int max(int[] a) { int r = Integer.MIN_VALUE; for (int x : a) r = Math.max(r, x); return r; }
    static long min(long[] a) { long r = Long.MAX_VALUE; for (long x : a) r = Math.min(r, x); return r; }
    static long max(long[] a) { long r = Long.MIN_VALUE; for (long x : a) r = Math.max(r, x); return r; }
    static int lowerBound(int[] a, int x) { int l = 0, r = a.length; while (l < r) { int m = (l + r) >>> 1; if (a[m] < x) l = m + 1; else r = m; } return l; }
    static int upperBound(int[] a, int x) { int l = 0, r = a.length; while (l < r) { int m = (l + r) >>> 1; if (a[m] <= x) l = m + 1; else r = m; } return l; }
    static int lowerBound(long[] a, long x) { int l = 0, r = a.length; while (l < r) { int m = (l + r) >>> 1; if (a[m] < x) l = m + 1; else r = m; } return l; }
    static int upperBound(long[] a, long x) { int l = 0, r = a.length; while (l < r) { int m = (l + r) >>> 1; if (a[m] <= x) l = m + 1; else r = m; } return l; }
    static void debug(Object... a) { System.err.println(Arrays.deepToString(a)); }
    static final class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        FastScanner(InputStream is) { in = is; }
        private int read() throws IOException { if (ptr >= len) { len = in.read(buffer); ptr = 0; if (len <= 0) return -1; } return buffer[ptr++]; }
        String next() throws IOException { StringBuilder s = new StringBuilder(); int c; do c = read(); while (c <= ' ' && c != -1); while (c > ' ') { s.append((char) c); c = read(); } return s.toString(); }
        int nextInt() throws IOException { int c; do c = read(); while (c <= ' ' && c != -1); int sign = 1; if (c == '-') { sign = -1; c = read(); } int val = 0; while (c > ' ') { val = val * 10 + c - '0'; c = read(); } return val * sign; }
        long nextLong() throws IOException { int c; do c = read(); while (c <= ' ' && c != -1); int sign = 1; if (c == '-') { sign = -1; c = read(); } long val = 0; while (c > ' ') { val = val * 10 + c - '0'; c = read(); } return sign == 1 ? val : -val; }
        double nextDouble() throws IOException { return Double.parseDouble(next()); }
        char nextChar() throws IOException { return next().charAt(0); }
    }
    static final class DSU {
        int[] parent, size;
        DSU(int n) { parent = new int[n]; size = new int[n]; for (int i = 0; i < n; i++) { parent[i] = i; size[i] = 1; } }
        int find(int x) { while (parent[x] != x) { parent[x] = parent[parent[x]]; x = parent[x]; } return x; }
        boolean union(int a, int b) { a = find(a); b = find(b); if (a == b) return false; if (size[a] < size[b]) { int t = a; a = b; b = t; } parent[b] = a; size[a] += size[b]; return true; }
        int size(int x) { return size[find(x)]; }
    }
    static final class Fenwick {
        int n; long[] bit;
        Fenwick(int n) { this.n = n; bit = new long[n + 1]; }
        void add(int idx, long delta) { for (idx++; idx <= n; idx += idx & -idx) bit[idx] += delta; }
        long sum(int idx) { long r = 0; for (idx++; idx > 0; idx -= idx & -idx) r += bit[idx]; return r; }
        long rangeSum(int l, int r) { return l > r ? 0 : sum(r) - (l == 0 ? 0 : sum(l - 1)); }
    }
}
