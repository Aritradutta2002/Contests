package CodeChef;
import java.io.*;
import java.util.*;

public class MinimumDistinct {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine().trim());
        
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine().trim());
            String[] parts = br.readLine().trim().split("\\s+");
            int K = Integer.parseInt(br.readLine().trim());
            
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(parts[i]);
            }
            
            int result = solve(arr, K);
            output.append(result).append("\n");
        }
        
        System.out.print(output.toString());
    }
    
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
