import java.util.*;

class Solution_압축 {

    public static ArrayList<Integer> solution(String msg) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> word = new HashMap<>();

        int end = 1; // 사전의 마지막 번호
        for (char temp = 'A'; temp <= 'Z'; temp++) {
            word.put(temp + "", end++);
        }

        int cnt = 0;
        String s = msg.charAt(cnt) + "";
        int temp = word.get(s);
        while (cnt < msg.length()) {
            if (cnt + 1 < msg.length()) {
                if (word.containsKey(s.concat(msg.charAt(cnt + 1) + ""))) {
                    s = s.concat(msg.charAt(cnt + 1) + "");
                    temp = word.get(s);
                    cnt++;
                } else {
                    answer.add(temp);
                    cnt++;
                    word.put(s.concat(msg.charAt(cnt) + ""), end++);
                    s = msg.charAt(cnt) + "";
                    temp = word.get(s);
                }
            } else {
                answer.add(word.get(s));
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        solution("ABABABABABABABAB");
    }
}