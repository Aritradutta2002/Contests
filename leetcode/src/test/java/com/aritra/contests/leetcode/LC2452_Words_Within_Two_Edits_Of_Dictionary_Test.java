package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC2452_Words_Within_Two_Edits_Of_Dictionary_Test {

    @Test
    public void testStandardCase() {
        LC2452_Words_Within_Two_Edits_Of_Dictionary solver = new LC2452_Words_Within_Two_Edits_Of_Dictionary();
        String[] queries = {"word","note","ants","wood"};
        String[] dictionary = {"wood","joke","moat"};
        assertEquals(3, solver.twoEditWords(queries, dictionary).size());
    }

    @Test
    public void testNoMatch() {
        LC2452_Words_Within_Two_Edits_Of_Dictionary solver = new LC2452_Words_Within_Two_Edits_Of_Dictionary();
        String[] queries = {"abc"};
        String[] dictionary = {"xyz"};
        assertTrue(solver.twoEditWords(queries, dictionary).isEmpty());
    }
}
