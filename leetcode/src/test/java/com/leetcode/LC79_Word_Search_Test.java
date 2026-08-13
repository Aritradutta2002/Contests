package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC79_Word_Search_Test {

    private final LC79_Word_Search solver = new LC79_Word_Search();

    @Test
    public void testWordExists() {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        assertTrue(solver.exist(board, "ABCCED"));
    }

    @Test
    public void testWordDoesNotExist() {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        assertFalse(solver.exist(board, "ABCB"));
    }

    @Test
    public void testSingleCharMatch() {
        char[][] board = {{'A'}};
        assertTrue(solver.exist(board, "A"));
    }
}
