import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_스타트와링크 {

    static int n, result;
    static int[][] arr;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        check = new boolean[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // --input end--

        result = Integer.MAX_VALUE;
        dfs(0, 0);

        System.out.println(result);

    }

    public static void dfs(int cur, int cnt) {

        if (cnt == n / 2) {
            go();
            return;
        }

        for (int i = cur; i < n; i++) {
            if (check[i])
                continue;
            check[i] = true;
            dfs(i + 1, cnt + 1);
            check[i] = false;
        }
    }

    public static void go() {

        int start = 0;
        int link = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (check[i] && check[j]) {
                    start += arr[i][j];
                    start += arr[j][i];
                } else if (!check[i] && !check[j]) {
                    link += arr[i][j];
                    link += arr[j][i];
                }
            }
        }

        result = Math.min(result, Math.abs(start - link));

    }
}
