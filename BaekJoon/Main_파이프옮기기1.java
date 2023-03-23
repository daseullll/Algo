import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_파이프옮기기1 {

    static int[][] a = { { 0, 1 }, { 1, 1 } }; // 가로
    static int[][] b = { { 1, 0 }, { 1, 1 } }; // 세로
    static int[][] d = { { 0, 1 }, { 1, 0 }, { 1, 1 } }; // 대각선
    static Queue<pipe> queue;
    static int n, result;
    static int[][] arr;

    static class pipe {
        int r, c, dir;

        public pipe(int r, int c, int dir) {
            this.r = r;
            this.c = c;
            this.dir = dir;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        queue = new LinkedList<>();
        result = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if (arr[n][n] == 1) {
            System.out.println(0);
            return;
        }

        // --input end--
        // 0:가로 1:세로 2:대각선
        queue.offer(new pipe(0, 1, 0));
        go();

        // System.out.println(result);
        StringBuilder sb = new StringBuilder();
        sb.append(result);
        System.out.println(sb.toString());

    }

    public static void go() {

        while (!queue.isEmpty()) {
            pipe current = queue.poll();
            int r = current.r;
            int c = current.c;
            int dir = current.dir;

            if (r == n - 1 && c == n - 1) {
                result++;
                continue;
            }

            if (dir == 0)
                one(r, c);
            else if (dir == 1)
                two(r, c);
            else if (dir == 2)
                three(r, c);
        }
    }

    // 가로
    public static void one(int r, int c) {

        for (int i = 0; i < 2; i++) {
            int rn = r + a[i][0];
            int cn = c + a[i][1];

            if (rn >= n || cn >= n || arr[rn][cn] == 1)
                break;

            if (i == 0)
                queue.offer(new pipe(rn, cn, 0));
            if (i == 1 && arr[rn][cn - 1] != 1) // 대각선
                queue.offer(new pipe(rn, cn, 2));

        }
    }

    // 세로
    public static void two(int r, int c) {

        for (int i = 0; i < 2; i++) {
            int rn = r + b[i][0];
            int cn = c + b[i][1];

            if (rn >= n || cn >= n || arr[rn][cn] == 1)
                break;

            if (i == 0)
                queue.offer(new pipe(rn, cn, 1));
            if (i == 1 && arr[rn - 1][cn] != 1)
                queue.offer(new pipe(rn, cn, 2));
        }
    }

    // 대각선
    public static void three(int r, int c) {

        for (int i = 0; i < 3; i++) {
            int rn = r + d[i][0];
            int cn = c + d[i][1];

            if (rn >= n || cn >= n || arr[rn][cn] == 1)
                continue;

            if (i == 0 || i == 1)
                queue.offer(new pipe(rn, cn, i));
            if (i == 2 && arr[rn - 1][cn] != 1 && arr[rn][cn - 1] != 1)
                queue.offer(new pipe(rn, cn, i));
        }
    }

}
