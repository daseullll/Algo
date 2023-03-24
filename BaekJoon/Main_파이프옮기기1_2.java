import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_파이프옮기기1_2 {

    static int[][] a = { { 0, 1 }, { 1, 1 } }; // 가로
    static int[][] b = { { 1, 0 }, { 1, 1 } }; // 세로
    static int[][] d = { { 0, 1 }, { 1, 0 }, { 1, 1 } }; // 대각선
    static int[][] arr;
    static int result, n;

    static class pipe {
        int r, c, dir;

        public pipe(int r, int c, int dir) {
            this.r = r;
            this.c = c;
            this.dir = dir;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        result = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // --input end--
        dfs(new pipe(0, 1, 0));
        System.out.println(result);
    }

    public static void dfs(pipe p) {

        int r = p.r;
        int c = p.c;
        int dir = p.dir;
        if (r == n - 1 && c == n - 1) {
            result++;
            return;
        }

        if (dir == 0) { // 가로
            int rn = r + a[0][0];
            int cn = c + a[0][1];

            if (rn < n && cn < n && arr[rn][cn] != 1)
                dfs(new pipe(rn, cn, dir));

            rn = r + a[1][0];
            cn = c + a[1][1];

            if (rn < n && cn < n && arr[rn][cn] != 1 && arr[rn][cn - 1] != 1 && arr[rn - 1][cn] != 1)
                dfs(new pipe(rn, cn, 2));

        } else if (dir == 1) {
            int rn = r + b[0][0];
            int cn = c + b[0][1];

            if (rn < n && cn < n && arr[rn][cn] != 1)
                dfs(new pipe(rn, cn, 1));

            rn = r + b[1][0];
            cn = c + b[1][1];

            if (rn < n && cn < n && arr[rn][cn] != 1 && arr[rn][cn - 1] != 1 && arr[rn - 1][cn] != 1)
                dfs(new pipe(rn, cn, 2));

        } else {

            int rn = r + d[0][0];
            int cn = c + d[0][1];

            if (rn < n && cn < n && arr[rn][cn] != 1)
                dfs(new pipe(rn, cn, 0));

            rn = r + d[1][0];
            cn = c + d[1][1];

            if (rn < n && cn < n && arr[rn][cn] != 1)
                dfs(new pipe(rn, cn, 1));

            rn = r + d[2][0];
            cn = c + d[2][1];

            if (rn < n && cn < n && arr[rn][cn] != 1 && arr[rn][cn - 1] != 1 && arr[rn - 1][cn] != 1)
                dfs(new pipe(rn, cn, 2));

        }

    }
}
