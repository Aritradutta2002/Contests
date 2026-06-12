package com.aritra.contests.leetcode;
public class LC3174_Clear_Digits {
    public static void main(String[] args) {
        System.out.println(clearDigits("cb34")); // Output: "c"
    }

    static public String clearDigits(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}

