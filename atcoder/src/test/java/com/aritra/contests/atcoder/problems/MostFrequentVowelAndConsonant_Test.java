package com.aritra.contests.atcoder.problems;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MostFrequentVowelAndConsonant_Test {

    @Test
    public void testMostFrequentVowelAndConsonant() {
        MostFrequentVowelAndConsonant obj = new MostFrequentVowelAndConsonant();
        assertEquals(3, obj.mostFrequentVowelAndConsonant("apple"));
    }
}
