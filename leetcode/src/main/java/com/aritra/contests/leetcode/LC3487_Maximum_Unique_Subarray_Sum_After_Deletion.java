package com.aritra.contests.leetcode;

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

import static java.lang.Double.parseDouble;
import static java.lang.System.in;
import static java.lang.System.out;

/*
 *   Author : Aritra
 *   Created On: Friday,25.07.2025 10:10 pm
 */
public class LC3487_Maximum_Unique_Subarray_Sum_After_Deletion {
    public static void main(String[] args) {
        FastIO sc = new FastIO();
        int n = sc.nextInt();
        int[] nums = sc.readIntArray(n);
        int result = maxSum(nums);
        out.println(result);
    }
    public static int maxSum(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int currentSum = 0;
            seen.clear();
            for (int j = i; j < n; j++) {
                if (seen.contains(nums[j])) {
                    break;
                }
                seen.add(nums[j]);
                currentSum += nums[j];
                dp[j + 1] = Math.max(dp[j + 1], dp[i] + currentSum);
            }
        }
        int maxSum = 0;
        for (int i = 0; i <= n; i++) {
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }

    static class FastIO extends PrintWriter{
        private InputStream stream;private byte[]buf=new byte[1<<16];
        private int curChar,numChars;public FastIO(){this(in, System.out);}
        public FastIO(InputStream i,OutputStream o){super(o);stream=i;}
        public FastIO(String i,String o)throws IOException{super(new FileWriter(o));stream=new FileInputStream(i);}
        private int nextByte(){if(numChars==-1)throw new InputMismatchException();if(curChar>=numChars){curChar=0;try{numChars=stream.read(buf);}catch(IOException e){throw new InputMismatchException();}if(numChars==-1)return -1;}return buf[curChar++];}
        public String nextLine(){int c;do{c=nextByte();}while(c<='\n');StringBuilder res=new StringBuilder();do{res.appendCodePoint(c);c=nextByte();}while(c>'\n');return res.toString();}
        public String next(){int c;do{c=nextByte();}while(c<=' ');StringBuilder res=new StringBuilder();do{res.appendCodePoint(c);c=nextByte();}while(c>' ');return res.toString();}
        public int nextInt(){int c;do{c=nextByte();}while(c<=' ');int sgn=1;if(c=='-'){sgn=-1;c=nextByte();}int res=0;do{if(c<'0'||c>'9')throw new InputMismatchException();res=10*res+c-'0';c=nextByte();}while(c>' ');return res*sgn;}
        public long nextLong(){int c;do{c=nextByte();}while(c<=' ');long sgn=1;if(c=='-'){sgn=-1;c=nextByte();}long res=0;do{if(c<'0'||c>'9')throw new InputMismatchException();res=10*res+c-'0';c=nextByte();}while(c>' ');return res*sgn;}
        public double nextDouble(){return parseDouble(next());}
        public int[] readIntArray(int n){int[]arr=new int[n];for(int i=0;i<n;i++){arr[i]=nextInt();}return arr;}
    }
}

