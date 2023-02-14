import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_빗물 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[] arr = new int[w];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        for (int i = 1; i < w - 1; i++) {
            int start = 0;
            int end = 0;
            for (int j = 0; j < i; j++) {
                start = Math.max(start, arr[j]);
            }

            for (int j = i + 1; j < w; j++) {
                end = Math.max(arr[j], end);
            }

            if (arr[i] < start && arr[i] < end)
                result += (Math.min(start, end) - arr[i]);

        }

        System.out.println(result);

    }

}
