import java.io.*;
import java.util.*;

public class Main_공주님을구해라 {
    static int N, M, T, result;
    static int[][] delta = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
    static int[][] map;
    static int gramX, gramY;
    static Queue<Node> queue;
    static boolean[][] check;

    static class Node {
        int r, c, dis;

        public Node(int r, int c, int dis) {
            this.r = r;
            this.c = c;
            this.dis = dis;
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        result = Integer.MAX_VALUE;

        map = new int[N][M];
        check = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    gramX = i;
                    gramY = j;
                }
            }
        }

        bfs();

        if (result == Integer.MAX_VALUE)
            sb.append("Fail");
        else
            sb.append(result);
        System.out.println(sb.toString());

    }

    public static void bfs() {

        queue = new LinkedList<Node>();
        queue.add(new Node(0, 0, 0));
        check[0][0] = true;

        Loop: while (!queue.isEmpty()) {
            Node current = queue.poll();
            int r = current.r;
            int c = current.c;
            int dis = current.dis;

            if (dis > T)
                continue;

            if (r == N - 1 && c == M - 1) {
                result = Math.min(result, dis);
                break;
            }

            for (int dir = 0; dir < 4; dir++) {
                int rn = r + delta[dir][0];
                int cn = c + delta[dir][1];
                if (rn < 0 || cn < 0 || rn >= N || cn >= M || check[rn][cn] == true || map[rn][cn] == 1) {
                    continue;
                }
                if (map[rn][cn] == 2) {
                    queue.add(new Node(rn, cn, dis + 1));
                }

                // 그람을 발견했을때
                if (rn == gramX && cn == gramY) {
                    dis = dis + ((N - 1) - rn) + ((M - 1) - cn) + 1;
                    if (dis <= T) {
                        result = Math.min(result, dis);
                        continue Loop;
                    }
                } else {
                    check[rn][cn] = true;
                }

                queue.add(new Node(rn, cn, dis + 1));
            }

        }
    }

}