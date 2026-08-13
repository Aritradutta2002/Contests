package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC3335_Total_Characters_In_String_After_Transformations_I_Test {

    @Test
    public void testExample1() {
        assertEquals(2, LC3335_Total_Characters_In_String_After_Transformations_I.lengthAfterTransformations("ab", 1));
    }

    @Test
    public void testExample2() {
        assertEquals(7, LC3335_Total_Characters_In_String_After_Transformations_I.lengthAfterTransformations("abcyy", 2));
    }

    @Test
    public void testNoTransform() {
        assertEquals(3, LC3335_Total_Characters_In_String_After_Transformations_I.lengthAfterTransformations("abc", 0));
    }
}
