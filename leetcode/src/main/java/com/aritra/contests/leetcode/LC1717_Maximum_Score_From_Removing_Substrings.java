package com.aritra.contests.leetcode;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

import static java.lang.Double.parseDouble;
import static java.lang.System.in;
import static java.lang.System.out;

/*
 *   Author : Aritra
 *   Created On: Thursday,24.07.2025 01:01 am
 */
public class LC1717_Maximum_Score_From_Removing_Substrings {
    public static void main(String[] args) {
        FastIO sc = new FastIO();
        out.println("Enter the string:");
        String s = sc.nextLine();
        out.println("Enter the values of x and y:");
        int x = sc.nextInt();
        int y = sc.nextInt();

        int result = maximumGain(s, x, y);
        out.println("Maximum score from removing substrings: " + result);
    }

    public static int maximumGain(String s, int x, int y) {
        int totalScore = 0;
        String highPriorityPair = x > y ? "ab" : "ba";
        String lowPriorityPair = highPriorityPair.equals("ab") ? "ba" : "ab";

        String stringAfterFirstPass = removeSubstring(s, highPriorityPair);
        int removedPairsCount =
                (s.length() - stringAfterFirstPass.length()) / 2;


        totalScore += removedPairsCount * Math.max(x, y);


        String stringAfterSecondPass = removeSubstring(
                stringAfterFirstPass,
                lowPriorityPair);


        removedPairsCount = (stringAfterFirstPass.length() - stringAfterSecondPass.length()) / 2;


        totalScore += removedPairsCount * Math.min(x, y);

        return totalScore;
    }

    private static String removeSubstring(String input, String targetPair) {
        Stack<Character> charStack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if(currentChar == targetPair.charAt(1) && !charStack.isEmpty() && charStack.peek() == targetPair.charAt(0)) {
                charStack.pop();
            } else {
                charStack.push(currentChar);
            }
        }

        StringBuilder remainingChars = new StringBuilder();
        while (!charStack.isEmpty()) {
            remainingChars.append(charStack.pop());
        }
        return remainingChars.reverse().toString();
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



