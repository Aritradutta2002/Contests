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
 *   Created On: Wednesday,30.07.2025 10:33 am
 */

public class LC2419_Longest_Subarray_With_Maximum_Bitwise_And {
    public static int longestSubarray(int[] nums) {
        int n = nums.length;
        int maxElement = nums[0];
        int result = 0;

        for(int i = 1; i < n; i++){
            maxElement = Math.max(maxElement, nums[i]);
        }

        int currMax = maxElement, count = 0;

        for(int i = 0; i < n; i++){
            if(nums[i] == currMax){
                count++;
            } else {
                result = Math.max(result, count);
                count = 0;
            }
        }

        result = Math.max(result, count);

        return result;
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

