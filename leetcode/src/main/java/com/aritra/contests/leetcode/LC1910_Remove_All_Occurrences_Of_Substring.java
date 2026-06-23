package com.aritra.contests.leetcode;

import java.util.*;

public class LC1910_Remove_All_Occurrences_Of_Substring {
    static public String removeOccurrences(String s, String part) {

        StringBuilder ans = new StringBuilder();
        int n = s.length();
        int m = part.length();

        for (int i = 0; i < n; i++) {
            ans.append(s.charAt(i));
            if (ans.length() >= m) {
                String sub = ans.substring(ans.length() - m);
                if (sub.equals(part)) {
                    ans.setLength(ans.length() - m);
                }
            }
        }
        return ans.toString();
    }
}

