
import java.util.ArrayList;

public class Solution_모의고사 {

    public static ArrayList<Integer> solution(int[] answers) {

        ArrayList<Integer> answer = new ArrayList<>();

        int[] one = { 1, 2, 3, 4, 5 };
        int[] two = { 2, 1, 2, 3, 2, 4, 2, 5 };
        int[] three = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

        int oCnt = 0;
        int tCnt = 0;
        int thCnt = 0;

        for (int i = 0; i < answers.length; i++) {
            if (one[i % 5] == answers[i])
                oCnt++;

            if (two[i % 8] == answers[i])
                tCnt++;

            if (three[i % 10] == answers[i])
                thCnt++;
        }

        int max = Math.max(oCnt, tCnt);
        max = Math.max(max, thCnt);

        if (max == oCnt)
            answer.add(1);
        if (max == tCnt)
            answer.add(2);
        if (max == thCnt)
            answer.add(3);

        System.out.println(answer.size());
        return answer;
    }

    public static void main(String[] args) {
        int[] answers = { 1, 3, 2, 4, 2 };

        solution(answers);

    }

}
