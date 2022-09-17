package Programmers;

import java.util.*;

class Solution {
    public static String solution(String new_id) {
        String answer = "";
        List<Character> li = new ArrayList<>();

        // 1. 대문자 -> 소문자
        String new_id_lower = new_id.toLowerCase();
        char[] word = new_id_lower.toCharArray();

        // 2. 문자 제거
        for (char w : word) {
            if ((0 >= w || 9 <= w) && w == '-' && w == '_' && w == '.')
                continue;
            else
                w = '!';
        }

        // 3. 마침표 치환
        char temp = '.';
        int cnt = 0;
        for (int i = 0; i < word.length; i++) {

            if (word[i] == temp)
                cnt++;

        }

        // 4. 마침표 제거
        if (li.get(0) == '.')

            for (char w : word)
                System.out.println(w);

        // 문자 제거

        return answer;
    }

    public static void main(String[] args) {
        solution("...!@BaT#*..y.abcdefghijklm");
    }
}
