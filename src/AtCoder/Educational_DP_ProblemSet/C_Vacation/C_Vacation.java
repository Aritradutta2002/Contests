package AtCoder.Educational_DP_ProblemSet.C_Vacation;
import java.io.*;
import java.util.*;

public class C_Vacation {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine().trim());
        long[][] dp = new long[N][3];
        
        for (int i = 0; i < N; i++) {
            String[] parts = br.readLine().trim().split("\\s+");
            for (int j = 0; j < 3; j++) {
                dp[i][j] = Long.parseLong(parts[j]);
            }
        }
        
        // dp[i][j] = max happiness on day i ending with activity j (0=A,1=B,2=C)
        // dp is already loaded with the activity values
        for (int i = 1; i < N; i++) {
            long a = dp[i][0], b = dp[i][1], c = dp[i][2];
            dp[i][0] = a + Math.max(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = b + Math.max(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = c + Math.max(dp[i - 1][0], dp[i - 1][1]);
        }
        long ans = Math.max(dp[N - 1][0], Math.max(dp[N - 1][1], dp[N - 1][2]));
        System.out.println(ans);
    }
}