package Programmers;

import java.util.*;

public class Solution_신고결과받기 {

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, Integer> cnt = new HashMap<>(); // 신고 당한 횟수
        HashMap<String, HashSet<String>> who = new HashMap<>(); // 신고한 사람
        StringTokenizer st;

        System.out.println(id_list.length);

        for (int i = 0; i < id_list.length; i++) {
            cnt.put(id_list[i], 0);
            who.put(id_list[i], new HashSet<>());
        }

        for (int i = 0; i < report.length; i++) {
            st = new StringTokenizer(report[i]);
            String first = st.nextToken();
            HashSet<String> temp = new HashSet<String>();
            temp = who.get(first);
            String second = st.nextToken();
            temp.add(second);
            who.put(first, temp);
        }

        for (int i = 0; i < who.size(); i++) {
            // cnt.put(id_list[i], who.get(id_list[i]).size());
            HashSet<String> temp = new HashSet<String>();
            temp = who.get(id_list[i]);
            System.out.println(temp + " " + id_list[i]);

            Iterator iter = temp.iterator();
            while (iter.hasNext()) {
                String s = iter.next().toString();
                cnt.put(s, cnt.get(s) + 1);
            }
        }

        System.out.println(cnt);

        for (int i = 0; i < cnt.size(); i++) {
            if (cnt.get(id_list[i]) >= k) {
                for (int j = 0; j < who.size(); j++) {
                    HashSet<String> temp = new HashSet<>();
                    temp = who.get(id_list[j]);
                    if (temp.contains(id_list[i]))
                        answer[j]++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        String[] a = { "muzi", "frodo", "apeach", "neo" };
        String[] b = { "muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach", "muzi" };
        solution(a, b, 2);
    }

}