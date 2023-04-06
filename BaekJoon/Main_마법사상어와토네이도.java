import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_마법사상어와토네이도 {

    static int n;
    static int[][] arr;
    static int x, y, result;
    static boolean[][] check;
    static int[][] delta = { { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // --input end--
        x = n / 2;
        y = n / 2;
        check = new boolean[n][n];
        int dir = 0;
        result = 0;
        while (x != 0 || y != 0) {
            // 모래 이동
            check[x][y] = true;
            int xn = x + delta[dir][0];
            int yn = y + delta[dir][1];

            if (check[xn][yn]) {

                if (dir == 0)
                    dir = 3;
                else
                    dir = dir - 1;
                continue;
            } else {
                go(xn, yn, dir);
                dir = (dir + 1) % 4;
                x = xn;
                y = yn;
            }
        }

        System.out.println(result);

    }

    static int[][][] move = {
            { { 0, 0, 2, 0, 0 }, { 0, 10, 7, 1, 0 }, { 5, -1, 0, 0, 0 }, { 0, 10, 7, 1, 0 }, { 0, 0, 2, 0, 0 } },
            { { 0, 0, 0, 0, 0 }, { 0, 1, 0, 1, 0 }, { 2, 7, 0, 7, 2 }, { 0, 10, -1, 10, 0 }, { 0, 0, 5, 0, 0 } },
            { { 0, 0, 2, 0, 0 }, { 0, 1, 7, 10, 0 }, { 0, 0, 0, -1, 5 }, { 0, 1, 7, 10, 0 }, { 0, 0, 2, 0, 0 } },
            { { 0, 0, 5, 0, 0 }, { 0, 10, -1, 10, 0 }, { 2, 7, 0, 7, 2 }, { 0, 1, 0, 1, 0 }, { 0, 0, 0, 0, 0 } }
    };

    public static void go(int r, int c, int dir) {

        int alpha_x = -1;
        int alpha_y = -1;
        int cnt = 0;

        for (int i = r - 2; i <= r + 2; i++) {
            for (int j = c - 2; j <= c + 2; j++) {
                int x = i - (r - 2);
                int y = j - (c - 2);

                if (move[dir][x][y] == 0)
                    continue;
                if (move[dir][x][y] == -1) {
                    alpha_x = i;
                    alpha_y = j;
                    continue;
                }

                double percent = (double) move[dir][x][y] / 100;
                int sand = (int) (arr[r][c] * (percent));
                cnt += sand;

                if (i < 0 || i >= n || j < 0 || j >= n) {
                    result += sand;
                } else {
                    arr[i][j] += sand;
                }

            }
        }

        if (alpha_x < 0 || alpha_x >= n || alpha_y < 0 || alpha_y >= n) {
            result += (arr[r][c] - cnt);
        } else {
            arr[alpha_x][alpha_y] += (arr[r][c] - cnt);
        }

        arr[r][c] = 0;
    }
}
