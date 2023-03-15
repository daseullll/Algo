import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main_감시 {

    static ArrayList<cctv> cctvs;
    static int n, m, result;

    static class cctv {
        int r, c, num;

        public cctv(int r, int c, int num) {
            this.r = r;
            this.c = c;
            this.num = num;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        result = Integer.MAX_VALUE;

        cctvs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] >= 1 && arr[i][j] <= 5) {
                    cctvs.add(new cctv(i, j, arr[i][j]));
                }
            }
        }

        dfs(0, arr);
        System.out.println(result);

    }

    public static void dfs(int cnt, int[][] arr) {

        if (cnt == cctvs.size()) {
            result = Math.min(result, zero(arr));
            return;
        }

        int r = cctvs.get(cnt).r;
        int c = cctvs.get(cnt).c;
        int num = cctvs.get(cnt).num;

        int[][] temp;
        if (num == 1) {
            temp = copyMap(arr);
            up(temp, r, c);
            dfs(cnt + 1, temp);

            temp = copyMap(arr);
            down(temp, r, c);
            dfs(cnt + 1, temp);

            temp = copyMap(arr);
            left(temp, r, c);
            dfs(cnt + 1, temp);

            temp = copyMap(arr);
            right(temp, r, c);
            dfs(cnt + 1, temp);
        } else if (num == 2) {
            temp = copyMap(arr);
            left(temp, r, c);
            right(temp, r, c);
            dfs(cnt + 1, temp);

            temp = copyMap(arr);
            up(temp, r, c);
            down(temp, r, c);
            dfs(cnt + 1, temp);
        } else if (num == 3) {
            temp = copyMap(arr);
            up(temp, r, c);
            right(temp, r, c);
            dfs(cnt + 1, temp);

            temp = copyMap(arr);
            right(temp, r, c);
            down(temp, r, c);
            dfs(cnt + 1, temp);

            temp = copyMap(arr);
            down(temp, r, c);
            left(temp, r, c);
            dfs(cnt + 1, temp);

            temp = copyMap(arr);
            left(temp, r, c);
            up(temp, r, c);
            dfs(cnt + 1, temp);

        } else if (num == 4) {
            temp = copyMap(arr);
            up(temp, r, c);
            right(temp, r, c);
            left(temp, r, c);
            dfs(cnt + 1, temp);

            temp = copyMap(arr);
            right(temp, r, c);
            down(temp, r, c);
            left(temp, r, c);
            dfs(cnt + 1, temp);

            temp = copyMap(arr);
            down(temp, r, c);
            left(temp, r, c);
            up(temp, r, c);
            dfs(cnt + 1, temp);

            temp = copyMap(arr);
            up(temp, r, c);
            down(temp, r, c);
            right(temp, r, c);
            dfs(cnt + 1, temp);
        } else if (num == 5) {
            temp = copyMap(arr);
            up(temp, r, c);
            down(temp, r, c);
            right(temp, r, c);
            left(temp, r, c);
            dfs(cnt + 1, temp);
        }

    }

    public static int[][] copyMap(int[][] arr) {

        int[][] temp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp[i][j] = arr[i][j];
            }
        }

        return temp;
    }

    public static void up(int[][] temp, int r, int c) {

        for (int i = r - 1; i >= 0; i--) {

            if (temp[i][c] == 6)
                return;
            if (temp[i][c] != 0)
                continue;

            temp[i][c] = -1;
        }
    }

    public static void down(int[][] temp, int r, int c) {

        for (int i = r + 1; i < n; i++) {

            if (temp[i][c] == 6)
                return;
            if (temp[i][c] != 0)
                continue;

            temp[i][c] = -1;
        }
    }

    public static void left(int[][] temp, int r, int c) {

        for (int i = c - 1; i >= 0; i--) {

            if (temp[r][i] == 6)
                return;
            if (temp[r][i] != 0)
                continue;

            temp[r][i] = -1;
        }
    }

    public static void right(int[][] temp, int r, int c) {

        for (int i = c + 1; i < m; i++) {

            if (temp[r][i] == 6)
                return;
            if (temp[r][i] != 0)
                continue;

            temp[r][i] = -1;
        }
    }

    public static int zero(int[][] temp) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (temp[i][j] == 0)
                    sum++;
            }
        }

        return sum;
    }

}
