package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC509_Fibonacci_Number_Test {

    private final LC509_Fibonacci_Number sol = new LC509_Fibonacci_Number();

    @Test
    public void testFib2() {
        assertEquals(1, sol.fib(2));
    }

    @Test
    public void testFib3() {
        assertEquals(2, sol.fib(3));
    }

    @Test
    public void testFib4() {
        assertEquals(3, sol.fib(4));
    }

    @Test
    public void testFib0() {
        assertEquals(0, sol.fib(0));
    }

    @Test
    public void testFib1() {
        assertEquals(1, sol.fib(1));
    }

    @Test
    public void testFib10() {
        assertEquals(55, sol.fib(10));
    }
}
