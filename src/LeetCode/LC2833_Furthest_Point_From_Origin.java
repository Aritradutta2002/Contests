package LeetCode;

import java.util.*;

/*
 * LeetCode 2833 - Furthest Point From Origin
 *
 * Description:
 * Given a string moves containing 'L', 'R', and '_', start from position 0.
 * Replace each '_' with either 'L' or 'R' to maximize the distance from origin
 * after processing all moves.
 *
 * Key Constraints:
 * 1 <= moves.length <= 50
 * moves[i] is one of 'L', 'R', '_'
 */
public class LC2833_Furthest_Point_From_Origin {

    public int furthestDistanceFromOrigin(String moves) {
        int l = 0;
        int r = 0;
        int t = 0;
        for (char c : moves.toCharArray()) {
            if(c == 'L') l++;
            if(c == 'R') r++;
            if(c == '_') t++;
        }
        return Math.abs(l-r)+t;
    }

    public static void main(String[] args) {
        LC2833_Furthest_Point_From_Origin solver = new LC2833_Furthest_Point_From_Origin();

        List<String> tests = Arrays.asList(
                "L_RL__R",
                "_R__LL_",
                "_______",
                "LRLR");

        int[] expected = { 3, 5, 7, 0 };

        for (int i = 0; i < tests.size(); i++) {
            String moves = tests.get(i);
            int actual = solver.furthestDistanceFromOrigin(moves);
            System.out.println(
                    "Test " + (i + 1) + " | moves = " + moves + " | expected = " + expected[i] + " | actual = "
                            + actual);
        }
    }
}
