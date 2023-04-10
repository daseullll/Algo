import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_달력 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[366];

        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            for (int j = s; j <= e; j++) {
                arr[j]++;
            }
        }

        // --input end--
        // 배열에 값이 있는 것부터 시작한다. -> 최댓값을 계속 갱신
        // 연속이 끊기면 결과 값에 더해준다. -> 끝이 365까지 있으므로 탐색
        int result = 0;
        for (int i = 1; i <= 365; i++) {

            if (arr[i] > 0) { // 일정이 있음
                // 연속될때까지 반복
                int max = 0; // 연속되는 값 중에 최대 깊이 찾기
                int cnt = i;
                while (true) {

                    max = Math.max(max, arr[cnt]);
                    if (arr[cnt] == 0 || cnt == 365) {
                        if (cnt == 365 && arr[365] > 0)
                            cnt++;
                        result += (cnt - i) * max;
                        i = cnt + 1;
                        break;
                    }

                    cnt++;

                }

            }
        }

        System.out.println(result);
    }
}
