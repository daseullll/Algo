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
        dfs(0, 0);
        System.out.println(result);

    }

    /**
     * @param index : 현재 위치, 열과 행을 가져와서 위치를 파악한다.
     * @param sum   : 지금까지 누적 합계
     */
    public static void dfs(int index, int sum) {

        if (index == n * m) {
            result = Math.max(result, sum);
            return;
        }

        int x = index / m;
        int y = index % m;

        if (!check[x][y]) {
            if (x - 1 >= 0 && y + 1 < m && !check[x - 1][y] && !check[x][y + 1]) {
                check[x][y] = true;
                check[x - 1][y] = true;
                check[x][y + 1] = true;
                dfs(index + 1, sum + arr[x][y] * 2 + arr[x - 1][y] + arr[x][y + 1]);
                check[x][y] = false;
                check[x - 1][y] = false;
                check[x][y + 1] = false;
            }

            if (x + 1 < n && y + 1 < m && !check[x + 1][y] && !check[x][y + 1]) {
                check[x][y] = true;
                check[x + 1][y] = true;
                check[x][y + 1] = true;
                dfs(index + 1, sum + arr[x][y] * 2 + arr[x + 1][y] + arr[x][y + 1]);
                check[x][y] = false;
                check[x + 1][y] = false;
                check[x][y + 1] = false;
            }

            if (x + 1 < n && y - 1 >= 0 && !check[x + 1][y] && !check[x][y - 1]) {
                check[x][y] = true;
                check[x + 1][y] = true;
                check[x][y - 1] = true;
                dfs(index + 1, sum + arr[x][y] * 2 + arr[x + 1][y] + arr[x][y - 1]);
                check[x][y] = false;
                check[x + 1][y] = false;
                check[x][y - 1] = false;
            }

            if (x - 1 >= 0 && y - 1 >= 0 && !check[x - 1][y] && !check[x][y - 1]) {
                check[x][y] = true;
                check[x - 1][y] = true;
                check[x][y - 1] = true;
                dfs(index + 1, sum + arr[x][y] * 2 + arr[x - 1][y] + arr[x][y - 1]);
                check[x][y] = false;
                check[x - 1][y] = false;
                check[x][y - 1] = false;
            }

        }
        dfs(index + 1, sum);

    }

}
