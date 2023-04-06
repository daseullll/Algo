import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_시험감독 {

    static int n;
    static long b, c;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        System.out.println(noExist());

    }

    public static long noExist() {

        long cnt = 0;
        for (int i = 0; i < n; i++) {

            arr[i] = arr[i] - b;
            cnt++;
            if (arr[i] <= 0) {
                continue;
            } else {
                cnt += arr[i] / c;
                if (arr[i] % c != 0)
                    cnt++;
            }
        }

        return cnt;
    }
}
