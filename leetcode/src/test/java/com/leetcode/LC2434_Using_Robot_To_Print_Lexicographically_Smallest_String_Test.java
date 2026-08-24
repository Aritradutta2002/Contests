package com.leetcode;

import java.util.Random;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LC2434_Using_Robot_To_Print_Lexicographically_Smallest_String_Test {

    @Test
    public void testExample1() {
        String s = "zza";
        String expected = "azz";
        String actual = LC2434_Using_Robot_To_Print_Lexicographically_Smallest_String.robotWithString(s);
        assertEquals(expected, actual);
    }

    @Test
    public void testExample2() {
        String s = "bac";
        String expected = "abc";
        String actual = LC2434_Using_Robot_To_Print_Lexicographically_Smallest_String.robotWithString(s);
        assertEquals(expected, actual);
    }

    @Test
    public void testExample3() {
        String s = "bdda";
        String expected = "addb";
        String actual = LC2434_Using_Robot_To_Print_Lexicographically_Smallest_String.robotWithString(s);
        assertEquals(expected, actual);
    }

    @Test
    public void testEdgeCases() {
        String[] inputs = {"a", "aaaa", "abcd", "dcba", "ba", "ab", "cbacdcbc", "zzzza"};
        String[] expected = {"a", "aaaa", "abcd", "abcd", "ab", "ab", "abbccdcc", "azzzz"};

        for (int i = 0; i < inputs.length; i++) {
            assertEquals(expected[i],
                LC2434_Using_Robot_To_Print_Lexicographically_Smallest_String.robotWithString(inputs[i]),
                "s=" + inputs[i]);
        }
    }

    /* The greedy rule must match an exhaustive search over every legal move order. */
    @Test
    public void testMatchesBruteForceOnRandomInput() {
        Random random = new Random(42);
        for (int iteration = 0; iteration < 200; iteration++) {
            int n = 1 + random.nextInt(8);
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < n; i++) {
                s.append((char) ('a' + random.nextInt(3)));
            }
            String input = s.toString();
            assertEquals(bruteForceRobot(input, 0, new StringBuilder(), new StringBuilder()),
                LC2434_Using_Robot_To_Print_Lexicographically_Smallest_String.robotWithString(input),
                "s=" + input);
        }
    }

    /*
     * Oracle: try both moves at every step and keep the smallest finished paper string.
     * Every finished string has the same length, so plain compareTo orders them lexicographically.
     */
    private String bruteForceRobot(String s, int index, StringBuilder stack, StringBuilder paper) {
        if (index == s.length() && stack.length() == 0) {
            return paper.toString();
        }

        String best = null;
        if (index < s.length()) {                       // move s[index] onto the stack
            stack.append(s.charAt(index));
            best = bruteForceRobot(s, index + 1, stack, paper);
            stack.deleteCharAt(stack.length() - 1);
        }
        if (stack.length() > 0) {                       // write the top of the stack on the paper
            char top = stack.charAt(stack.length() - 1);
            stack.deleteCharAt(stack.length() - 1);
            paper.append(top);
            String candidate = bruteForceRobot(s, index, stack, paper);
            paper.deleteCharAt(paper.length() - 1);
            stack.append(top);
            if (best == null || candidate.compareTo(best) < 0) {
                best = candidate;
            }
        }
        return best;
    }
}
