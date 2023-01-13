import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_촌수계산 {
    static int first, second, N, result;
    static ArrayList<Integer>[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        first = Integer.parseInt(st.nextToken());
        second = Integer.parseInt(st.nextToken());
        result = -1;

        arr = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }

        // --input end--
        dfs(first, 0);
        System.out.println(result);

    }

    public static void dfs(int current, int cnt) {

        if (current == second) {
            result = cnt;
            return;
        }

        visited[current] = true;
        for (int i = 0; i < arr[current].size(); i++) {
            int next = arr[current].get(i);
            if (!visited[next])
                dfs(next, cnt + 1);
        }
    }
}
