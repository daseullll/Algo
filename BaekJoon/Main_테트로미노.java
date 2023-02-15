import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_테트로미노 {

    static int n, m, result;
    static int[][] arr;
    static int[][] delta = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    static boolean[][] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // --input end--
        // 4개의 최댓값 찾기
        result = Integer.MIN_VALUE;
        check = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                check[i][j] = true;
                dfs(1, i, j, arr[i][j]);
                check[i][j] = false;
            }
        }

        System.out.println(result);
    }

    public static void dfs(int cnt, int x, int y, int sum) {

        if (cnt == 4) {
            result = Math.max(result, sum);
            return;
        }

        for (int dir = 0; dir < 4; dir++) {
            int xn = x + delta[dir][0];
            int yn = y + delta[dir][1];

            if (xn < 0 || xn >= n || yn < 0 || yn >= m || check[xn][yn])
                continue;

            if (cnt == 2) {
                check[xn][yn] = true;
                dfs(cnt + 1, x, y, sum + arr[xn][yn]);
                check[xn][yn] = false;
            }
            check[xn][yn] = true;
            dfs(cnt + 1, xn, yn, sum + arr[xn][yn]);
            check[xn][yn] = false;

        }
    }

}
