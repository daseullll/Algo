import java.io.*;
import java.util.*;

public class Main_마법사상어와파이어볼 {

    static int n, m, k;
    static ArrayList<fire>[][] arr;
    static int[][] delta = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 } };

    static class fire {
        int r, c, m, s, d;

        public fire(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new ArrayList[n][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            if (arr[r][c] == null)
                arr[r][c] = new ArrayList<fire>();
            arr[r][c].add(new fire(r, c, m, s, d));

        }

        // --input end--
        // 이동
        while (k-- > 0) {

            ArrayList<fire>[][] arr_copy = new ArrayList[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] == null)
                        continue;

                    for (int p = 0; p < arr[i][j].size(); p++) {
                        fire cur = arr[i][j].get(p);
                        int rn = cur.r + delta[cur.d][0] * (cur.s % n);
                        int cn = cur.c + delta[cur.d][1] * (cur.s % n);

                        if (rn < 0)
                            rn = n - Math.abs(rn);
                        else if (rn >= n)
                            rn = rn - n;
                        if (cn < 0)
                            cn = n - Math.abs(cn);
                        else if (cn >= n)
                            cn = cn - n;

                        if (arr_copy[rn][cn] == null) {
                            arr_copy[rn][cn] = new ArrayList<>();
                        }
                        arr_copy[rn][cn].add(new fire(rn, cn, cur.m, cur.s, cur.d));
                    }

                }
            }

            // 2개 이상의 파이어볼 처리
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    if (arr_copy[i][j] == null || arr_copy[i][j].size() < 2)
                        continue;

                    int m = 0;
                    int s = 0;
                    boolean check1 = true;
                    boolean check2 = true;
                    int sz = arr_copy[i][j].size();
                    for (int p = 0; p < arr_copy[i][j].size(); p++) {
                        m += arr_copy[i][j].get(p).m;
                        s += arr_copy[i][j].get(p).s;
                        if (arr_copy[i][j].get(p).d % 2 == 0) {
                            check1 = false;
                        } else {
                            check2 = false;
                        }
                    }

                    arr_copy[i][j].clear();

                    if (m / 5 != 0) {
                        if (check1 || check2) {
                            arr_copy[i][j].add(new fire(i, j, m / 5, s / sz, 0));
                            arr_copy[i][j].add(new fire(i, j, m / 5, s / sz, 2));
                            arr_copy[i][j].add(new fire(i, j, m / 5, s / sz, 4));
                            arr_copy[i][j].add(new fire(i, j, m / 5, s / sz, 6));
                        } else {
                            arr_copy[i][j].add(new fire(i, j, m / 5, s / sz, 1));
                            arr_copy[i][j].add(new fire(i, j, m / 5, s / sz, 3));
                            arr_copy[i][j].add(new fire(i, j, m / 5, s / sz, 5));
                            arr_copy[i][j].add(new fire(i, j, m / 5, s / sz, 7));

                        }
                    }
                }
            }

            // 원래 배열에 복사
            arr = arr_copy;

        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == null)
                    continue;

                for (int p = 0; p < arr[i][j].size(); p++) {
                    result += arr[i][j].get(p).m;
                }
            }
        }

        System.out.println(result);

    }
}
