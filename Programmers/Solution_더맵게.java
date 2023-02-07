package Programmers;

import java.util.PriorityQueue;

public class Solution_더맵게 {

    public static int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            queue.add(scoville[i]);
        }

        // 두번 빼기
        while (true) {

            if (queue.isEmpty()) {
                answer = -1;
                break;
            }

            int first = queue.poll();
            if (first >= K)
                break;

            int second = 0;
            if (!queue.isEmpty()) {
                second = queue.poll();
                queue.add(first + (second * 2));
                answer++;
            }
        }

        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        int[] scoville = { 1, 2, 3, 9, 10, 12 };
        solution(scoville, 7);
    }

}
