import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_경사로 {

    static int n, l;
    static int[][] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        int result = 0;

        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            if (check(i))
                result++;

        }

        for (int i = 0; i < n; i++) {
            if (check2(i))
                result++;
        }

        System.out.println(result);

    }

    public static boolean check(int r) { // 가로

        boolean[] visited = new boolean[n];

        for (int c = 0; c < n - 1; c++) {
            int dif = arr[r][c] - arr[r][c + 1];
            if (dif > 1 || dif < -1)
                return false;
            else if (dif == -1) {
                for (int i = 0; i < l; i++) {
                    if (c - i < 0 || visited[c - i] || arr[r][c] != arr[r][c - i])
                        return false;
                    visited[c - i] = true;
                }
            } else if (dif == 1) {
                for (int i = 1; i <= l; i++) {
                    if (c + i >= n || visited[c + i] || arr[r][c] - 1 != arr[r][c + i])
                        return false;
                    visited[c + i] = true;
                }
            }
        }

        return true;

    }

    public static boolean check2(int c) { // 세로
        boolean[] visited = new boolean[n];

        for (int r = 0; r < n - 1; r++) {
            int dif = arr[r][c] - arr[r + 1][c];
            if (dif > 1 || dif < -1)
                return false;
            else if (dif == -1) {
                for (int i = 0; i < l; i++) {
                    if (r - i < 0 || visited[r - i] || arr[r][c] != arr[r - i][c])
                        return false;
                    visited[r - i] = true;
                }
            } else if (dif == 1) {
                for (int i = 1; i <= l; i++) {
                    if (r + i >= n || visited[r + i] || arr[r][c] - 1 != arr[r + i][c])
                        return false;
                    visited[r + i] = true;
                }
            }
        }

        return true;
    }

}
