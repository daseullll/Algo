import java.util.Scanner;

public class Main_ZOAC {

    static String word;
    static boolean[] check;
    static StringBuilder sb;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        word = sc.nextLine();
        check = new boolean[word.length()];
        sb = new StringBuilder();

        dfs(0, word.length() - 1);

        System.out.print(sb.toString());

    }

    public static void dfs(int start, int end) {

        if (start > end)
            return;

        int idx = start;
        // 현재 위치에서 사전순으로 가장 작은 값 찾기
        for (int i = start; i <= end; i++) {
            if (word.charAt(idx) > word.charAt(i)) {
                idx = i;
            }
        }

        check[idx] = true;

        for (int i = 0; i < word.length(); i++) {
            if (check[i]) {
                sb.append(word.charAt(i));
            }
        }
        sb.append("\n");

        /**
         * 방금 넣은 값을 기준으로 오른쪽과 왼쪽을 다시 한번 탐색한다.
         * 오른쪽 먼저인 이유 : 남아있는 알파벳 중 사전순으로 문자열을 만드려면 오른쪽으로 붙는게 더 사전순으론 낮다.
         */
        dfs(idx + 1, end);
        dfs(start, idx - 1);

    }

}
