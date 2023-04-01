import java.util.Stack;

public class Solution_큰수만들기 {

    public static String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        char[] result = new char[number.length() - k];

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop();
            }
            stack.push(c);
        }

        for (int i = 0; i < result.length; i++) {
            answer.append(stack.get(i));
        }

        return answer.toString();

    }

    public static void main(String[] args) {
        solution("4177252841", 9);
    }
}
