package com.aritra.contests.leetcode;
import java.util.*;
public class LC1903_Largest_Odd_Number_In_String {
    public static String largeOddNum(String s) {
        String str = "";

        for(int i = 0; i < s.length(); i++) {
            for(int j = s.length(); j >= 0; j--) {
                if(s.charAt(i) == '0') {
                    continue;
                }
                
                str = s.substring(i, j);
                if(Integer.parseInt(str) % 2 != 0) {
                    return str;
                }
            }

        }

        return "";
    }
}
