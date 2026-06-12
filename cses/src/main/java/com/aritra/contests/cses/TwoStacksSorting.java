package com.aritra.contests.cses;
import java.io.*;
import java.util.*;

public class TwoStacksSorting {
    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        FastScanner(InputStream is) { this.in = is; }
        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }
        int nextInt() throws IOException {
            int c; do { c = read(); } while (c <= ' ');
            int sgn = 1; if (c == '-') { sgn = -1; c = read(); }
            int x = 0;
            while (c > ' ') { x = x * 10 + (c - '0'); c = read(); }
            return x * sgn;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = fs.nextInt();

        // No lookahead: we'll use a robust greedy that always pushes to the stack
        // with the smallest possible top that is still > current element.

        // Build suffix minima
        int[] sufMin = new int[n + 1];
        sufMin[n] = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) sufMin[i] = Math.min(a[i], sufMin[i + 1]);

        // Build conflict graph using monotonic stack (only edges found while popping)
        List<Integer>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && a[st.peek()] < a[i]) {
                int j = st.pop();
                if (sufMin[j + 1] < a[j]) { g[j].add(i); g[i].add(j); }
            }
            st.push(i);
        }

        // 2-color the graph
        int[] color = new int[n];
        Arrays.fill(color, -1);
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (color[i] != -1) continue;
            color[i] = 0;
            q.add(i);
            while (!q.isEmpty()) {
                int u = q.poll();
                for (int v : g[u]) {
                    if (color[v] == -1) { color[v] = color[u] ^ 1; q.add(v); }
                    else if (color[v] == color[u]) { System.out.println("IMPOSSIBLE"); return; }
                }
            }
        }

        // Simulate with fixed coloring
        Deque<Integer> s1 = new ArrayDeque<>();
        Deque<Integer> s2 = new ArrayDeque<>();
        int[] ans = new int[n];
        int next = 1;
        for (int i = 0; i < n; i++) {
            int x = a[i];
            if (color[i] == 0) {
                if (!s1.isEmpty() && s1.peekLast() <= x) { System.out.println("IMPOSSIBLE"); return; }
                s1.addLast(x); ans[i] = 1;
            } else {
                if (!s2.isEmpty() && s2.peekLast() <= x) { System.out.println("IMPOSSIBLE"); return; }
                s2.addLast(x); ans[i] = 2;
            }
            boolean progressed = true;
            while (progressed) {
                progressed = false;
                if (!s1.isEmpty() && s1.peekLast() == next) { s1.pollLast(); next++; progressed = true; }
                if (!s2.isEmpty() && s2.peekLast() == next) { s2.pollLast(); next++; progressed = true; }
            }
        }
        boolean progressed = true;
        while (progressed) {
            progressed = false;
            if (!s1.isEmpty() && s1.peekLast() == next) { s1.pollLast(); next++; progressed = true; }
            if (!s2.isEmpty() && s2.peekLast() == next) { s2.pollLast(); next++; progressed = true; }
        }
        if (next != n + 1) { System.out.println("IMPOSSIBLE"); return; }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i > 0) sb.append(' ');
            sb.append(ans[i]);
        }
        System.out.println(sb.toString());
    }
}

