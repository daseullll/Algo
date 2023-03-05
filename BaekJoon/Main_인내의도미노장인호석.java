import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_인내의도미노장인호석 {

    static int[][] delta = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } }; // 동, 서, 남, 북

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        int[][] ini = new int[N][M];
        int sum = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                ini[i][j] = arr[i][j];
            }
        }

        for (int i = 0; i < R; i++) { // 공격수
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            char d = st.nextToken().charAt(0);

            int dir = 0;
            if (d == 'E')
                dir = 0;
            else if (d == 'W')
                dir = 1;
            else if (d == 'S')
                dir = 2;
            else
                dir = 3;

            int end = arr[x][y];
            if (end != -1) {
                sum++;
                arr[x][y] = -1;
            }

            while (true) {
                end--;
                arr[x][y] = -1;

                int rn = x + delta[dir][0];
                int cn = y + delta[dir][1];

                if (rn < 0 || rn >= N || cn < 0 || cn >= M || end == 0) {
                    break;
                }
                if (arr[rn][cn] == -1) {
                    x = rn;
                    y = cn;
                    continue;
                }

                end = Math.max(end, arr[rn][cn]);
                sum++;
                x = rn;
                y = cn;

            }

            st = new StringTokenizer(br.readLine());
            int x2 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = Integer.parseInt(st.nextToken()) - 1;
            arr[x2][y2] = ini[x2][y2];
        }

        sb.append(sum + "\n");

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == -1)
                    sb.append('F' + " ");
                else
                    sb.append('S' + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
