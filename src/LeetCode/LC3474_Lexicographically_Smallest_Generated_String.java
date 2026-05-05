package LeetCode;
import java.util.*;

public class LC3474_Lexicographically_Smallest_Generated_String {
    public String generateString(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int wordLen = n + m - 1;
        char[] res = new char[wordLen];
        boolean[] isFixed = new boolean[wordLen];

        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                for (int j = 0; j < m; j++) {
                    int pos = i + j;
                    char c = str2.charAt(j);
                    if (isFixed[pos]) {
                        if (res[pos] != c) return "";
                    } else {
                        res[pos] = c;
                        isFixed[pos] = true;
                    }
                }
            }
        }

        for (int pos = 0; pos < wordLen; pos++) {
            if (!isFixed[pos]) res[pos] = 'a';
        }

        boolean changed;
        do {
            changed = false;
            List<Integer> violators = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (str1.charAt(i) == 'F') {
                    boolean equal = true;
                    for (int j = 0; j < m; j++) {
                        int pos = i + j;
                        if (res[pos] != str2.charAt(j)) {
                            equal = false;
                            break;
                        }
                    }
                    if (equal) violators.add(i);
                }
            }
            if (violators.isEmpty()) break;

            int[] count = new int[wordLen];
            for (int i : violators) {
                for (int j = 0; j < m; j++) {
                    int pos = i + j;
                    if (!isFixed[pos]) count[pos]++;
                }
            }

            int bestPos = -1;
            int maxCount = -1;
            for (int pos = 0; pos < wordLen; pos++) {
                if (count[pos] > maxCount) {
                    maxCount = count[pos];
                    bestPos = pos;
                }
            }
            if (bestPos == -1) return "";

            res[bestPos] = (char) (res[bestPos] + 1);
            if (res[bestPos] > 'z') return "";
            changed = true;
        } while (changed);

        return new String(res);
    }

    public static void main(String[] args) {
        LC3474_Lexicographically_Smallest_Generated_String solution = new LC3474_Lexicographically_Smallest_Generated_String();

        String str1 = "TFTF";
        String str2 = "ab";
        String result = solution.generateString(str1, str2);
        System.out.println("Test 1: " + ("ababa".equals(result) ? "Pass" : "Fail"));

        str1 = "TFTF";
        str2 = "abc";
        result = solution.generateString(str1, str2);
        System.out.println("Test 2: " + ("".equals(result) ? "Pass" : "Fail"));

        str1 = "F";
        str2 = "d";
        result = solution.generateString(str1, str2);
        System.out.println("Test 3: " + ("a".equals(result) ? "Pass" : "Fail"));
    }
}