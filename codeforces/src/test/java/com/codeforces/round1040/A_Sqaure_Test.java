package com.codeforces.round1040;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class A_Sqaure_Test {

    @Test
    public void testGcd() {
        assertEquals(6, A_Sqaure.gcd(12, 18));
        assertEquals(5, A_Sqaure.gcd(5, 0));
    }

    @Test
    public void testLcm() {
        assertEquals(36, A_Sqaure.lcm(12, 18));
    }
}
