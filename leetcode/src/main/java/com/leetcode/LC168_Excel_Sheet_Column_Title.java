package com.leetcode;

/*
 * @lc app=leetcode id=168 lang=java
 *
 * [168] Excel Sheet Column Title
 */
import java.util.*;
// @lc code=start
class LC168_Excel_Sheet_Column_Title {
    public String convertToTitle(int columnNumber) {
        StringBuilder title = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--; // Shift to 0-based to map 1->A, 26->Z.
            int remainder = columnNumber % 26;
            title.append((char) ('A' + remainder));
            columnNumber /= 26;
        }
        return title.reverse().toString();
    }
}
// @lc code=end

