import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_토마토 {

    static int N, M, H;
    static ArrayList<int[][]> tomato;
    static Queue<Node> queue;
    static int[][] delta = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    static int result = 0;
    static int tomatoCnt = 0;

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

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        tomato = new ArrayList<int[][]>();
        queue = new LinkedList<>();

        for (int i = 0; i < H; i++) {
            int[][] arr = new int[N][M];
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                    if (arr[j][k] == 1)
                        queue.offer(new Node(j, k, i));
                    else if (arr[j][k] == 0)
                        tomatoCnt++;
                }
            }
            tomato.add(arr);
        }

        // --input end--
        if (tomatoCnt == 0)
            System.out.println(result);
        else {
            move();
            if (tomatoCnt != 0)
                System.out.println(-1);
            else
                System.out.println(result - 1);
        }

    }

    public static void move() {

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int[][] toma = tomato.get(current.h);
            for (int dir = 0; dir < 4; dir++) { // 같은 칸의 상하좌우
                int rn = current.r + delta[dir][0];
                int cn = current.c + delta[dir][1];
                if (rn < 0 || rn >= N || cn < 0 || cn >= M || toma[rn][cn] != 0)
                    continue;

                toma[rn][cn] = toma[current.r][current.c] + 1;
                result = Math.max(result, toma[rn][cn]);
                tomatoCnt--;
                queue.add(new Node(rn, cn, current.h));
            }
            tomato.set(current.h, toma); // 갱신

            int up = current.h + 1;
            int down = current.h - 1;

            // 위쪽 판
            if (up < H) {
                int[][] toma2 = tomato.get(up);
                if (toma2[current.r][current.c] == 0) {
                    toma2[current.r][current.c] = toma[current.r][current.c] + 1;
                    result = Math.max(result, toma2[current.r][current.c]);
                    tomatoCnt--;
                    queue.add(new Node(current.r, current.c, up));
                    tomato.set(up, toma2); // 갱신
                }
            }

            // 아래 판
            if (down >= 0) {
                int[][] toma2 = tomato.get(down);
                if (toma2[current.r][current.c] == 0) {
                    toma2[current.r][current.c] = toma[current.r][current.c] + 1;
                    result = Math.max(result, toma2[current.r][current.c]);
                    tomatoCnt--;
                    queue.add(new Node(current.r, current.c, down));
                    tomato.set(down, toma2); // 갱신
                }
            }

        }
    }

}
