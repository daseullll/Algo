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

                // 높이를 줄여서 최소 높이 찾기
                right = mid - 1;
            }

            // 모든 지점을 비출 수 없다면 높이를 높여 재탐색
            else
                left = mid + 1;
        }

        System.out.println(result);

    }

    public static boolean go(int start) {

        // 0부터 시작해서 가로등이 현재 불빛이 닿는 곳 확인
        int prev = 0;

        for (int i = 0; i < arr.length; i++) {

            // 가로등이 있는 곳에서 왼쪽으로 mid 높이 만큼 갔을 때 마지막으로 가로등이 비춰진 곳 까지 닿는지 확인
            if (arr[i] - start <= prev) {
                // 닿는다면 오른쪽으로도 mid 만큼 불빛이 닿는 다는 의미므로 prev를 옮겨준다.
                prev = arr[i] + start;
            } else {
                // 닿지 않는다면 false 반환
                return false;
            }
        }

        return n - prev <= 0;
    }
}
