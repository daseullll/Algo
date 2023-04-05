import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_이차원배열과연산 {

    static int r, c, k;
    static int[][] arr;

    static class Node implements Comparable<Node> {
        int num, sum;

        public Node(int num, int sum) {
            this.num = num;
            this.sum = sum;
        }

        @Override
        public int compareTo(Node o) {

            return this.sum - o.sum == 0 ? this.num - o.num : this.sum - o.sum;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;
        k = Integer.parseInt(st.nextToken());
        arr = new int[3][3];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // --input end--
        int cnt = 0;
        int result = 0;
        while (true) {
            if (cnt > 100) {
                result = -1;
                break;
            }

            if (r < arr.length && c < arr[0].length) {
                if (arr[r][c] == k) {
                    break;
                }
            }

            if (arr.length >= arr[0].length) {
                goR();
            } else {
                goC();
            }

            result++;
            cnt++;

        }

        System.out.println(result);

    }

    public static void goR() {

        int[][] arr2 = new int[101][101];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int[] count = new int[101];
            ArrayList<Node> temp = new ArrayList<>();
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] != 0) {
                    count[arr[i][j]]++;
                }
            }

            for (int p = 1; p < 101; p++) {
                if (count[p] != 0) {
                    temp.add(new Node(p, count[p]));
                }
            }

            // 정렬하기
            Collections.sort(temp);

            // 다시 배열에 넣기
            int z = 0;
            for (int p = 0; p < temp.size(); p++) {
                arr2[i][z] = temp.get(p).num;
                arr2[i][z + 1] = temp.get(p).sum;
                z += 2;
                max = Math.max(max, z);
            }

        }

        // 행의 크기가 100을 넘어가는 경우
        if (max > 100) {
            max = 100;
        }

        arr = new int[arr.length][max];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = arr2[i][j];
            }
        }
    }

    public static void goC() {

        int[][] arr2 = new int[101][101];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr[0].length; i++) {
            int[] count = new int[101];
            ArrayList<Node> temp = new ArrayList<>();
            for (int j = 0; j < arr.length; j++) {
                if (arr[j][i] != 0) {
                    count[arr[j][i]]++;
                }
            }

            for (int p = 1; p < 101; p++) {
                if (count[p] != 0) {
                    temp.add(new Node(p, count[p]));
                }
            }

            // 정렬하기
            Collections.sort(temp);

            // 다시 배열에 넣기
            int z = 0;
            for (int p = 0; p < temp.size(); p++) {
                arr2[z][i] = temp.get(p).num;
                arr2[z + 1][i] = temp.get(p).sum;
                z += 2;
                max = Math.max(max, z);
            }

        }

        // 열의 크기가 100을 넘어가는 경우
        if (max > 100) {
            max = 100;
        }

        arr = new int[max][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = arr2[i][j];
            }
        }
    }

}
