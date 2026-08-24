package com.leetcode;

import java.util.Random;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LC1927_Sum_Game_Test {

    private final LC1927_Sum_Game solver = new LC1927_Sum_Game();

    @Test
    public void testExample1() {
        String param1 = "5023";
        boolean expected = false;
        boolean actual = solver.sumGame(param1);
        assertEquals(expected, actual);
    }

    @Test
    public void testExample2() {
        String param1 = "25??";
        boolean expected = true;
        boolean actual = solver.sumGame(param1);
        assertEquals(expected, actual);
    }

    @Test
    public void testExample3() {
        String param1 = "?3295???";
        boolean expected = false;
        boolean actual = solver.sumGame(param1);
        assertEquals(expected, actual);
    }

    @Test
    public void testBruteForceMatchesExamples() {
        assertEquals(false, solver.sumGameBruteForce("5023"));
        assertEquals(true, solver.sumGameBruteForce("25??"));
        assertEquals(false, solver.sumGameBruteForce("?3295???"));
    }

    @Test
    public void testEdgeCases() {
        String[] inputs = {
            "00",           // no blanks, sums already equal
            "10",           // no blanks, sums already differ
            "0099",
            "?0",           // a single blank: Alice fills it and skips the one equalising digit
            "9?",
            "??",           // one blank per half: Bob copies Alice's digit
            "????",
            "??????",
            "??00",         // both blanks on the left: Bob needs 0 + 0, Alice writes 9
            "9000??",       // two right-half blanks must total 9, so Bob answers d with 9 - d
            "9010??",       // ... but they would have to total 10, which Alice can rule out
            "19??28",       // one blank per half and the known digits already balance
            "19??29",       // ... one off, so the mirrored blanks cannot fix it
        };
        boolean[] expected = {false, true, true, true, true, false, false, false, true, false, true, false, true};

        for (int i = 0; i < inputs.length; i++) {
            String label = "num=" + inputs[i];
            assertEquals(expected[i], solver.sumGameCounting(inputs[i]), "counting, " + label);
            assertEquals(expected[i], solver.sumGameBruteForce(inputs[i]), "brute force, " + label);
        }
    }

    /* The counting rule must agree with exhaustive minimax on small random inputs. */
    @Test
    public void testApproachesAgreeOnRandomInput() {
        Random random = new Random(42);
        for (int iteration = 0; iteration < 500; iteration++) {
            int half = 1 + random.nextInt(5);
            StringBuilder num = new StringBuilder();
            for (int i = 0; i < half * 2; i++) {
                num.append(random.nextInt(3) == 0 ? '?' : (char) ('0' + random.nextInt(10)));
            }
            String input = num.toString();
            assertEquals(solver.sumGameBruteForce(input), solver.sumGameCounting(input), "num=" + input);
        }
    }

    /* Blank-heavy inputs, where the game is decided by the blanks rather than the known digits. */
    @Test
    public void testApproachesAgreeOnBlankHeavyInput() {
        Random random = new Random(7);
        for (int iteration = 0; iteration < 300; iteration++) {
            int half = 1 + random.nextInt(4);
            StringBuilder num = new StringBuilder();
            for (int i = 0; i < half * 2; i++) {
                num.append(random.nextInt(4) == 0 ? (char) ('0' + random.nextInt(10)) : '?');
            }
            String input = num.toString();
            assertEquals(solver.sumGameBruteForce(input), solver.sumGameCounting(input), "num=" + input);
        }
    }

    /* Full-size inputs: the counting pass has to stay linear where the search cannot run at all. */
    @Test
    public void testConstraintScale() {
        int half = 50000;
        assertEquals(false, solver.sumGameCounting("?".repeat(half * 2)), "Bob mirrors every digit across halves");
        assertEquals(true, solver.sumGameCounting("?".repeat(half) + "0".repeat(half)), "left half can only grow");
    }
}
