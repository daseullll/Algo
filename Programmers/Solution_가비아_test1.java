package Programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;

public class Solution_가비아_test1 {

    static ArrayList<User> page;
    static int limit;
    static int result;

    static class User implements Comparable<User> {
        String name;
        int score;

        public User(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public int compareTo(User u) {
            return this.score - u.score;
        }

    }

    public static int solution(int K, String[] user_scores) {

        result = 0;

        limit = K;
        ArrayList<User> rank = new ArrayList<>();
        page = new ArrayList<>();

        for (int i = 0; i < user_scores.length; i++) {
            String name = user_scores[i].split(" ")[0];
            int score = Integer.parseInt(user_scores[i].split(" ")[1]);

            rank.add(new User(name, score));
            go(rank);

        }

        System.out.println(result);
        return result;
    }

    public static void go(ArrayList<User> temp) {

        if (temp.size() == 1) {
            result++;
            page.add(temp.get(0));
            return;
        }

        Collections.sort(temp, Comparator.reverseOrder());
        temp = IsSame(temp);
        boolean change = false;

        for (int i = 0; i < page.size(); i++) {

            if (i >= limit)
                break;
            if (!temp.get(i).name.equals(page.get(i).name)) {
                change = true;
            }
        }
        if (change || page.size() != temp.size())
            result++;
        page = temp;

    }

    public static ArrayList<User> IsSame(ArrayList<User> temp) {

        LinkedHashMap<String, Integer> check = new LinkedHashMap<>();

        for (int i = 0; i < temp.size(); i++) {
            if (check.containsKey(temp.get(i).name)) {
                if (temp.get(i).score < check.get(temp.get(i).name)) {
                    continue;
                }
            }

            check.put(temp.get(i).name, temp.get(i).score);
        }

        ArrayList<User> again = new ArrayList<>();
        int cnt = 0;
        for (String key : check.keySet()) {
            if (cnt == limit)
                break;
            again.add(new User(key, check.get(key)));
            cnt++;
        }

        return again;
    }

    public static void main(String[] args) {

        // "alex111 100", "cheries2 200", "coco 150", "luna 100", "alex111 120", "coco
        // 300","cheries2 110"

        // "alex111 100", "cheries2 200", "alex111 200", "cheries2 150", "coco 50","coco
        // 200"

        // "cheries 200", "alex111 100", "coco 150", "pyuo 120"
        String[] user_score = { "alex111 100", "cheries2 200", "coco 150", "luna 100", "alex111 120", "coco 300",
                "cheries2 110" };
        solution(3, user_score);
    }

}
