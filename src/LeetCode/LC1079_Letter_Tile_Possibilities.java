package LeetCode;
import java.util.*;
@SuppressWarnings("unused")

public class LC1079_Letter_Tile_Possibilities{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.next();
    }

    static public int numTilePossibilities(String tiles) {
        int[] freq = new int[26];
        for (char c : tiles.toCharArray()) {
            freq[c - 'A']++;
        }
        return backtrack(freq);
    }

    private static int backtrack(int[] freq) {
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0) continue;
            count++;
            freq[i]--;
            count += backtrack(freq);
            freq[i]++;
        }
        return count;
    }
}
