package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC316_Remove_Duplicate_Letters_Test {

    @Test
    public void testStandardCase() {
        LC316_Remove_Duplicate_Letters solver = new LC316_Remove_Duplicate_Letters();
        assertEquals("abc", solver.removeDuplicateLetters("bcabc"));
    }

    @Test
    public void testCaseTwo() {
        LC316_Remove_Duplicate_Letters solver = new LC316_Remove_Duplicate_Letters();
        assertEquals("acdb", solver.removeDuplicateLetters("cbacdcbc"));
    }
}
