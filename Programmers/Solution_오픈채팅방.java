package Programmers;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution_오픈채팅방 {

    public static ArrayList<String> solution(String[] record) {

        ArrayList<String> answer = new ArrayList<>();

        HashMap<String, String> uid = new HashMap<>();

        for (int i = 0; i < record.length; i++) {
            String current = record[i].split(" ")[0];
            String user = record[i].split(" ")[1];

            if (current.equals("Leave"))
                continue;

            String name = record[i].split(" ")[2];
            uid.put(user, name);

        }

        for (int i = 0; i < record.length; i++) {
            String current = record[i].split(" ")[0];
            String user = record[i].split(" ")[1];

            if (current.equals("Enter")) {
                answer.add(uid.get(user) + "님이 들어왔습니다.");
            } else if (current.equals("Leave")) {
                answer.add(uid.get(user) + "님이 나갔습니다.");
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        String[] record = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
                "Change uid4567 Ryan" };

        solution(record);
    }

}
