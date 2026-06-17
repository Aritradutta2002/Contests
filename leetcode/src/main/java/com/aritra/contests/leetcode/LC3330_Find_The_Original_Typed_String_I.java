package com.aritra.contests.leetcode;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;
/*
 *   Author : Aritra
 *   Created On: Wednesday,02.07.2025 01:26 am
 */
public class LC3330_Find_The_Original_Typed_String_I {
    public static int possibleStringCount(String word) {
        int count = 1;
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) == word.charAt(i - 1)) {
                count++;
            }
        }
        return count;
    }
}

