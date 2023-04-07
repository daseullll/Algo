package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_미생물격리 {

    static class Node {
        int r, c, num, dir;

        public Node(int r, int c, int num, int dir) {
            this.r = r;
            this.c = c;
            this.num = num;
            this.dir = dir;
        }
    }

    static Queue<Node> queue;
    static int[][] arr;
    static int[][] delta = { { 0, 0 }, { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= t; tc++) {
            sb.append("#" + tc + " ");
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            queue = new LinkedList<>();
            arr = new int[n][n];

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                queue.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));

            }

            // --input end--

            for (int i = 0; i < m; i++) {
                go();
            }

            int result = 0;
            while (!queue.isEmpty()) {
                result += queue.poll().num;
            }

            sb.append(result + "\n");

        }

        System.out.println(sb.toString());

    }

    public static void go() {

        ArrayList<Node>[][] check = new ArrayList[n][n];

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            int dir = cur.dir;
            int rn = cur.r + delta[dir][0];
            int cn = cur.c + delta[dir][1];
            int num = cur.num;

            if (rn == 0 || cn == 0 || rn == n - 1 || cn == n - 1) {
                num /= 2;

                if (dir == 1)
                    dir = 2;
                else if (dir == 2)
                    dir = 1;
                else if (dir == 3)
                    dir = 4;
                else
                    dir = 3;
            }

            if (check[rn][cn] == null) {
                check[rn][cn] = new ArrayList<>();
                check[rn][cn].add(new Node(rn, cn, num, dir));
            } else {
                check[rn][cn].add(new Node(rn, cn, num, dir));
            }

        }

        go2(check);

    }

    public static void go2(ArrayList<Node>[][] check) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (check[i][j] == null)
                    continue;
                if (check[i][j].size() > 1) {
                    int sum = 0;
                    int max = 0;
                    int dir = 0;
                    for (Node n : check[i][j]) {
                        sum += n.num;
                        if (n.num > max) {
                            dir = n.dir;
                            max = n.num;
                        }
                    }

                    queue.add(new Node(i, j, sum, dir));
                } else if (check[i][j].size() == 1) {
                    queue.add(check[i][j].get(0));
                }
            }
        }
    }
}
