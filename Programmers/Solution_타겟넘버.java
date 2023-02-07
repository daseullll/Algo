package Programmers;

public class Solution_타겟넘버 {

    static int answer = 0;

    public static int solution(int[] numbers, int target) {

        dfs(numbers, 0, 0, target);

        return answer;
    }

    public static void dfs(int[] numbers, int start, int cnt, int target) {

        if (start == numbers.length) {
            if (target == cnt) {
                answer++;
            }
            return;
        }

        dfs(numbers, start + 1, cnt + numbers[start], target);
        dfs(numbers, start + 1, cnt - numbers[start], target);

    }

    public static void main(String[] args) {
        int numbers[] = { 1, 1, 1, 1, 1 };
        int target = 3;

        solution(numbers, target);

    }

}
