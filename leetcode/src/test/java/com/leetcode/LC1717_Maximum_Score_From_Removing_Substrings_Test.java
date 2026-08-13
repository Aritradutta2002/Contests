package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC1717_Maximum_Score_From_Removing_Substrings_Test {

    @Test
    public void testStandardCase() {
        assertEquals(19, LC1717_Maximum_Score_From_Removing_Substrings.maximumGain("cdbcbbaaabab", 4, 5));
    }

    @Test
    public void testAnotherCase() {
        assertEquals(20, LC1717_Maximum_Score_From_Removing_Substrings.maximumGain("aabbaaxybbaabb", 5, 4));
    }
}
