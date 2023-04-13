public class Solution_cj1 {

    public static int solution(String number) {
        int answer = 0;

        for (int i = 0; i < number.length(); i++) {
            int now = number.charAt(i) - '0';
            int next = -2;
            if (i < number.length() - 1) {
                next = number.charAt(i + 1) - '0';
            }

            answer++;
            System.out.println(now);

            if (now == 0)
                continue;
            if (next == now + 1) {
                i++;
                System.out.println(next);

            } else {
                answer++;
            }

        }

        System.out.println(answer + " " + answer);

        return answer;
    }

    public static void main(String[] args) {
        solution("100");
    }
}
