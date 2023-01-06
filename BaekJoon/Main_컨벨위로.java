import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_컨벨위로 {
    static int N, K, move;
    static int[] heart;
    static boolean[] belt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        heart = new int[2 * N]; // 내구도
        move = 0; // 내구도 0 개수
        belt = new boolean[2 * N]; // 컨베이어 벨트
        int result = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 2 * N; i++) {
            heart[i] = Integer.parseInt(st.nextToken());
        }
        while (move < K) {
            lotate();

            for (int i = 2 * N - 1; i >= 0; i--) { // 먼저 올라간 로봇부터 이동시킴
                if (belt[i]) {
                    if (check(i)) { // 이동할 수 있는 조건 성립
                        belt[i] = false;
                        belt[(i + 1) % N] = true;
                        heart[(i + 1) % N] = heart[(i + 1) % N] - 1;
                        if (heart[(i + 1) % N] <= 0)
                            move++;
                        if (belt[N - 1])
                            belt[N - 1] = false;
                    }
                }
            }

            // 로봇 올리기
            if (heart[0] != 0) {
                belt[0] = true;
                heart[0] = heart[0] - 1;
                if (heart[0] <= 0)
                    move++;
            }

            result++;
        }

        System.out.println(result);
    }

    // 이동조건 => 이동하려는 칸이 빈칸이어야 하고, 내구도가 1이상
    public static boolean check(int cur) {
        if (belt[(cur + 1) % N] || heart[(cur + 1) % N] == 0) // 이동하려는 칸에 이미 로봇이 있고 내구도가 없을 경우
            return false;
        return true;
    }

    public static void lotate() {

        boolean save = belt[2 * N - 1];
        int save2 = heart[2 * N - 1];

        for (int i = 2 * N - 1; i >= 1; i--) {
            belt[i] = belt[i - 1];
            heart[i] = heart[i - 1];

            if (belt[N - 1]) {
                belt[N - 1] = false;
            }
        }

        belt[0] = save;
        heart[0] = save2;

    }
}
