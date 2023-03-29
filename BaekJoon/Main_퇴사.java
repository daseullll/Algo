import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_퇴사 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[] t = new int[n];
        int[] p = new int[n];
        int[] dp = new int[n + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        // Resolve 1.
        // int max = 0;

        // for (int i = 1; i <= n + 1; i++) {
        // dp[i] = Math.max(max, dp[i]);
        // dp[t[i] + i] = Math.max(dp[t[i] + i], p[i] + dp[i]);
        // max = Math.max(max, dp[i]);
        // }

        // Resolve 2.
        for (int i = 0; i < n; i++) {
            if (i + t[i] <= n) {
                dp[t[i] + i] = Math.max(dp[t[i] + i], dp[i] + p[i]);
            }

            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }

        System.out.println(dp[n]);

    }
}
