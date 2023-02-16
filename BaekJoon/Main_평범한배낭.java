import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_평범한배낭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] w = new int[n + 1]; // 6, 4, 3, 5
        int[] v = new int[n + 1]; // 13, 8, 6, 12
        int[][] dp = new int[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }

        // --input end--
        for (int i = 1; i <= n; i++) { // 순서대로 값을 저장하며 dp 값을 변경시켜준다.
            for (int j = 1; j <= k; j++) {
                // 1. 이전 아이템의 가치를 저장한다.
                dp[i][j] = dp[i - 1][j];
                // 2. 무게에서 자신의 무게를 뺐을 때 남는 무게가 존대하면,
                if (j - w[i] >= 0)
                    // 이전 아이템에서 구한 가치와 남은 무게의 가치 + 자신의 가치 중 큰 값을 취한다.
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
            }
        }

        System.out.println(dp[n][k]);

    }

}
