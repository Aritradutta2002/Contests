package com.aritra.contests.cses;
import java.io.*;
import java.util.*;

public class BitStrings {
    public static long exp(long base, long exponent, long mod) {
        if (exponent == 0) return 1;
        long half = exp(base, exponent / 2, mod);
        if (exponent % 2 == 0) return (half * half) % mod;
        return (half * half % mod) * base % mod;
    }
}

