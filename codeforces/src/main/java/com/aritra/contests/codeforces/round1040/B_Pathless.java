package com.aritra.contests.codeforces.round1040;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

public class B_Pathless {
    public static void solve(FastIO sc) {
        int n = sc.nextInt();
        int s = sc.nextInt();
        int c0 = 0, c1 = 0, c2 = 0;
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            if (val == 0) c0++;
            else if (val == 1) c1++;
            else c2++;
        }

        long s_total = (long) c1 + (long)c2 * 2;

        if (s < s_total) {
            printBobWinArrangement(sc, c0, c1, c2);
            return;
        }

        long k = s - s_total;

if (k > 1 && k % 2 != 0) {

            printBobWinArrangement(sc, c0, c1, c2);
        } else {

            sc.println(-1);
        }
    }
    private static void printBobWinArrangement(FastIO sc, int c0, int c1, int c2) {
        for (int i = 0; i < c0; i++) sc.print("0 ");
        for (int i = 0; i < c2; i++) sc.print("2 ");
        for (int i = 0; i < c1; i++) sc.print("1 ");
        sc.println();
    }
    static class FastIO extends PrintWriter {
        private final InputStream stream;
        private final byte[] buf = new byte[1 << 16];
        private int curChar, numChars;

        public FastIO() {
            this(System.in, System.out);
        }
    public FastIO(InputStream i, OutputStream o) {
            super(o);
            stream = i;
        }
    public FastIO(String i, String o) throws IOException {
            super(new FileWriter(o));
            stream = new FileInputStream(i);
        }
    private int nextByte() {
            if (numChars == -1) throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars == -1) return -1;
            }
            return buf[curChar++];
        }
    public String nextLine() {
            int c;
            do {
                c = nextByte();
            } while (c <= '\n');
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = nextByte();
            } while (c > '\n');
            return res.toString();
        }
    public String next() {
            int c;
            do {
                c = nextByte();
            } while (c <= ' ');
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = nextByte();
            } while (c > ' ');
            return res.toString();
        }
    public int nextInt() {
            int c;
            do {
                c = nextByte();
            } while (c <= ' ');
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = nextByte();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') throw new InputMismatchException();
                res = 10 * res + c - '0';
                c = nextByte();
            } while (c > ' ');
            return res * sgn;
        }
    public long nextLong() {
            int c;
            do {
                c = nextByte();
            } while (c <= ' ');
            long sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = nextByte();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9') throw new InputMismatchException();
                res = 10 * res + c - '0';
                c = nextByte();
            } while (c > ' ');
            return res * sgn;
        }
    public double nextDouble() {
            return Double.parseDouble(next());
        }
    public int[] readIntArray(int n) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }
    }
}

