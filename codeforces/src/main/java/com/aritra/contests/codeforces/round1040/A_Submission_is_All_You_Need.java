package com.aritra.contests.codeforces.round1040;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

import static java.lang.Double.parseDouble;
import static java.lang.System.in;
import static java.lang.System.out;

public class A_Submission_is_All_You_Need {

    public static void main(String[] args) {
        FastIO sc = new FastIO();
        int t = sc.nextInt();
        while (t-- > 0) {
            solve(sc);
        }
        sc.close();
    }

    public static void solve(FastIO sc) {
        int n = sc.nextInt();
        int[] counts = new int[51];
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            if (val >= 0 && val <= 50) {
                counts[val]++;
            }
        }


        long[][] dp = new long[53][n + 1];
        for (long[] row : dp) {
            Arrays.fill(row, -1_000_000_000_000_000L);
        }

        dp[0][0] = 0;


        for (int i = 1; i <= 52; i++) {
            int val = i - 1;
            int count = (val < 51) ? counts[val] : 0;


            if (i == 1) {
                for (int j = 0; j <= count; j++) {

                    dp[i][j] = 0;
                }
            } else {
                long[] M = new long[n + 2];
                Arrays.fill(M, -1_000_000_000_000_000L);


                for (int k = n; k >= 0; k--) {
                    long prevScore = dp[i - 1][k];
                    if (prevScore > -5e14) {
                        M[k] = Math.max(M[k + 1], prevScore + (long) k * val);
                    } else {
                        M[k] = M[k + 1];
                    }
                }


                for (int j = 0; j <= n; j++) {
                    if (j <= count) {
                        long maxPrevScore = M[j];
                        if (maxPrevScore > -5e14) {
                            dp[i][j] = (long) count * val + maxPrevScore - 2L * j * val;
                        }
                    }
                }
            }
        }

        sc.println(dp[52][0]);
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


