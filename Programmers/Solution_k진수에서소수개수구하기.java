import java.util.ArrayList;
import java.util.*;

class Solution_k진수에서소수개수구하기 {

    static public int solution(int n, int k) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();
        int nr = n;
        while (nr != 0) {
            list.add(nr % k);
            nr /= k;
        }

        Collections.reverse(list);

        StringBuilder sb = new StringBuilder();
        Loop: for (int aa = 0; aa < list.size(); aa++) {
            int current = list.get(aa);

            if (current == 0) {
                // 소수 구하기
                if (sb.toString().isEmpty())
                    continue Loop;
                // long num = Integer.parseInt(sb.toString());
                long num = Long.parseLong(sb.toString());
                System.out.println(num);

                if (num == 1) {
                    sb = new StringBuilder();
                    continue Loop;
                }
                for (long i = 2; i <= Math.sqrt(num); i++) {
                    // 소수가 아니라면 break
                    if (num % i == 0)
                        continue Loop;
                }
                // 소수라면
                answer++;
                // 초기화
                sb = new StringBuilder();
            } else
                sb.append(current);
        }

        boolean check = false;

        if (sb.length() != 0) {
            long num2 = Long.parseLong(sb.toString());
            long k2 = 2;
            if (num2 >= 2) {
                for (k2 = 2; k2 <= Math.sqrt(num2); k2++) {
                    // 소수가 아니라면 break
                    if (num2 % k2 == 0) {
                        check = true;
                        break;
                    }
                }
                if (check == false)
                    answer++;
            }
        }
        System.out.println("answer:" + answer);
        return answer;
    }

    public static void main(String[] args) {
        solution(437674, 3);
    }
}
