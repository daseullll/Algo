import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_상어초등학교 {

    static class Node {
        int a, b, c, d;

        public Node(int a, int b, int c, int d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }
    }

    static int[][] arr, empty;
    static int n;
    static int[][] delta = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    static Node[] like;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        like = new Node[(n * n) + 1];
        arr = new int[n][n];
        empty = new int[n][n];

        for (int i = 0; i < n * n; i++) {
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());
            int three = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());

            Node nd = new Node(one, two, three, f);
            like[index] = nd;

            // --input end--

            cnt();
            int[][] arr2 = cnt2(one, two, three, f);
            sit(arr2, index, one, two, three, f);

        }

        System.out.println(score());

    }

    // 비어있는 칸을 세는 함수
    public static void cnt() {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = 0;
                for (int dir = 0; dir < 4; dir++) {
                    int rn = i + delta[dir][0];
                    int cn = j + delta[dir][1];
                    if (rn < 0 || rn >= n || cn < 0 || cn >= n || arr[rn][cn] > 0) {
                        continue;
                    }
                    num++;
                }

                empty[i][j] = num;

            }
        }
    }

    // 친한친구가 있는 칸을 세는 함수
    public static int[][] cnt2(int a, int b, int c, int d) {

        int[][] friend = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int temp = 0;
                for (int dir = 0; dir < 4; dir++) {
                    int rn = i + delta[dir][0];
                    int cn = j + delta[dir][1];
                    if (rn < 0 || rn >= n || cn < 0 || cn >= n) {
                        continue;
                    }

                    if (arr[rn][cn] == a || arr[rn][cn] == b || arr[rn][cn] == c || arr[rn][cn] == d) {
                        temp++;
                    }
                }

                friend[i][j] = temp;

            }
        }

        return friend;
    }

    public static void sit(int[][] friend, int num, int a, int b, int c, int d) {

        int fav = 0;
        int favI = 0;
        int favJ = 0;
        int emptyNum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] > 0)
                    continue;

                if (fav < friend[i][j]) {

                    fav = friend[i][j];
                    favI = i;
                    favJ = j;
                    emptyNum = empty[i][j];

                } else if (fav == friend[i][j]) {

                    if (emptyNum < empty[i][j]) {
                        fav = friend[i][j];
                        favI = i;
                        favJ = j;
                        emptyNum = empty[i][j];
                    } else if (emptyNum == empty[i][j]) {

                        if (arr[favI][favJ] != 0) {
                            favI = i;
                            favJ = j;
                            continue;
                        }
                        if (favI > i) {
                            favI = i;
                            favJ = j;
                        } else if (favI == i) {
                            favJ = Math.min(favJ, j);
                        }
                    }

                }

            }
        }

        arr[favI][favJ] = num;

    }

    public static int score() {

        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Node current = like[arr[i][j]];
                int a = current.a;
                int b = current.b;
                int c = current.c;
                int d = current.d;
                int temp = 0;
                for (int dir = 0; dir < 4; dir++) {
                    int rn = i + delta[dir][0];
                    int cn = j + delta[dir][1];
                    if (rn < 0 || rn >= n || cn < 0 || cn >= n) {
                        continue;
                    }

                    if (arr[rn][cn] == a || arr[rn][cn] == b || arr[rn][cn] == c || arr[rn][cn] == d) {
                        temp++;
                    }
                }

                if (temp == 1) {
                    sum += 1;
                } else if (temp == 2) {
                    sum += 10;
                } else if (temp == 3) {
                    sum += 100;
                } else if (temp == 4) {
                    sum += 1000;
                }
            }
        }

        return sum;
    }

}
