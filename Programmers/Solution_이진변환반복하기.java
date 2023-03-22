package Programmers;

import java.util.Stack;

public class Solution_이진변환반복하기 {

    static int zero = 0;

    public static int[] solution(String s) {
        int[] answer = new int[2];

        int count = 0;
        while (s.length() != 1) {

            count++;
            // 1. 0 제거 하기
            s = remove(s);

            // 2. 0 제거 후 문자열 길이를 이진 변환하기
            s = change(s);

        }

        answer[1] = zero;
        answer[0] = count;

        System.out.println(answer[0]);
        System.out.println(answer[1]);
        return answer;
    }

    public static String remove(String s) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                zero++;
                continue;
            }

            sb.append("1");
        }
        return sb.toString();
    }

    public static String change(String s) {
        Stack<Integer> temp = new Stack<>();

        int num = s.length();

        while (num != 1) {
            temp.push(num % 2);
            num = num / 2;
        }
        temp.push(1);

        StringBuilder sb = new StringBuilder();

        while (!temp.isEmpty()) {
            sb.append(temp.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        solution("110010101001");
        // solution("1111111");
    }
}
