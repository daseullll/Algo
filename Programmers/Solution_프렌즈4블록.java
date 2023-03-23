
public class Solution_프렌즈4블록 {

    static char[][] map;
    static int m, n;
    static int[][] delta = { { 0, 1 }, { 1, 1 }, { 1, 0 } };
    static int result = 0;
    static boolean[][] check;

    public static int solution(int mm, int nn, String[] board) {

        map = new char[mm][nn];
        m = mm;
        n = nn;
        for (int i = 0; i < board.length; i++) {
            map[i] = board[i].toCharArray();
        }

        // --input end--
        while (true) {

            check = new boolean[m][n];
            if (!remove())
                break;
            down();
        }

        System.out.println(result);
        return result;
    }

    // 2x2 찾아서 없애기
    // 없앨 것이 있는지 확인하는 함수 => 없다면 게임 종료
    public static boolean remove() {
        boolean go = false;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char now = map[i][j];
                if (now < 'A' || now > 'Z')
                    continue;
                for (int dir = 0; dir < 3; dir++) {
                    int xn = i + delta[dir][0];
                    int yn = j + delta[dir][1];

                    if (xn < 0 || xn >= m || yn < 0 || yn >= n || map[xn][yn] != now || map[xn][yn] == '.') {
                        break;
                    }

                    if (map[xn][yn] < 'A' || map[xn][yn] > 'Z')
                        break;

                    if (dir == 2) {
                        go = true;
                        if (!check[i][j]) {
                            check[i][j] = true;
                            result++;
                        }
                        if (!check[i][j + 1]) {
                            check[i][j + 1] = true;
                            result++;

                        }
                        if (!check[i + 1][j + 1]) {
                            check[i + 1][j + 1] = true;
                            result++;
                        }
                        if (!check[i + 1][j]) {
                            check[i + 1][j] = true;
                            result++;
                        }

                    }

                }
            }
        }
        return go;
    }

    // 블록 아래로 내리기
    public static void down() {

        for (int i = m - 1; i >= 0; i--) {
            Loop: for (int j = 0; j < n; j++) {
                if (check[i][j] || map[i][j] == '.') {
                    int xn = i;
                    while (true) {
                        xn = xn - 1;
                        if (xn < 0)
                            break;
                        if (!check[xn][j] && map[xn][j] != '.') {
                            map[i][j] = map[xn][j];
                            map[xn][j] = '.';
                            continue Loop;
                        }
                    }
                    map[i][j] = '.';
                }
            }

        }
    }

    public static void main(String[] args) {
        String[] board = { "HGNHU", "CRSHV", "UKHVL", "MJHQB", "GSHOT", "MQMJJ", "AGJKK", "QULKK" };
        solution(8, 5, board);
    }
}
