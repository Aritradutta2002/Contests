package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class LC127_Word_Ladder_Test {

    private final LC127_Word_Ladder solver = new LC127_Word_Ladder();

    @Test
    public void testExample1() {
        assertThrows(UnsupportedOperationException.class, () ->
            solver.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
    }

    @Test
    public void testExample2() {
        assertThrows(UnsupportedOperationException.class, () ->
            solver.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log")));
    }

    @Test
    public void testExample3() {
        assertThrows(UnsupportedOperationException.class, () ->
            solver.ladderLength("a", "c", Arrays.asList("a", "b", "c")));
    }
}
