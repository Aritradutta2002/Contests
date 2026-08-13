package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC3024_Type_Of_Triangle_Test {

    @Test
    public void testEquilateral() {
        assertEquals("equilateral", LC3024_Type_Of_Triangle.triangleType(new int[]{3,3,3}));
    }

    @Test
    public void testIsosceles() {
        assertEquals("isosceles", LC3024_Type_Of_Triangle.triangleType(new int[]{3,4,4}));
    }

    @Test
    public void testScalene() {
        assertEquals("scalene", LC3024_Type_Of_Triangle.triangleType(new int[]{3,4,5}));
    }

    @Test
    public void testInvalidTriangle() {
        assertEquals("none", LC3024_Type_Of_Triangle.triangleType(new int[]{1,2,3}));
    }
}
