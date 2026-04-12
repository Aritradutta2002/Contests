package LeetCode;
import java.util.*;
/*
 * 1320. Minimum Distance to Type a Word Using Two Fingers
 *
 * You have a keyboard layout that looks like:
 *   Q W E R T Y U I O P
 *   A S D F G H J K L
 *   Z X C V B N M
 *
 * You have two fingers placed on the keyboard. Initially, each finger is at
 * some character. Typing a character means moving one of the two fingers to
 * that character. The distance between two characters is the absolute difference
 * of row and column indices (Manhattan distance).
 *
 * Given a string word, return the minimum total distance to type word using
 * two fingers. You can start with any two characters under the two fingers.
 *
 * Constraints:
 * - 2 <= word.length <= 10^4
 * - word consists of uppercase English letters only.
 */
public class LC1320_Minimum_Distance_To_Type_A_Word_Using_Two_Fingers {
    public int minimumDistance(String word) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public static void main(String[] args) {
        LC1320_Minimum_Distance_To_Type_A_Word_Using_Two_Fingers solver = new LC1320_Minimum_Distance_To_Type_A_Word_Using_Two_Fingers();

        // Test Case 1
        String word1 = "CAKE";
        runTest(solver, 1, word1, 3);

        // Test Case 2
        String word2 = "HAPPY";
        runTest(solver, 2, word2, 6);

        // Test Case 3
        String word3 = "NEW";
        runTest(solver, 3, word3, 3);
    }

    private static void runTest(LC1320_Minimum_Distance_To_Type_A_Word_Using_Two_Fingers solver, int testId, String word, int expected) {
        try {
            int result = solver.minimumDistance(word);
            if (result == expected) {
                System.out.println("Test " + testId + ": PASS");
            } else {
                System.out.println("Test " + testId + ": FAIL");
                System.out.println("  Expected: " + expected);
                System.out.println("  Actual:   " + result);
            }
        } catch (UnsupportedOperationException e) {
            System.out.println("Test " + testId + ": SKIPPED (Not implemented)");
        } catch (Exception e) {
            System.out.println("Test " + testId + ": ERROR (" + e.getMessage() + ")");
        }
    }
}
