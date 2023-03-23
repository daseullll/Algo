import java.util.Stack;

public class Solution_짝지어제거하기 {

    public static int solution(String s) {
        int answer = -1;
        Stack<Character> stack = new Stack<>();

        int cnt = 0;
        while (cnt != s.length()) {

            if (!stack.isEmpty()) {
                if (stack.peek() == s.charAt(cnt)) {
                    stack.pop();
                    cnt++;
                    continue;
                }
            }

            stack.push(s.charAt(cnt));
            cnt++;
        }

        if (stack.isEmpty())
            answer = 1;

        else
            answer = 0;

        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        solution("cdcd");
    }
}
