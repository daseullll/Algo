package Programmers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

class Solution_뉴스클러스터링 {
    public static int solution(String str1, String str2) {

        // 대문자 변환
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();

        for (int i = 0; i < str1.length() - 1; i++) {
            char first = str1.charAt(i);
            char second = str1.charAt(i + 1);

            if (first >= 'A' && first <= 'Z' && second >= 'A' && second <= 'Z') {
                list1.add(first + "" + second);
            }
        }
        for (int i = 0; i < str2.length() - 1; i++) {
            char first = str2.charAt(i);
            char second = str2.charAt(i + 1);

            if (first >= 'A' && first <= 'Z' && second >= 'A' && second <= 'Z') {
                list2.add(first + "" + second);
            }
        }

        // 정렬
        Collections.sort(list1);
        Collections.sort(list2);

        ArrayList<String> result1 = new ArrayList<>(); // 교집합
        ArrayList<String> result2 = new ArrayList<>(); // 합집합

        // 교집합
        // 집합1에서 하나씩 꺼내서 집합2와 비교한다.
        // 집합2에서 집합1 하나꺼낸 것이 지워진다면 같은 것이 존재한다는 의미
        // 중복되는 값이 있어도 최소 수로 들어간다.
        // 집합2에서 남은 것은 집합1과의 교집합을 뺀 것
        // 집합1은 바로 합집합으로 넣는다.
        for (String s : list1) {
            if (list2.remove(s))
                result1.add(s);
            result2.add(s);
        }

        // 합집합
        // 집합1이 들어가 있다.
        // 집합2에는 집합1과의 교집합을 뺀 나머지가 들어가 있다.
        for (String s : list2) {
            result2.add(s);
        }

        int answer = 65536;
        if (result2.size() != 0) {
            double answer2 = (double) result1.size() / (double) result2.size();
            answer = (int) (answer2 * 65536);
        }

        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        solution("E=M*C^2", "e=m*c^2");
    }
}