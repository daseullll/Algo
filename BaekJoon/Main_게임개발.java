import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_게임개발 {

    static int n;
    static int[] time;
    static int[] result;
    static ArrayList<Integer>[] next;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        time = new int[n + 1];
        next = new ArrayList[n + 1];
        result = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            next[i] = new ArrayList<>();
        }

        StringTokenizer st;
        int min = 1;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = 0;
            while (true) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp == -1)
                    break;

                if (cnt == 0) {
                    time[i] = temp;
                } else {
                    next[i].add(temp);
                }

                cnt++;
            }
        }

        // --input end--
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            dfs(i);
            sb.append(result[i] + "\n");
        }

        System.out.println(sb.toString());

    }

    public static int dfs(int num) {

        if (result[num] != 0)
            return result[num];

        result[num] += time[num];
        int max = 0;
        for (int c : next[num]) {
            max = Math.max(max, dfs(c));
        }

        result[num] += max;
        return result[num];

    }

}
