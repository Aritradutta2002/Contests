package com.aritra.contests.atcoder.educationaldp.wintervals;

import java.io.*;
import java.util.*;

public class W_Intervals {
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