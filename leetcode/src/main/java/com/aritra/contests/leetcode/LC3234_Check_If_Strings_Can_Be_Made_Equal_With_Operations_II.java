package com.aritra.contests.leetcode;
import java.util.*;
/*
 * 3234. Check if Strings Can be Made Equal With Operations II
 * 
 * You are given two strings s1 and s2, both of length n, consisting of lowercase English letters.
 * You can apply the following operation on any of the two strings any number of times:
 * - Choose any two indices i and j such that i < j and the difference j - i is even, then swap
 *   the two characters at those indices in the string.
 * Return true if you can make the strings s1 and s2 equal, and false otherwise.
 * 
 * Constraints:
 * - n == s1.length == s2.length
 * - 1 <= n <= 10^5
 * - s1 and s2 consist only of lowercase English letters.
 */
public class LC3234_Check_If_Strings_Can_Be_Made_Equal_With_Operations_II {
    public boolean checkStrings(String s1, String s2) {
        int n = s2.length();
        if (s1.length() != s2.length()) return false;
        List<Character> even1 = new ArrayList<>();
        List<Character> even2 = new ArrayList<>();
        List<Character> odd1 = new ArrayList<>();
        List<Character> odd2 = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if((i & 1) == 0){
                even1.add(s1.charAt(i));
                even2.add(s2.charAt(i));
            } else{
                odd1.add(s1.charAt(i));
                odd2.add(s2.charAt(i));
            }
        }
        Collections.sort(even1);
        Collections.sort(even2);
        Collections.sort(odd1);
        Collections.sort(odd2);

        return even1.equals(even2) && odd1.equals(odd2);
    }
}
