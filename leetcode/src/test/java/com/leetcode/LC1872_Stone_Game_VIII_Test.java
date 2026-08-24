package com.leetcode;

import java.util.Arrays;
import java.util.Random;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LC1872_Stone_Game_VIII_Test {

    private final LC1872_Stone_Game_VIII solver = new LC1872_Stone_Game_VIII();

    @Test
    public void testExample1() {
        int[] param1 = new int[]{-1,2,-3,4,-5};
        int expected = 5;
        int actual = solver.stoneGameVIII(param1);
        assertEquals(expected, actual);
    }

    @Test
    public void testExample2() {
        int[] param1 = new int[]{7,-6,5,10,5,-2,-6};
        int expected = 13;
        int actual = solver.stoneGameVIII(param1);
        assertEquals(expected, actual);
    }

    @Test
    public void testExample3() {
        int[] param1 = new int[]{-10,-12};
        int expected = -22;
        int actual = solver.stoneGameVIII(param1);
        assertEquals(expected, actual);
    }

    @Test
    public void testQuadraticMatchesExamples() {
        assertEquals(5, solver.stoneGameVIIIQuadratic(new int[]{-1,2,-3,4,-5}));
        assertEquals(13, solver.stoneGameVIIIQuadratic(new int[]{7,-6,5,10,5,-2,-6}));
        assertEquals(-22, solver.stoneGameVIIIQuadratic(new int[]{-10,-12}));
    }

    @Test
    public void testEdgeCases() {
        int[][] inputs = {
            {1,1},                      // shortest game: Alice must take both stones
            {-1,-1},                    // ... even when that hurts her
            {0,0},                      // no score to win
            {10000,10000},              // value extremes, shortest game
            {-10000,-10000},
            {1,2,3},                    // all positive: taking everything at once is best
            {0,0,0,0},
            {-1,-1,-1,-1},              // all negative: leave Bob the worse of the two tails
            {5,-1,-1,-1},               // taking two stones and taking all four tie at 2
        };
        int[] expected = {2, -2, 0, 20000, -20000, 6, 0, 1, 2};

        for (int i = 0; i < inputs.length; i++) {
            String label = "stones=" + Arrays.toString(inputs[i]);
            assertEquals(expected[i], solver.stoneGameVIIIRunningMax(inputs[i]), "running max, " + label);
            assertEquals(expected[i], solver.stoneGameVIIIQuadratic(inputs[i]), "quadratic, " + label);
        }
    }

    /* The running max must agree with the definition-level DP on small random rows. */
    @Test
    public void testApproachesAgreeOnRandomInput() {
        Random random = new Random(42);
        for (int iteration = 0; iteration < 500; iteration++) {
            int n = 2 + random.nextInt(39);
            int[] stones = new int[n];
            for (int i = 0; i < n; i++) {
                stones[i] = random.nextInt(21) - 10;
            }
            String label = "stones=" + Arrays.toString(stones);
            assertEquals(solver.stoneGameVIIIQuadratic(stones), solver.stoneGameVIIIRunningMax(stones), label);
        }
    }

    /* Same cross-check at the value extremes, where the intermediate DP terms leave int range. */
    @Test
    public void testApproachesAgreeOnExtremeValues() {
        Random random = new Random(7);
        for (int iteration = 0; iteration < 200; iteration++) {
            int n = 2 + random.nextInt(199);
            int[] stones = new int[n];
            for (int i = 0; i < n; i++) {
                stones[i] = random.nextBoolean() ? 10000 : -10000;
            }
            String label = "stones=" + Arrays.toString(stones);
            assertEquals(solver.stoneGameVIIIQuadratic(stones), solver.stoneGameVIIIRunningMax(stones), label);
        }
    }

    /* Full-size rows: the answer reaches 10^9, and the linear scan has to stay linear. */
    @Test
    public void testConstraintScale() {
        int n = 100000;
        int[] allPositive = new int[n];
        Arrays.fill(allPositive, 10000);
        assertEquals(1000000000, solver.stoneGameVIIIRunningMax(allPositive), "Alice takes every stone");

        int[] allNegative = new int[n];
        Arrays.fill(allNegative, -10000);
        assertEquals(10000, solver.stoneGameVIIIRunningMax(allNegative), "Alice leaves Bob the deeper loss");
    }
}
