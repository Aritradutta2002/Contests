package com.aritra.contests.codechef;
import java.io.*;
import java.util.*;

public class MinimumDistinct {
    private static int solve(int[] arr, int K) {
        // Count frequency of each element
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        // Get all frequencies and sort in ascending order
        List<Integer> frequencies = new ArrayList<>(freqMap.values());
        Collections.sort(frequencies);
        
        // Try to eliminate elements with smallest frequencies first
        int distinct = frequencies.size();
        int eliminated = 0;
        
        for (int freq : frequencies) {
            if (freq <= K) {
                // We can eliminate this element completely
                K -= freq;
                eliminated++;
            } else {
                // Not enough operations left to eliminate more elements
                break;
            }
        }
        
        // Minimum distinct elements = total distinct - eliminated
        return distinct - eliminated;
    }
}
