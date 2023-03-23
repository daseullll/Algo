import java.util.ArrayList;
import java.util.Collections;

public class Solution_K번째수 {

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        int cnt = 0;
        for (int i = 0; i < commands.length; i++) {
            int start = commands[i][0] - 1;
            int end = commands[i][1];

            ArrayList<Integer> arr = new ArrayList<>();
            for (int j = start; j < end; j++) {
                arr.add(array[j]);
            }
            Collections.sort(arr);

            answer[cnt] = arr.get(commands[i][2] - 1);
            System.out.println(answer[cnt]);
            cnt++;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] array = { 1, 5, 2, 6, 3, 7, 4 };
        int[][] commands = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };

        System.out.println(solution(array, commands));
    }

}
