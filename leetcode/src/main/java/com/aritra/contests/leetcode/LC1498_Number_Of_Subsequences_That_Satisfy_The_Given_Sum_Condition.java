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
 *   Created On: Sunday,29.06.2025 01:16 pm
 */

/*
 You are given an array of integers nums and an integer target.
 Return the number of non-empty subsequences of nums such that the sum of
 the minimum and maximum element on it is less or equal to the target.
 Since the answer may be too large, return it modulo 109 + 7.
 */

public class LC1498_Number_Of_Subsequences_That_Satisfy_The_Given_Sum_Condition {
    public static void main(String[] args) {
        FastIO sc = new FastIO();
        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] nums = sc.readIntArray(n);

        out.println(numSubseq(nums, target));
    }



    public static int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int mod = (int) 1e9 + 7;
        int l = 0, r = n - 1;
        int[] powerOfTwo = new int[n + 1];


        while(l <= r){
            if(nums[l] + nums[r] > target){
                r--;
            } else{
                int count = r - l + 1;
                int result = 1;
                for(int i = 0; i < count; i++){
                    result = (result * 2) % mod;
                }
                return result - 1;
            }
        }

        return 0;
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

