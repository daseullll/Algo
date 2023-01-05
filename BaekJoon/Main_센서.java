import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_센서 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 센서의 개수
        int k = Integer.parseInt(br.readLine()); // 집중국의 개수
        int result = 0;
        if (n <= k) {
            System.out.println(result);
            return;
        }

        int arr[] = new int[n];
        Integer diff[] = new Integer[n - 1]; // 센서의 차이를 저장하기 위한 배열, 내림차순을 사용하기 위해 Integer로 정의한다.
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // --input end--

        Arrays.sort(arr); // 오름차순 정렬
        for (int i = 1; i < n; i++) {
            diff[i - 1] = arr[i] - arr[i - 1];
        }

        Arrays.sort(diff, Collections.reverseOrder());

        for (int i = 0; i < diff.length; i++) {
            if (i < k - 1)
                continue;
            // System.out.println(diff[i]);
            result += diff[i];
        }

        System.out.println(result);

    }
}
