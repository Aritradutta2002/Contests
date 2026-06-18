package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC168_Excel_Sheet_Column_Title_Test {

    @Test
    public void testStandardCase() {
        LC168_Excel_Sheet_Column_Title solver = new LC168_Excel_Sheet_Column_Title();
        assertEquals("A", solver.convertToTitle(1));
    }

    @Test
    public void testCase28() {
        LC168_Excel_Sheet_Column_Title solver = new LC168_Excel_Sheet_Column_Title();
        assertEquals("AB", solver.convertToTitle(28));
    }

    @Test
    public void testCase701() {
        LC168_Excel_Sheet_Column_Title solver = new LC168_Excel_Sheet_Column_Title();
        assertEquals("ZY", solver.convertToTitle(701));
    }
}
