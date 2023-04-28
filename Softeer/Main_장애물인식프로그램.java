package Softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_장애물인식프로그램 {

    static int n, cntB;
    static int[][] arr;
    static int[][] delta = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    static boolean[][] check;
    static ArrayList<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        check = new boolean[n][n];
        result = new ArrayList<Integer>();

        for (int i = 0; i < n; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                arr[i][j] = temp[j] - '0';
            }
        }

        // --input end--
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1 && !check[i][j]) {
                    check[i][j] = true;
                    cnt++;
                    cntB = 1;
                    dfs(i, j);
                    result.add(cntB);
                }
            }
        }

        int[] temp = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            temp[i] = result.get(i);
        }

        Arrays.sort(temp);

        System.out.println(cnt);

        for (int i = 0; i < temp.length; i++) {
            System.out.println(temp[i]);
        }

    }

    public static void dfs(int r, int c) {

        for (int dir = 0; dir < 4; dir++) {
            int rn = r + delta[dir][0];
            int cn = c + delta[dir][1];

            if (rn < 0 || rn >= n || cn < 0 || cn >= n || arr[rn][cn] == 0 || check[rn][cn])
                continue;

            check[rn][cn] = true;
            cntB++;
            dfs(rn, cn);
        }

    }
}
