import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_주사위굴리기 {

    static int[] dice;
    static int[][] delta = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken()); // 명령의 개수

        // [1]:윗면 [2]:정면 [3]:우 [4]:좌 [5]:뒷면 [6]:아랫면
        dice = new int[7];
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }

        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            // 1:동 2:서 3:북 4:남
            int dir = Integer.parseInt(st.nextToken());

            int rn = x + delta[dir - 1][0];
            int cn = y + delta[dir - 1][1];

            if (rn < 0 || rn >= n || cn < 0 || cn >= m)
                continue;

            if (dir == 1)
                right();
            else if (dir == 2)
                left();
            else if (dir == 3)
                up();
            else if (dir == 4)
                down();

            go(rn, cn);
            x = rn;
            y = cn;

            sb.append(dice[1] + "\n");

        }

        System.out.println(sb.toString());

    }

    public static void down() {
        int temp = dice[6];
        dice[6] = dice[2];
        dice[2] = dice[1];
        dice[1] = dice[5];
        dice[5] = temp;
    }

    public static void up() {
        int temp = dice[6];
        dice[6] = dice[5];
        dice[5] = dice[1];
        dice[1] = dice[2];
        dice[2] = temp;
    }

    public static void left() {
        int temp = dice[6];
        dice[6] = dice[4];
        dice[4] = dice[1];
        dice[1] = dice[3];
        dice[3] = temp;
    }

    public static void right() {
        int temp = dice[6];
        dice[6] = dice[3];
        dice[3] = dice[1];
        dice[1] = dice[4];
        dice[4] = temp;
    }

    public static void go(int x, int y) {
        if (map[x][y] == 0) {
            map[x][y] = dice[6];
        } else {
            dice[6] = map[x][y];
            map[x][y] = 0;
        }
    }
}
