import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_어두운굴다리 {

    static int n, m, result;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        arr = new int[m];
        result = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 1;
        int right = n;

        while (left <= right) {
            int mid = (left + right) / 2;
            // mid 높이로 모든 지점을 비출 수 있다면 result 갱신 후 높이를 줄여 재탐색
            if (go(mid)) {
                result = mid;
                right = mid - 1;
            }

            else
                left = mid + 1;
        }

        System.out.println(result);

    }

    public static boolean go(int start) {
        int prev = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] - start <= prev) {
                prev = arr[i] + start;
            } else {
                return false;
            }
        }

        return n - prev <= 0;
    }
}
