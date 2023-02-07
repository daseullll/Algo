package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_게임맵최단거리 {

    static Queue<Node> queue;
    static int min, m, n;
    static int[][] delta = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    static boolean[][] visited;
    static int[][] map;

    public static class Node {
        int r, c, dis;

        public Node(int r, int c, int dis) {
            this.r = r;
            this.c = c;
            this.dis = dis;
        }
    }

    public static int solution(int[][] maps) {
        int answer = 0;

        n = maps.length;
        m = maps[0].length;

        queue = new LinkedList<>();
        min = Integer.MAX_VALUE;
        visited = new boolean[n][m];
        map = maps;
        visited[0][0] = true;
        queue.add(new Node(0, 0, 1));

        while (!queue.isEmpty()) {
            bfs();
        }

        if (min == Integer.MAX_VALUE)
            answer = -1;
        else
            answer = min;

        System.out.println(answer);

        return answer;
    }

    public static void bfs() {

        Node cur = queue.poll();
        int r = cur.r;
        int c = cur.c;
        System.out.println("r:" + r + " c:" + c);

        if (r == n - 1 && c == m - 1) {
            min = Math.min(min, cur.dis);
            return;
        }

        for (int dir = 0; dir < 4; dir++) {
            int rn = r + delta[dir][0];
            int cn = c + delta[dir][1];

            if (rn < 0 || cn < 0 || rn >= n || cn >= m || visited[rn][cn] || map[rn][cn] == 0) {
                continue;
            }

            queue.add(new Node(rn, cn, cur.dis + 1));
            visited[rn][cn] = true;

        }

    }

    public static void main(String[] args) {
        int[][] maps = { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 1 } };

        solution(maps);
    }

}
