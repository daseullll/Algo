import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main_숫자고르기 {

    static ArrayList<Integer> list;
    static boolean[] check;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 순서대로 사이클이 발생하는 dfs로 확인
        list = new ArrayList<>();
        check = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            check[i] = true;
            dfs(i, i);
            check[i] = false;
        }

        Collections.sort(list);
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static void dfs(int start, int cur) {

        if (!check[arr[cur]]) {
            check[arr[cur]] = true;
            dfs(start, arr[cur]);
            check[arr[cur]] = false;
        }

        if (start == arr[cur]) {
            list.add(cur);
        }
    }

}
