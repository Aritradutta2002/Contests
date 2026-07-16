package com.aritra.contests.leetcode;
import java.util.*;
/*
 * 1790. Check if One String Swap Can Make Strings Equal
 *
 * You are given two strings s1 and s2 of equal length. Return true if you can make the strings equal
 * by performing at most one string swap (swap any two characters) on one of the strings.
 *
 * Constraints:
 * - 1 <= s1.length, s2.length <= 100
 * - s1 and s2 consist of lowercase English letters
 */
public class LC1790_Check_If_One_String_Swap_Can_Make_Strings_Equal {
    static public boolean areAlmostEqual(String s1, String s2) {
       boolean isEqual = false;

       if(s1.length() != s2.length()){
           return isEqual;
       }

       if(s1.equals(s2))  return true;

        for(int i = 0; i < s1.length() - 1; i++){
            if(swap(s1, i, i + 1).equals(s2)){
                isEqual = true;
                break;
            }
        }
        return isEqual;
    }
    static String swap(String s, int i, int j) {
        char[] charArray = s.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return new String(charArray);
    }
}

