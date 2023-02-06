package Programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class Solution_베스트앨범 {

    public static ArrayList<Integer> solution(String[] genres, int[] plays) {

        /**
         * LinkedHashMap : ArrayList와 같이 순서를 보장한다.
         * 그냥 HashMap은 put을 통해 데이터나 객체를 넣으면 순서가 지켜지지 않는다.
         * key의 순서가 보장되어야 할 때 사용한다. -> 입력된 key의 순서가 보장된다.
         */

        LinkedHashMap<String, Integer> genre = new LinkedHashMap<>();
        HashMap<String, Integer> genreCnt = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            genre.put(genres[i], genre.getOrDefault(genres[i], 0) + plays[i]);
            genreCnt.put(genres[i], genre.getOrDefault(genres[i], 1) + 1);
        }

        ArrayList<Integer> answer = new ArrayList<>();

        int cnt = 0;
        while (genre.size() != 0) {
            String max = null;
            int maxNum = Integer.MIN_VALUE;
            for (Entry<String, Integer> e : genre.entrySet()) {
                System.out.println(e.getValue() + " " + e.getKey());
                if (maxNum < e.getValue()) {
                    max = e.getKey();
                    maxNum = e.getValue();
                }
            }

            int playMax = Integer.MIN_VALUE;
            int first = -1;
            for (int i = 0; i < genres.length; i++) {
                if (genres[i].equals(max)) {
                    if (playMax < plays[i]) {
                        playMax = plays[i];
                        first = i;
                    }
                }
            }

            int second = -1;
            if (genreCnt.get(max) > 1) {
                int playMax2 = Integer.MIN_VALUE;
                for (int i = 0; i < genres.length; i++) {
                    if (first == i)
                        continue;
                    if (genres[i].equals(max)) {
                        if (playMax2 < plays[i]) {
                            playMax2 = plays[i];
                            second = i;
                        }
                    }
                }
            }

            answer.add(first);
            if (second != -1) {
                answer.add(second);
            }

            genre.remove(max);

        }

        return answer;
    }

    public static void main(String[] args) {

        String[] genres = { "classic", "pop", "classic", "pop", "classic", "classic" };
        int[] plays = { 1950, 600, 500, 2500, 500, 150 };

        solution(genres, plays);

    }

}
