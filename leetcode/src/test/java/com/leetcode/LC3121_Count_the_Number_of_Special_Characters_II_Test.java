package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC3121_Count_the_Number_of_Special_Characters_II_Test {

    @Test
    public void testNumberOfSpecialCharsExample1() {
        LC3121_Count_the_Number_of_Special_Characters_II solver = new LC3121_Count_the_Number_of_Special_Characters_II();
        assertEquals(3, solver.numberOfSpecialChars("aaAbcBC"));
    }

    @Test
    public void testNumberOfSpecialCharsExample2() {
        LC3121_Count_the_Number_of_Special_Characters_II solver = new LC3121_Count_the_Number_of_Special_Characters_II();
        assertEquals(0, solver.numberOfSpecialChars("abc"));
    }

    @Test
    public void testNumberOfSpecialCharsExample3() {
        LC3121_Count_the_Number_of_Special_Characters_II solver = new LC3121_Count_the_Number_of_Special_Characters_II();
        assertEquals(2, solver.numberOfSpecialChars("abCBAc"));
    }

    @Test
    public void testNumberOfSpecialCharsNoSpecial() {
        LC3121_Count_the_Number_of_Special_Characters_II solver = new LC3121_Count_the_Number_of_Special_Characters_II();
        assertEquals(0, solver.numberOfSpecialChars("AbBCab"));
    }
}
