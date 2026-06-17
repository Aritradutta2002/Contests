package com.aritra.contests.atcoder.educationaldp.qflowers;

import java.io.*;
import java.util.*;

public class Q_Flowers {
    static long queryMax(long[] bit, int i) {
        long res = 0;
        for (; i > 0; i -= i & (-i)) res = Math.max(res, bit[i]);
        return res;
    }
    static void updateMax(long[] bit, int i, long val, int n) {
        for (; i <= n; i += i & (-i)) bit[i] = Math.max(bit[i], val);
    }
}