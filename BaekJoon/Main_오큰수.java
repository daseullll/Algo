import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_오큰수 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        arr[0] = Integer.parseInt(st.nextToken());

        // --input end--

        Stack<Integer> temp = new Stack<>();

        for (int i = 1; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] > arr[i - 1]) {
                arr[i - 1] = arr[i];
                while (!temp.isEmpty() && arr[temp.peek()] < arr[i]) {
                    arr[temp.pop()] = arr[i];
                }
            } else {
                temp.push(i - 1);
            }
        }

        while (!temp.isEmpty()) {
            arr[temp.pop()] = -1;
        }

        arr[n - 1] = -1;
        for (int i = 0; i < n; i++) {
            sb.append(arr[i] + " ");
        }

        System.out.println(sb.toString());

    }
}
