import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_도서관 {

    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> plus = new PriorityQueue<Integer>(Collections.reverseOrder());
        PriorityQueue<Integer> minus = new PriorityQueue<Integer>(Collections.reverseOrder());
        boolean check = true; // false이면 음수, true이면 양수 중에 절댓값이 가장 큰 것이 있다.
        int maxNum = Integer.MIN_VALUE;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if (temp > 0) {
                if (temp > maxNum) {
                    maxNum = temp;
                    check = true;
                }
                plus.offer(temp);
            } else {
                temp = temp * -1;
                if (temp > maxNum) {
                    maxNum = temp;
                    check = false;
                }
                minus.offer(temp);
            }
        }

        if (check) { // 양수 중 가장 큰 값이 있는 경우
            result += plus.poll();
            for (int i = 1; i < M; i++) {
                if (!plus.isEmpty())
                    plus.poll();
            }
        } else {
            result += minus.poll();
            for (int i = 1; i < M; i++) {
                if (!minus.isEmpty())
                    minus.poll();
            }
        }

        count(plus, M);
        count(minus, M);

        System.out.println(result);

    }

    public static void count(PriorityQueue<Integer> arr, int M) {

        int i = 0;
        while (!arr.isEmpty()) {
            if (i % M == 0)
                result += (arr.poll() * 2);
            else
                arr.poll();
            i++;
        }

    }

}
