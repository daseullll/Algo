import java.util.*;

public class Solution_n진수게임 {
    /**
     * 10진수를 제외한 나머지 진수는 String으로 받아야 한다. -> int는 모두 10진수로 인식
     * 2진수, 8진수, 16진수는 Binary, Octal, Hex 함수가 존재한다.
     * ** Integer.toString(int n, int radix) **로 사용해도 된다.
     */

    /**
     * 자바 변수 타입은 변수명.getClass().getName()으로 확인한다.
     * String ,Integer, ArrayList로 데이터타입이 나온다.
     */

    public static String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();

        Queue<Character> queue = new LinkedList<>();
        int cnt = 0;
        int finish = t * m;
        while (finish > 0) {

            // n진수로 변경
            String num = Integer.toString(cnt, n);

            // 자릿수 만큼 반복해서 큐에 넣기
            for (int i = 0; i < num.length(); i++) {
                finish--;
                System.out.println(num.charAt(i));
                queue.add(num.charAt(i));
            }

            cnt++;

        }

        int a = 1;
        int pp = p;
        while (answer.length() < t) {
            Character num = queue.poll();
            if (num >= 'a' && num <= 'z') {
                num = (char) (num - 32);
            }

            if (a == pp) {
                answer.append(num);
                pp += m;
            }

            a++;
        }

        return answer.toString();
    }

    public static void main(String[] args) {

        solution(2, 4, 2, 1);
    }
}
