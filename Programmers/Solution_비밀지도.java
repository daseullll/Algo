
import java.util.Stack;

public class Solution_비밀지도 {
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            Stack<Integer> stack = new Stack<>();
            Stack<Integer> stack2 = new Stack<>();

            int current = arr1[i];
            int current2 = arr2[i];

            int temp = 0;
            while (temp != n) {

                System.out.println(current2 + " " + current2 % 2);

                stack.push(current % 2);
                stack2.push(current2 % 2);

                current /= 2;

                current2 /= 2;

                temp++;
            }

            StringBuilder sb = new StringBuilder();
            while (!stack.empty()) {
                int a = stack.pop();
                int b = stack2.pop();
                if (a == 1 || b == 1)
                    sb.append("#");
                else
                    sb.append(" ");
            }

            answer[i] = sb.toString();

            System.out.println(answer[i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] arr1 = { 9, 20, 28, 18, 11 };
        int[] arr2 = { 30, 1, 21, 17, 28 };
        solution(5, arr1, arr2);
    }
}
