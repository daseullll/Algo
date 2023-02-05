package Programmers;

import java.util.Arrays;
import java.util.HashSet;

public class Solution_전화번호목록 {

    public static boolean solution(String[] phone_book) {
        boolean answer = true;

        HashSet<String> num = new HashSet<>();

        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length; i++) {
            String cur = phone_book[i];
            for (int j = 1; j < cur.length() + 1; j++) {
                String cur2 = phone_book[i].substring(0, j);
                System.out.println(cur2);
                if (num.contains(cur2)) {
                    answer = false;
                }
            }
            num.add(cur);

        }

        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {

        String[] phone_book = { "12", "123", "1235", "567", "88" };
        solution(phone_book);
    }
}
