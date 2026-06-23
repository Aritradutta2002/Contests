package com.aritra.contests.cses;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BitStrings_Test {

    @Test
    public void testExp() {
        long mod = 1_000_000_007;
        assertEquals(8, BitStrings.exp(2, 3, mod));
        assertEquals(1, BitStrings.exp(5, 0, mod));
        assertEquals(1024, BitStrings.exp(2, 10, mod));
    }
}
