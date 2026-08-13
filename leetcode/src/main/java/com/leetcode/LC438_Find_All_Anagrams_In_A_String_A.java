package com.leetcode;

/*
 * @lc app=leetcode id=438 lang=java
 *
 * [438] Find All Anagrams in a String
 */

// @lc code=start
import java.util.*;

class LC438_Find_All_Anagrams_In_A_String_A {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        char[] c = p.toCharArray();
        Arrays.sort(c);
        String sortedP = new String(c);
        for(int i = 0; i <= s.length() - p.length(); i++){
            String subS = s.substring(i, i + p.length());
            char[] ch = subS.toCharArray();
            Arrays.sort(ch);
            String sortedS = new String(ch);

            if(sortedP.equals(sortedS)){
                list.add(i);
            }
        }

        return list;
    }
}
// @lc code=end

