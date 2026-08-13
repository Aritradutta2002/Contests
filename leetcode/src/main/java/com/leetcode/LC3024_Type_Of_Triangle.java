package com.leetcode;

import java.io.*;
import java.util.*;

/*
 * 3024. Type of Triangle
 *
 * Given three side lengths, return "equilateral", "isosceles", or "scalene" if they form a valid
 * triangle, or "none" if they do not form a valid triangle.
 *
 * Constraints:
 * - nums.length == 3
 * - 1 <= nums[i] <= 100
 */
public class LC3024_Type_Of_Triangle {
    public static String triangleType(int[] nums) {
        if (nums.length != 3)
            return "none";

        int a = nums[0];
        int b = nums[1];
        int c = nums[2];

        if ((a + b) <= c || (b + c) <= a || (a + c) <= b) {
            return "none";
        }

        else if (a == b && b == c) {
            return "equilateral";
        }

        else if (a == b || b == c || a == c) {
            return "isosceles";
        }

        return "scalene";
    }
    public static String triangleType(int i, int i1, int i2) {
        return null;
    }
    static class FastIO extends PrintWriter {
        private InputStream stream;
        private byte[] buf = new byte[1 << 16];
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
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars == -1)
                    return -1;
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
            int c, sgn = 1, res = 0;
            do {
                c = nextByte();
            } while (c <= ' ');
            if (c == '-') {
                sgn = -1;
                c = nextByte();
            }
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res = 10 * res + c - '0';
                c = nextByte();
            } while (c > ' ');
            return res * sgn;
        }
    public long nextLong() {
            int c;
            long sgn = 1, res = 0;
            do {
                c = nextByte();
            } while (c <= ' ');
            if (c == '-') {
                sgn = -1;
                c = nextByte();
            }
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
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
            for (int i = 0; i < n; i++)
                arr[i] = nextInt();
            return arr;
        }
    public void printArray(int[] arr) {
            for (int i = 0; i < arr.length; i++)
                System.out.print(arr[i] + " ");
        }
    }
}
