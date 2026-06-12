package com.aritra.contests.atcoder.educationaldp.zfrog3;

import java.io.*;
import java.util.*;

public class Z_Frog3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        long C = Long.parseLong(st.nextToken());
        
        long[] h = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            h[i] = Long.parseLong(st.nextToken());
        }
        
        // dp[i] = min cost to reach stone i from stone 0
        // dp[j] = min over i<j of { dp[i] + (h[j]-h[i])^2 + C }
        // Expand: dp[j] = h[j]^2 + C + min_i { dp[i] + h[i]^2 - 2*h[j]*h[i] }
        // This is CHT: lines y = dp[i]+h[i]^2, slope = -2*h[i], queried at x=h[j]
        // Since h is strictly increasing, slopes are strictly decreasing => use monotone stack
        dp = new long[N];
        Arrays.fill(dp, Long.MAX_VALUE / 2);
        dp[0] = 0;
        // CHT with deque (slopes decreasing, query x increasing)
        long[] mSlope = new long[N];
        long[] mIntercept = new long[N];
        int head = 0, tail = 0;
        // add line for i=0
        mSlope[tail] = -2 * h[0];
        mIntercept[tail] = dp[0] + h[0] * h[0];
        tail++;
        for (int j = 1; j < N; j++) {
            // remove lines from front that are no longer optimal
            while (head + 1 < tail) {
                long x = h[j];
                long v1 = mSlope[head] * x + mIntercept[head];
                long v2 = mSlope[head + 1] * x + mIntercept[head + 1];
                if (v1 >= v2) head++; else break;
            }
            dp[j] = mSlope[head] * h[j] + mIntercept[head] + h[j] * h[j] + C;
            // add line for j
            long slope = -2 * h[j];
            long intercept = dp[j] + h[j] * h[j];
            while (head + 1 < tail) {
                // check if second-to-last line is made obsolete
                long s1 = mSlope[tail - 2], b1 = mIntercept[tail - 2];
                long s2 = mSlope[tail - 1], b2 = mIntercept[tail - 1];
                // intersection of (s1,b1) and (s2,b2) vs (s2,b2) and (slope,intercept)
                // bad if (b2-b1)*(s2-slope) <= (b2-intercept)*(s2-s1)
                if ((b2 - b1) * (s2 - slope) <= (intercept - b2) * (s1 - s2)) {
                    tail--;
                } else break;
            }
            mSlope[tail] = slope;
            mIntercept[tail] = intercept;
            tail++;
        }
        System.out.println(dp[N - 1]);
    }

    static long[] dp;
}