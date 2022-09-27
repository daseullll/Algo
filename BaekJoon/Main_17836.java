import java.io.*;
import java.util.*;

public class Main_17836 {
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
        queue = new LinkedList<Node>();
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

        queue.add(new Node(0, 0, 0));

        while (!queue.isEmpty()) {
            bfs(queue.poll());
        }
        if (result == Integer.MAX_VALUE)
            sb.append("Fail");
        else
            sb.append(result);
        System.out.println(sb.toString());

    }

    public static void bfs(Node current) {
        int r = current.r;
        int c = current.c;
        int dis = current.dis;

        check[r][c] = true;

        if (dis > T)
            return;
        if (r == gramX && c == gramY) {
            dis = dis + ((N - 1) - r) + ((M - 1) - c);
            if (dis <= T)
                result = Math.min(result, dis);
            return;
        }
        if (r == N - 1 && c == M - 1) {
            result = Math.min(result, dis);
            return;
        }

        for (int dir = 0; dir < 4; dir++) {
            int rn = r + delta[dir][0];
            int cn = c + delta[dir][1];
            if (rn < 0 || cn < 0 || rn >= N || cn >= M || check[rn][cn] == true || map[rn][cn] == 1) {
                continue;
            }
            queue.add(new Node(rn, cn, dis + 1));
        }
    }

}