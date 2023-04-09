package SWEA;

import java.io.BufferedReader;
import java.io.*;
import java.util.*;

public class Solution_등산로조성 {

    static class Node {
        int r, c, h;

        public Node(int r, int c, int h) {
            this.r = r;
            this.c = c;
            this.h = h;
        }
    }

    static Queue<Node> queue;
    static boolean[][] visited;
    static int[][] arr;
    static int n, k, result;
    static int[][] delta = { { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } }; // 좌,하,우,상

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            arr = new int[n][n];
            int maxh = -1;
            queue = new LinkedList<>();
            result = -1;

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    maxh = Math.max(maxh, arr[i][j]);
                }
            }

            // --input end--
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] == maxh) {
                        queue.add(new Node(i, j, arr[i][j]));
                    }
                }
            }

            int[][] temp = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    temp[i][j] = arr[i][j];
                }
            }

            int limit = k;
            while (!queue.isEmpty()) {
                visited = new boolean[n][n];
                Node n = queue.poll();
                visited[n.r][n.c] = true;
                for (int kk = 1; kk <= limit; kk++) {
                    k = kk;
                    dfs(n, false, 1);
                }
                // System.out.println("--");
            }

            sb.append("#" + tc + " " + result + "\n");
        }

        System.out.println(sb.toString());
    }

    public static int dfs(Node current, boolean check, int sum) {

        result = Math.max(result, sum);
        // System.out.println(current.r + " " + current.c + " " + sum);

        for (int dir = 0; dir < 4; dir++) {
            int rn = current.r + delta[dir][0];
            int cn = current.c + delta[dir][1];

            if (rn < 0 || rn >= n || cn < 0 || cn >= n || visited[rn][cn] || current.h == 0)
                continue;

            // 깎아서 넘어갈 수 있는 경우
            if (arr[rn][cn] >= current.h) {
                if (check || arr[rn][cn] - k >= current.h) {
                    continue;
                } else {
                    check = true;
                    int next = arr[rn][cn] - k;
                    visited[rn][cn] = true;
                    dfs(new Node(rn, cn, next), check, sum + 1);
                    visited[rn][cn] = false;
                    check = false;
                    continue;
                }
            }

            // 넘어갈 수 있는 경우
            visited[rn][cn] = true;
            dfs(new Node(rn, cn, arr[rn][cn]), check, sum + 1);
            visited[rn][cn] = false;
        }

        return sum;

    }
}
