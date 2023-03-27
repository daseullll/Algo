public class Solution_예상대진표 {

    public static int solution(int n, int a, int b) {
        int answer = 0;

        while (Math.abs(a - b) != 1 || Math.max(a, b) % 2 != 0) {
            a = (a % 2 == 0) ? a / 2 : (a + 1) / 2;
            b = (b % 2 == 0) ? b / 2 : (b + 1) / 2;

            answer++;
        }

        return answer + 1;
    }

    public static void main(String[] args) {
        solution(100, 3, 4);
    }
}
