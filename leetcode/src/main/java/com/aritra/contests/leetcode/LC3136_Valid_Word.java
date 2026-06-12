package com.aritra.contests.leetcode;

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

/*
 *   Author : Aritra
 *   Created On: Tuesday,15.07.2025 10:39 am
 */

/*
     A word is considered valid if -
            i) It contains a minimum of 3 characters.
            Ii) It contains only digits (0-9), and English letters (uppercase and lowercase).
            Iii) It includes at least one vowel.
            Iv) It includes at least one consonant.
     You are given a string word.
     Return true if the word is valid, otherwise, return false.
 */

public class LC3136_Valid_Word {
    public static void main(String[] args) {

    }

    public static boolean isValid(String word) {
        int vowelCount = 0;
        int consonantCount = 0;
        int charCount = 0;

        for(char ch : word.toCharArray()) {
            if(ch >= '0' && ch <= '9') {
                charCount++;
            } else if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                charCount++;
                if("aeiouAEIOU".indexOf(ch) != -1) {
                    vowelCount++;
                } else {
                    consonantCount++;
                }
            } else {
                return false;
            }
        }

        return charCount >= 3 && vowelCount > 0 && consonantCount > 0;
    }
}

