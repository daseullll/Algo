import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_퇴사2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[2][N + 2];
        int[] dp = new int[N + 2]; // i일째까지의 최대 수익

        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[0][i] = Integer.parseInt(st.nextToken());
            arr[1][i] = Integer.parseInt(st.nextToken());
        }
        // --input end--

        int max = 0; // 현재 날짜까지의 최대
        for (int i = 1; i <= N + 1; i++) {
            if (max < dp[i])
                max = dp[i];

            int day = i + arr[0][i];
            if (day <= N + 1) {
                dp[day] = Math.max(dp[day], max + arr[1][i]);
            }

        }

        System.out.println(max);
    }
}
