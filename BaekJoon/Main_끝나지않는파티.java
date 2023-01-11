import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_끝나지않는파티 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken()); // 파티장 크기
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 플로이드 워셜 최단거리 알고리즘
        for (int middle = 0; middle < N; middle++) {
            for (int start = 0; start < N; start++) {
                for (int end = 0; end < N; end++) {
                    arr[start][end] = Math.min(arr[start][end], arr[start][middle] + arr[middle][end]);
                }
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()) - 1;
            int B = Integer.parseInt(st.nextToken()) - 1;
            int C = Integer.parseInt(st.nextToken());

            if (arr[A][B] <= C)
                sb.append("Enjoy other party").append("\n");
            else
                sb.append("Stay here\n");
        }

        System.out.println(sb.toString());

    }

}
