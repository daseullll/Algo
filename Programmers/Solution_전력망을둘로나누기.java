package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_전력망을둘로나누기 {

    static int[][] map;
    static int len;

    public static int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        len = n;

        map = new int[n + 1][n + 1];
        for (int i = 0; i < wires.length; i++) {
            map[wires[i][0]][wires[i][1]] = 1;
            map[wires[i][1]][wires[i][0]] = 1;
        }

        // --input end--
        for (int i = 0; i < wires.length; i++) {

            map[wires[i][0]][wires[i][1]] = 0;
            map[wires[i][1]][wires[i][0]] = 0;
            answer = Math.min(answer, bfs(1));
            map[wires[i][0]][wires[i][1]] = 1;
            map[wires[i][1]][wires[i][0]] = 1;
        }

        System.out.println(answer);
        return answer;
    }

    public static int bfs(int start) {

        Queue<Integer> queue = new LinkedList<>();
        boolean[] check = new boolean[len + 1];
        int cnt = 0;

        queue.add(start);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (check[cur])
                continue;
            for (int i = 1; i <= len; i++) {
                if (map[cur][i] == 1 && check[i] == false) {
                    queue.add(i);
                }
            }

            check[cur] = true;
            cnt++;
        }

        return Math.abs(len - 2 * cnt);

    }

    public static void main(String[] args) {
        int[][] wires = { { 1, 2 }, { 2, 7 }, { 3, 7 }, { 3, 4 }, { 4, 5 }, { 6, 7 } };

        solution(7, wires);
    }

}
