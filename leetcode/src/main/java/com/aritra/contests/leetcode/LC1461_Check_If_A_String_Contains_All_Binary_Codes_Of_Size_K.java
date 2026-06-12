package com.aritra.contests.leetcode;
import java.util.*;
public class LC1461_Check_If_A_String_Contains_All_Binary_Codes_Of_Size_K {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int k = sc.nextInt();

        System.out.println(hasAllCodes(s, k));
    }

    public static boolean hasAllCodes(String s, int k) {
        if (k > s.length()) {
            return false;
        }
        int totalCodes = 1 << k;   // same as Math.pow(2, k) but better 
        boolean[] seen = new boolean[totalCodes];
        int mask = totalCodes - 1;
        int rolling = 0;
        int seenCount = 0;

        for (int i = 0; i < s.length(); i++) {
            rolling = ((rolling << 1) & mask) | (s.charAt(i) - '0');
            if (i >= k - 1 && !seen[rolling]) {
                seen[rolling] = true;
                seenCount++;
                if (seenCount == totalCodes) {
                    return true;
                }
            }
        }
        return false;
    }
}
