package com.aritra.contests.atcoder.educationaldp.kstones;

import java.io.*;
import java.util.*;

public class K_Stones {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] a = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        
        // dp[j] = true if current player wins with j stones remaining
        boolean[] dp = new boolean[K + 1];
        dp[0] = false; // can't move, current player loses
        for (int j = 1; j <= K; j++) {
            for (int x : a) {
                if (x <= j && !dp[j - x]) {
                    dp[j] = true;
                    break;
                }
            }
        }
        System.out.println(dp[K] ? "First" : "Second");
    }
}