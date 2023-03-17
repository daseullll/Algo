package Programmers;

public class Solution_덧칠하기 {

    public static int solution(int n, int m, int[] section) {
        int answer = 0;

        int max = 0;
        for (int i = 0; i < section.length; i++) {
            if (max <= section[i]) {
                max = section[i] + m;
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        int[] section = { 2, 3, 6 };
        solution(8, 4, section);

    }
}
