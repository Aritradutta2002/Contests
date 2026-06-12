package com.aritra.contests.atcoder.educationaldp.hgrid1;

import java.io.*;
import java.util.*;

public class H_Grid1 {
    static final long MOD = 1_000_000_007L;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        
        char[][] grid = new char[H][W];
        for (int i = 0; i < H; i++) {
            String line = br.readLine().trim();
            grid[i] = line.toCharArray();
        }
        
        // dp[i][j] = number of paths to (i,j) mod MOD
        long[][] dp = new long[H][W];
        dp[0][0] = (grid[0][0] == '.') ? 1 : 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (i == 0 && j == 0) continue;
                if (grid[i][j] == '#') { dp[i][j] = 0; continue; }
                long from_top  = (i > 0) ? dp[i - 1][j] : 0;
                long from_left = (j > 0) ? dp[i][j - 1] : 0;
                dp[i][j] = (from_top + from_left) % MOD;
            }
        }
        System.out.println(dp[H - 1][W - 1]);
    }
}