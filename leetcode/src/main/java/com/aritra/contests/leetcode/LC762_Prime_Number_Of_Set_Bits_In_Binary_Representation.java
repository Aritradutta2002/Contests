package com.aritra.contests.leetcode;
import java.util.Scanner;
/*
 * 762. Prime Number of Set Bits in Binary Representation
 *
 * Given two integers left and right, return the count of numbers in the range [left, right] whose
 * number of 1-bits in their binary representation is a prime number.
 *
 * Constraints:
 * - 1 <= left <= right <= 10^6
 * - 0 <= right - left <= 10^4
 */
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
