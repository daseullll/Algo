package Programmers;

import java.util.Stack;

public class Solution_괄호회전하기 {

    public static int solution(String s) {
        int answer = 0;
        char[] word = s.toCharArray();

        int count = 0;
        while (count != word.length) {

            Stack<Character> st = new Stack<>();
            boolean check = true;
            for (int i = 0; i < word.length; i++) {

                if (word[i] == '{' || word[i] == '(' || word[i] == '[') {
                    st.add(word[i]);
                    continue;
                }

                if (st.isEmpty()) {
                    check = false;
                    break;
                }
                char next = st.pop();
                if (word[i] == '}') {
                    if (next != '{')
                        check = false;
                } else if (word[i] == ']') {
                    if (next != '[')
                        check = false;
                } else if (word[i] == ')') {
                    if (next != '(')
                        check = false;
                }

            }

            if (check && st.isEmpty())
                answer++;

            // 왼쪽으로 회전 시키기
            char temp = word[0];
            for (int i = 0; i < word.length - 1; i++) {
                word[i] = word[i + 1];
            }
            word[word.length - 1] = temp;

            count++;

        }
        return answer;
    }

    public static void main(String[] args) {
        String s = "{{{{{{";
        System.out.println(solution(s));
    }
}
