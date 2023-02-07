package Programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_기능개발 {

    public static ArrayList<Integer> solution(int[] progresses, int[] speeds) {

        ArrayList<Integer> answer = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> speed = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            queue.add(progresses[i]);
            speed.add(speeds[i]);
        }

        while (!queue.isEmpty()) {

            for (int i = 0; i < queue.size(); i++) {
                int current = queue.poll();
                int cur2 = speed.poll();
                queue.add(current + cur2);

                speed.add(cur2);
            }

            boolean check = false;
            int cnt = 0;
            while (!check) {
                if (queue.isEmpty())
                    break;
                if (queue.peek() < 100)
                    check = true;
                else {
                    queue.poll();
                    speed.poll();
                    cnt++;
                }
            }

            if (cnt != 0)
                answer.add(cnt);

        }

        return answer;
    }

    public static void main(String[] args) {
        int[] progresses = { 95, 90, 99, 99, 80, 99 };
        int[] speeds = { 1, 1, 1, 1, 1, 1 };

        solution(progresses, speeds);
    }

}
