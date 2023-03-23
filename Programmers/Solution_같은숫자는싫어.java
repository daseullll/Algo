
import java.util.ArrayList;
import java.util.List;

public class Solution_같은숫자는싫어 {
    public static int[] solution(int[] arr) {
        int[] answer = {};
        List<Integer> li = new ArrayList<>();

        li.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] == arr[i]) {
                continue;
            }
            li.add(arr[i]);
        }

        answer = new int[li.size()];
        for (int i = 0; i < li.size(); i++) {
            answer[i] = li.get(i);
        }

        for (int i : answer) {
            System.out.println(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 4, 4, 3, 3 };
        solution(arr);

    }
}