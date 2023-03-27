import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_무기공학 {

    static int n, m, result;
    static int[][] arr;
    static boolean[][] check;
    static int[][] delta = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        check = new boolean[n][m];
        arr = new int[n][m];
        result = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // --input end--

    }

    public static void go(int r, int c) {

        for (int dir = 0; dir < 4; dir++) {
            int rn = r + delta[dir][0];
            int cn = c + delta[dir][1];

            if (rn < 0 || rn >= n || cn < 0 || cn >= m)
                continue;

            rn = r + delta[(dir + 1) % 4][0];
            cn = c + delta[(dir + 1) % 4][1];

            if (rn < 0 || rn >= n || cn < 0 || cn >= m)
                continue;

        }
    }
}
