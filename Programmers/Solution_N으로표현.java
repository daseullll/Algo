import java.util.ArrayList;
import java.util.HashSet;

public class Solution_N으로표현 {

    public static int solution(int N, int number) {
        int answer = -1;

        ArrayList<HashSet<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            HashSet<Integer> temp = new HashSet<>();
            arr.add(temp);
        }

        arr.get(1).add(N);

        for (int i = 2; i <= 8; i++) {
            HashSet<Integer> temp = arr.get(i);

            for (int j = 1; j <= i; j++) {
                HashSet<Integer> pre = arr.get(j);
                HashSet<Integer> post = arr.get(i - j);

                for (int a : pre) {
                    for (int b : post) {
                        temp.add(a + b);
                        temp.add(a - b);
                        temp.add(a * b);
                        if (a != 0 && b != 0)
                            temp.add(a / b);
                    }
                }
            }

            temp.add(Integer.parseInt(String.valueOf(N).repeat(i)));

        }

        for (HashSet<Integer> h : arr) {
            if (h.contains(number)) {
                answer = arr.indexOf(h);
                break;
            }
        }

        return answer;
    }

}
