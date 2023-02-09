package Programmers;

import java.util.ArrayList;

public class Solution_소수찾기 {

    static ArrayList<Integer> num;
    static boolean[] check;
    static int answer;
    static String numberss;

    public static int solution(String numbers) {
        answer = 0;
        numberss = numbers;

        num = new ArrayList<>();

        check = new boolean[numbers.length()];

        // 만들 수 있는 모든 값 만들기
        perm(0, numbers.length());

        System.out.println(answer);
        return answer;
    }

    public static void perm(int cnt, int n) {

        if (num.contains(cnt)) {
            return;
        }

        num.add(cnt);
        if (possible(cnt)) {
            answer++;
        }

        for (int i = 0; i < n; i++) {

            if (check[i] == true)
                continue;

            check[i] = true;
            int current = Integer.parseInt(String.valueOf(cnt) + numberss.charAt(i));
            perm(current, n);
            check[i] = false;
        }
    }

    // 소수 판별
    public static boolean possible(int num) {

        if (num < 2)
            return false;

        // 2,3,5,7
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        solution("17");
    }

}
