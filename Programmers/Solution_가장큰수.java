package Programmers;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_가장큰수 {

    public static String solution(int[] numbers) {
        String answer = "";

        String[] num = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            num[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(num, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num.length; i++) {
            sb.append(num[i]);
        }

        String temp = sb.toString();
        if (num[0].equals("0"))
            temp = "0";

        return temp;
    }

    public static void main(String[] args) {

    }

}
