package com.aritra.contests.atcoder.educationaldp.wintervals;

import java.io.*;
import java.util.*;

public class W_Intervals {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] l = new int[M];
        int[] r = new int[M];
        long[] a = new long[M];
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            l[i] = Integer.parseInt(st.nextToken());
            r[i] = Integer.parseInt(st.nextToken());
            a[i] = Long.parseLong(st.nextToken());
        }
        
        // Segment tree DP:
        // dp[i] = max score for the binary string of length i (first i characters decided)
        // dp[i] = max(dp[i-1],  max over j<i of dp[j] + sum of a[k] for intervals [l,r] where l>j and r<=i)
        // Equivalently: when we place a '1' at position i, we activate all intervals [l,r] with r=i and l<=i.
        // But each interval only needs ONE '1' in [l,r].
        // DP: dp[i] = max score considering prefix of length i, last '1' placed somewhere.
        // dp[i] = max(dp[i-1],  for each j=1..i: dp[j-1] + sum of a[k] s.t. l[k]<=j and r[k]<=i... )
        // Standard approach with lazy segtree:
        // dp[i] = max_{0<=j<=i} { dp[j-1 or 0] + contribution of putting a '1' at position i
        //          where contribution = sum of a[k] with r[k]=i and l[k]>prev_1 }
        // Use segment tree maintaining dp[0..N], when we process position i:
        //   1. For each interval with r[k]=i: add a[k] to seg[0..l[k]-1] (all positions j<=l[k]-1 get +a[k])
        //   2. dp[i] = max(dp[i-1], query max over [0..i-1] in segtree)
        //   3. Set segtree[i] = dp[i]
        long[] dp = new long[N + 1];
        // Group intervals by right endpoint
        @SuppressWarnings("unchecked")
        List<int[]>[] byRight = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) byRight[i] = new ArrayList<>();
        for (int k = 0; k < M; k++) byRight[r[k]].add(new int[]{l[k], k});
        // Segment tree for range-add, range-max query over dp values
        long[] seg = new long[4 * (N + 1)];
        long[] lazy = new long[4 * (N + 1)];
        // init: seg position 0 = dp[0] = 0 (empty prefix, no chars placed)
        segUpdate(seg, lazy, 1, 0, N, 0, 0, 0); // set position 0 to 0
        for (int i = 1; i <= N; i++) {
            // apply intervals ending at i
            for (int[] interval : byRight[i]) {
                int lk = interval[0];
                // add a[interval[1]] to positions [0..lk-1] in segtree
                segAdd(seg, lazy, 1, 0, N, 0, lk - 1, a[interval[1]]);
            }
            // dp[i] = max(dp[i-1], max segtree over [0..i-1])
            dp[i] = Math.max(dp[i - 1], segQuery(seg, lazy, 1, 0, N, 0, i - 1));
            // place dp[i] at position i in segtree
            segUpdate(seg, lazy, 1, 0, N, i, i, dp[i]);
        }
        System.out.println(dp[N]);
    }

    static void pushDown(long[] seg, long[] lazy, int node) {
        if (lazy[node] != 0) {
            seg[2*node] += lazy[node]; lazy[2*node] += lazy[node];
            seg[2*node+1] += lazy[node]; lazy[2*node+1] += lazy[node];
            lazy[node] = 0;
        }
    }
    static void segAdd(long[] seg, long[] lazy, int node, int lo, int hi, int l, int r, long val) {
        if (r < lo || hi < l) return;
        if (l <= lo && hi <= r) { seg[node] += val; lazy[node] += val; return; }
        pushDown(seg, lazy, node);
        int mid = (lo + hi) / 2;
        segAdd(seg, lazy, 2*node, lo, mid, l, r, val);
        segAdd(seg, lazy, 2*node+1, mid+1, hi, l, r, val);
        seg[node] = Math.max(seg[2*node], seg[2*node+1]);
    }
    static long segQuery(long[] seg, long[] lazy, int node, int lo, int hi, int l, int r) {
        if (r < lo || hi < l) return Long.MIN_VALUE / 2;
        if (l <= lo && hi <= r) return seg[node];
        pushDown(seg, lazy, node);
        int mid = (lo + hi) / 2;
        return Math.max(segQuery(seg, lazy, 2*node, lo, mid, l, r),
                        segQuery(seg, lazy, 2*node+1, mid+1, hi, l, r));
    }
    static void segUpdate(long[] seg, long[] lazy, int node, int lo, int hi, int l, int r, long val) {
        if (r < lo || hi < l) return;
        if (l <= lo && hi <= r) { seg[node] = Math.max(seg[node], val); return; }
        pushDown(seg, lazy, node);
        int mid = (lo + hi) / 2;
        segUpdate(seg, lazy, 2*node, lo, mid, l, r, val);
        segUpdate(seg, lazy, 2*node+1, mid+1, hi, l, r, val);
        seg[node] = Math.max(seg[2*node], seg[2*node+1]);
    }
}