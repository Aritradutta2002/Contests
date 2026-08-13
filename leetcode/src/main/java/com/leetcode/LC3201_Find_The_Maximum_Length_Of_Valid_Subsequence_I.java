package com.leetcode;

import java.io.*;
import java.util.InputMismatchException;

import static java.lang.Double.parseDouble;
import static java.lang.System.in;
import static java.lang.System.out;

/*
 *   Author : Aritra
 *   Created On: Wednesday,16.07.2025 11:01 pm
 */
public class LC3201_Find_The_Maximum_Length_Of_Valid_Subsequence_I {
    static void main(String[] args) {
        // reference args to avoid 'never used' warning
        if (args.length < 0) return;
        @SuppressWarnings("resource")
        FastIO sc = new FastIO();
        int n = sc.nextInt();
        int[] nums = sc.readIntArray(n);
        int result = maximumLength(nums);

        out.println(result);
    }

/*
    Problem Statement is:

    You are given an integer array nums.
    A subsequence sub of nums with length n is called valid if it satisfies:
    (sub[0] + sub[1]) % 2 == (sub[1] + sub[2]) % 2 == ... == (sub[n - 2] + sub[n - 1]) % 2.
    Return the length of the longest valid subsequence of nums.
    A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.

*/
    public static int maximumLength(int[] nums) {

        int n = nums.length;
        int oddCount = 0;
        int evenCount = 0;
        if(nums[0] % 2 == 0){
            evenCount = 1;
        }else{
            oddCount = 1;
        }
        int alternateCount = 1;
        // use != 0 to correctly detect odd numbers even when nums[0] is negative
        boolean expecting_even = nums[0] % 2 != 0;

        //    true: expecting EVEN as the next number in sequence
        //    false: expecting ODD as the next number in sequence

        for (int i = 1; i < n; ++i) {
            if ((expecting_even && nums[i] % 2 == 0) || (!expecting_even && nums[i] % 2 != 0)) {
                alternateCount++;
                expecting_even = !expecting_even;
            }

            if (nums[i] % 2 != 0) {
                oddCount++;
            } else {
                evenCount++;
            }
        }
        return Math.max(Math.max(evenCount, oddCount), alternateCount);

    }
    static class FastIO extends PrintWriter{
        private final InputStream stream; private final byte[] buf = new byte[1<<16];
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

