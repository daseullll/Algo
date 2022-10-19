import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_로봇청소기 {
    static int N, M, result;
    static int[][] map;
    static boolean[][] check;
    static Node current;
    static Queue<Node> queue;
    static int[][] delta = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } }; // 북, 동, 남, 서
    static boolean finish, Rfinish;

    static class Node {
        int r, c, d;

        public Node(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        check = new boolean[N][M];
        result = 1;
        queue = new LinkedList<Node>();
        finish = false;
        Rfinish = false;

        st = new StringTokenizer(br.readLine());
        current = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()));

        queue.add(current);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        map[current.r][current.c] = 2;

        while (!queue.isEmpty() || finish != true) {
            Node node = queue.poll();
            // System.out.println(node.r + " " + node.c + " " + node.d);
            clean(node.r, node.c, node.d);
        }

        System.out.println(result);
    }

    public static void clean(int r, int c, int d) {

        if (!isPossible(r, c)) { // 네 곳 다 갈 곳이 없을 경우
            // 바라보는 방향으로 후진
            int rn = r + delta[(d + 2) % 4][0];
            int cn = c + delta[(d + 2) % 4][1];
            if (rn < 0 || rn >= N || cn < 0 || cn >= M || map[rn][cn] == 1) {
                // System.out.println("finish");
                finish = true;
                return;
            }
            // System.out.println("not finish");
            queue.add(new Node(rn, cn, d));
            return;

        }

        // 왼쪽 방향
        int rn = r + delta[(d + 3) % 4][0];
        int cn = c + delta[(d + 3) % 4][1];

        // 왼쪽 방향에 청소할 공간이 없을 경우
        if (rn < 0 || rn >= N || cn < 0 || cn >= M || map[rn][cn] == 1 || map[rn][cn] == 2) {
            // System.out.println("left not");
            queue.add(new Node(r, c, (d + 3) % 4));
            return;
        }
        // 왼쪽 방향에 청소할 공간이 있을 경우
        map[rn][cn] = 2;
        result++;
        queue.add(new Node(rn, cn, (d + 3) % 4));
    }

    public static boolean isPossible(int r, int c) { // 네 방향 중에 갈 곳이 있는지

        for (int dir = 0; dir < 4; dir++) {
            int rn = r + delta[dir][0];
            int cn = c + delta[dir][1];

            if (rn >= 0 && rn < N && cn >= 0 && cn < M && map[rn][cn] == 0) {
                return true;
            }
        }

        // System.out.println("false");
        return false;
    }

}
