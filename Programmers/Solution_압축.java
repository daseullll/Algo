package Programmers;

import java.util.*;

class Solution_압축 {

    static HashMap<String, Integer> dic;
    static int cnt;
    static List<Integer> answer;

    public static List<Integer> solution(String msg) {
        dic = new HashMap<>();
        cnt = 1;

        // 사전 알파벳 넣기
        for (char s = 'A'; s <= 'Z'; s++) {
            dic.put(s + "", cnt++);
        }

        answer = new ArrayList<>();

        char[] input = msg.toCharArray();
        // 사전에 값이 있다면 사전에 값이 없어질때까지 문자를 늘려가기
        int i;
        for (i = 0; i < input.length; i++) {
            int j = i + 1;
            String s = input[i] + "";
            String temp = s;
            while (j < input.length) {
                s = s + input[j];
                if (dic.containsKey(s)) { // 사전에 문자가 있을 경우
                    i++;
                    temp = s;
                } else { // 사전에 문자가 없을 경우
                    answer.add(dic.get(temp));
                    dic.put(s, cnt++);
                    break;
                }
            }

            if (j >= input.length) {
                answer.add(dic.get(input[i] + ""));
                System.out.println("i:" + i);
                System.out.println("j:" + j);
            }
        }

        System.out.println(dic.keySet());
        System.out.println("answer : ");
        for (int k : answer) {
            System.out.print(k + " ");
        }

        return answer;
    }

    public static void main(String[] args) {
        solution("TOBEORNOTTOBEORTOBEORNOT");

    }
}