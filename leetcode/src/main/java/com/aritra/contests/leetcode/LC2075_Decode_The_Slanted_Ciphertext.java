package com.aritra.contests.leetcode;
import java.util.*;
/*
 * 2075. Decode the Slanted Ciphertext
 * 
 * A string encodedString of length n is given, which is a slanted transposition
 * of the original string originalText. originalText was placed in a matrix with
 * rows number of rows and some columns, then read diagonally.
 * Return the originalText.
 * 
 * Constraints:
 * - 0 <= encodedString.length <= 10^6
 * - 1 <= rows <= 10^6
 * - encodedString.length % rows == 0
 * - encodedString consists of lowercase English letters and ' '.
 * - originalText does not have any trailing spaces.
 */
public class LC2075_Decode_The_Slanted_Ciphertext {
    public String decodeCiphertext(String encodedString, int rows) {
        if (encodedString == null || encodedString.isEmpty()) return "";

        int n = encodedString.length();
        int cols = n / rows;
        StringBuilder result = new StringBuilder();

        for (int startCol = 0; startCol < cols; startCol++) {
            int row = 0;
            int col = startCol;
            while (row < rows && col < cols) {
                result.append(encodedString.charAt(row * cols + col));
                row++;
                col++;
            }
        }

        while (result.length() > 0 && result.charAt(result.length() - 1) == ' ') {
            result.deleteCharAt(result.length() - 1);
        }
        return result.toString();
    }
    private static void runTest(LC2075_Decode_The_Slanted_Ciphertext solver, int testId, String encodedString, int rows, String expected) {
        try {
            String result = solver.decodeCiphertext(encodedString, rows);
            if (result.equals(expected)) {
                System.out.println("Test " + testId + ": PASS");
            } else {
                System.out.println("Test " + testId + ": FAIL");
                System.out.println("  Expected: '" + expected + "'");
                System.out.println("  Actual:   '" + result + "'");
            }
        } catch (UnsupportedOperationException e) {
            System.out.println("Test " + testId + ": SKIPPED (Not implemented)");
        } catch (Exception e) {
            System.out.println("Test " + testId + ": ERROR (" + e.getMessage() + ")");
        }
    }
}
