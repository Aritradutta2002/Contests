package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

public class LC386_Lexicographical_Numbers_A_Test {

    @Test
    public void testLexicalOrderExample1() {
        List<Integer> expected = Arrays.asList(1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9);
        assertEquals(expected, LC386_Lexicographical_Numbers_A.lexicalOrder(13));
    }

    @Test
    public void testLexicalOrderExample2() {
        List<Integer> expected = Arrays.asList(1, 2);
        assertEquals(expected, LC386_Lexicographical_Numbers_A.lexicalOrder(2));
    }

    @Test
    public void testLexicalOrderSingle() {
        List<Integer> expected = Arrays.asList(1);
        assertEquals(expected, LC386_Lexicographical_Numbers_A.lexicalOrder(1));
    }
}
