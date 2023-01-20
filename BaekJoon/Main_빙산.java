import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_빙산 {
    static int N, M;
    static int[][] arr;
    static Queue<Node> ice;
    static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public static class Node {
        int r, c, h;

        public Node(int r, int c, int h) {
            this.r = r;
            this.c = c;
            this.h = h;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        ice = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] > 0) {
                    ice.offer(new Node(i, j, arr[i][j]));
                }
            }
        }

        // --input end--

        int year = 0;
        while (true) {
            // 1. 덩어리로 분리된 곳이 있는지 확인 -> 있으면 멈추기
            if (separate() >= 2) {
                System.out.println(year);
                return;
            }

            // 2. 없으면 일년 시간 경과시키기, year++
            year++;
            bfs();

            // 3. 만약 녹일 빙산이 없다면(큐가 비어있음) 멈추고 0 출력
            if (ice.isEmpty()) {
                System.out.println(0);
                return;
            }
        }

    }

    public static void bfs() {

        int len = ice.size();
        int cnt = 0;
        boolean[][] visited = new boolean[N][M];

        while (cnt < len) {
            int minus = 0;
            Node cur = ice.poll();
            visited[cur.r][cur.c] = true;
            cnt++;

            for (int dir = 0; dir < 4; dir++) {
                int rn = cur.r + delta[dir][0];
                int cn = cur.c + delta[dir][1];

                if (rn < 0 || rn >= N || cn < 0 || cn >= M || arr[rn][cn] > 0 || visited[rn][cn])
                    continue;

                if (arr[rn][cn] == 0 && !visited[rn][cn])
                    minus++;
            }

            if (cur.h - minus > 0) {
                arr[cur.r][cur.c] = cur.h - minus;
                ice.offer(new Node(cur.r, cur.c, cur.h - minus));
            } else {
                arr[cur.r][cur.c] = 0;
            }

        }
    }

    // 덩어리로 분리된 곳이 있는지 확인
    public static int separate() {
        boolean[][] visited = new boolean[N][M];

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] != 0 && !visited[i][j]) {
                    dfs(i, j, visited);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public static void dfs(int x, int y, boolean[][] visited) {
        visited[x][y] = true;

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + delta[dir][0];
            int ny = y + delta[dir][1];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M)
                continue;
            if (arr[nx][ny] != 0 && !visited[nx][ny])
                dfs(nx, ny, visited);
        }
    }

}
