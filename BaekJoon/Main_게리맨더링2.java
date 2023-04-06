import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_게리맨더링2 {

    static int n, total;
    static int[][] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1][n + 1];
        total = 0;

        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                total += arr[i][j];
            }
        }

        // --input end--
        int dif = Integer.MAX_VALUE;
        for (int x = 1; x <= n; x++) {
            for (int y = 1; y <= n; y++) {
                for (int d1 = 1; d1 <= n; d1++) {
                    for (int d2 = 1; d2 <= n; d2++) {
                        if (x + d1 + d2 > n)
                            continue;
                        if (y - d1 < 1)
                            continue;
                        if (y + d2 > n)
                            continue;

                        dif = Math.min(dif, go(x, y, d1, d2));
                    }
                }
            }
        }

        System.out.println(dif);

    }

    public static int go(int x, int y, int d1, int d2) {

        int[][] arr2 = new int[n + 1][n + 1];
        int[] people = new int[6];

        // 경계선 그리기
        arr2[x][y] = 5;
        for (int i = 1; i <= d1; i++) {
            arr2[x + i][y - i] = 5;
        }
        for (int i = 1; i <= d2; i++) {
            arr2[x + i][y + i] = 5;
        }
        for (int i = 1; i <= d2; i++) {
            arr2[x + d1 + i][y - d1 + i] = 5;
        }
        for (int i = 1; i <= d1; i++) {
            arr2[x + d2 + i][y + d2 - i] = 5;
        }

        // 1선거구
        for (int i = 1; i < x + d1; i++) {
            for (int j = 1; j <= y; j++) {
                if (arr2[i][j] == 5)
                    break;

                people[1] += arr[i][j];
            }
        }

        // 2선거구
        for (int i = 1; i <= x + d2; i++) {
            for (int j = n; j > y; j--) {
                if (arr2[i][j] == 5)
                    break;

                people[2] += arr[i][j];
            }
        }

        // 3선거구
        for (int i = x + d1; i <= n; i++) {
            for (int j = 1; j < y - d1 + d2; j++) {
                if (arr2[i][j] == 5)
                    break;

                people[3] += arr[i][j];
            }
        }

        // 4선거구
        for (int i = x + d2 + 1; i <= n; i++) {
            for (int j = n; j >= y - d1 + d2; j--) {
                if (arr2[i][j] == 5)
                    break;

                people[4] += arr[i][j];
            }
        }

        people[5] = total - (people[1] + people[2] + people[3] + people[4]);
        int max = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= 5; i++) {
            max = Math.max(people[i], max);
            min = Math.min(people[i], min);
        }

        return max - min;
    }
}
