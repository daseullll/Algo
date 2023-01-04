import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_상자넣기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int arr[] = new int[n];
        int dp[] = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1; // dp를 모두 1로 초기화
        }

        // --input end--
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (arr[j] < arr[i]) { // 앞에 작은 숫자를 발견
                    dp[i] = Math.max(dp[i], dp[j] + 1); // 현재 dp에 저장되어 있는 값과 비교
                }
            }
        }

        int result = 1;
        for (int i = 0; i < n; i++) {
            result = Math.max(dp[i], result);
        }

        System.out.println(result);

    }
}
