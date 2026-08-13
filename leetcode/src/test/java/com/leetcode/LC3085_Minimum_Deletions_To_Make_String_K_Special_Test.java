package com.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class LC3085_Minimum_Deletions_To_Make_String_K_Special_Test {

    private final LC3085_Minimum_Deletions_To_Make_String_K_Special solution =
            new LC3085_Minimum_Deletions_To_Make_String_K_Special();

    @Test
    public void testExampleOne() {
        assertEquals(3, solution.minimumDeletions("aabcaba", 0));
    }

    @Test
    public void testExampleTwo() {
        assertEquals(2, solution.minimumDeletions("dabdcbdcdcd", 2));
    }

    @Test
    public void testExampleThree() {
        assertEquals(1, solution.minimumDeletions("aaabaaa", 2));
    }
}
