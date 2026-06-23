package com.aritra.contests.codechef;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Easy_Pronunciation_Test {

    @Test
    public void testGcd() {
        assertEquals(6, Easy_Pronunciation.gcd(12, 18));
        assertEquals(1, Easy_Pronunciation.gcd(17, 23));
        assertEquals(5, Easy_Pronunciation.gcd(5, 0));
    }

    @Test
    public void testLcm() {
        assertEquals(36, Easy_Pronunciation.lcm(12, 18));
        assertEquals(391, Easy_Pronunciation.lcm(17, 23));
    }
}
