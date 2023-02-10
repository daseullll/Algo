import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_명령프롬프트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        if (N == 1) {
            System.out.println(br.readLine());
            return;
        }

        String one = br.readLine();

        char[] first = one.toCharArray();
        for (int i = 1; i < N; i++) {
            sb = new StringBuilder();
            String next = br.readLine();
            char[] second = next.toCharArray();
            for (int j = 0; j < second.length; j++) {
                if (first[j] != second[j]) {
                    sb.append("?");
                } else
                    sb.append(second[j]);

            }

            one = sb.toString();
            first = one.toCharArray();

        }

        System.out.println(sb.toString());

    }
}
