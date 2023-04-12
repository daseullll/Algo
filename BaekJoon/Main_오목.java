import java.io.*;
import java.util.*;

public class Main_오목 {

    static int[][] delta = { { 1, -1 }, { 0, 1 }, { 1, 1 }, { 1, 0 } };
    static int[][] arr;
    static boolean[][][] check;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        arr = new int[19][19];
        check = new boolean[19][19][4];
        for (int i = 0; i < 19; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // --input end--
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (arr[i][j] > 0) {
                    for (int dir = 0; dir < 4; dir++) {

                        if (!check[i][j][dir] && dfs(i, j, dir, arr[i][j]) == 5) {
                            System.out.println(arr[i][j]);
                            if (dir == 0)
                                System.out.println((i + 5) + " " + (j - 3));
                            else
                                System.out.println((i + 1) + " " + (j + 1));
                            return;
                        }

                    }
                }
            }
        }

        System.out.println("0");

    }

    public static int dfs(int r, int c, int dir, int color) {

        int rn = r + delta[dir][0];
        int cn = c + delta[dir][1];

        if (rn >= 0 && rn < 19 && cn >= 0 && cn < 19 && arr[rn][cn] == color) {
            check[rn][cn][dir] = true;
            return dfs(rn, cn, dir, color) + 1;
        }

        return 1;
    }

}
