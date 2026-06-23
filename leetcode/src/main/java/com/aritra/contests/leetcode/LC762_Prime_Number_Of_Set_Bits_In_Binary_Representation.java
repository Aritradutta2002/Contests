package com.aritra.contests.leetcode;
import java.util.Scanner;
public class LC762_Prime_Number_Of_Set_Bits_In_Binary_Representation {
    public static int countPrimeSetBits(int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            int setBit = Integer.bitCount(i);
            if(isPrime(setBit)){
                count++;
            }
        }

        return count;
    }
    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

}
