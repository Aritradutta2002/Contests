package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC1352_Product_The_Last_K_Numbers_Test {

    @Test
    public void testProductOfNumbersExample() {
        LC1352_Product_The_Last_K_Numbers.ProductOfNumbers productOfNumbers = new LC1352_Product_The_Last_K_Numbers.ProductOfNumbers();
        productOfNumbers.add(3);
        productOfNumbers.add(0);
        productOfNumbers.add(2);
        productOfNumbers.add(5);
        productOfNumbers.add(4);
        assertEquals(20, productOfNumbers.getProduct(2));
        assertEquals(40, productOfNumbers.getProduct(3));
        assertEquals(0, productOfNumbers.getProduct(4));
        productOfNumbers.add(8);
        assertEquals(32, productOfNumbers.getProduct(2));
    }

    @Test
    public void testProductOfNumbersAllNonZero() {
        LC1352_Product_The_Last_K_Numbers.ProductOfNumbers productOfNumbers = new LC1352_Product_The_Last_K_Numbers.ProductOfNumbers();
        productOfNumbers.add(2);
        productOfNumbers.add(3);
        productOfNumbers.add(4);
        assertEquals(4, productOfNumbers.getProduct(1));
        assertEquals(12, productOfNumbers.getProduct(2));
        assertEquals(24, productOfNumbers.getProduct(3));
    }

    @Test
    public void testProductOfNumbersAfterZeroReset() {
        LC1352_Product_The_Last_K_Numbers.ProductOfNumbers productOfNumbers = new LC1352_Product_The_Last_K_Numbers.ProductOfNumbers();
        productOfNumbers.add(1);
        productOfNumbers.add(2);
        productOfNumbers.add(0);
        assertEquals(0, productOfNumbers.getProduct(1));
        assertEquals(0, productOfNumbers.getProduct(2));
        productOfNumbers.add(5);
        assertEquals(5, productOfNumbers.getProduct(1));
    }
}
