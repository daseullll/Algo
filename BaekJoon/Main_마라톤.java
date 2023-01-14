import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_마라톤 {

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Node> cp = new ArrayList<>();
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            cp.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        // --input end--
        int[] dist = new int[N - 1];
        int sum = 0;
        for (int i = 0; i < N - 1; i++) {
            dist[i] = man(cp.get(i).x, cp.get(i + 1).x, cp.get(i).y, cp.get(i + 1).y);
            sum += dist[i];
        }

        int result = 0;
        for (int i = 0; i < N - 2; i++) {
            int skip = man(cp.get(i).x, cp.get(i + 2).x, cp.get(i).y, cp.get(i + 2).y);
            result = Math.max(result, dist[i] + dist[i + 1] - skip);
        }

        System.out.println(sum - result);

    }

    public static int man(int x, int x2, int y, int y2) {
        return Math.abs(x - x2) + Math.abs(y - y2);
    }
}
