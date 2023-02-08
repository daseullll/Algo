package Programmers;

public class Solution_최소직사각형 {

    static boolean[] check;
    static int answer;

    public static int solution(int[][] sizes) {

        answer = Integer.MAX_VALUE;

        check = new boolean[sizes.length];
        turn(0, sizes.length, sizes);

        System.out.println(answer);

        return answer;
    }

    public static void turn(int cnt, int N, int[][] sizes) {

        if (cnt == (N - 1)) {
            int[][] arr = new int[sizes.length][sizes[0].length];
            for (int i = 0; i < sizes.length; i++) {
                for (int j = 0; j < sizes[0].length; j++) {
                    arr[i][j] = sizes[i][j];
                }
            }

            // int[][] arr = sizes;
            for (int i = 0; i < check.length; i++) {
                if (check[i]) { // 뒤집기
                    int temp = arr[i][0];
                    arr[i][0] = arr[i][1];
                    arr[i][1] = temp;
                }
            }

            for (int i = 0; i < sizes.length; i++) {
                for (int j = 0; j < sizes[0].length; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }

            System.out.println("---");

            go(arr);
            return;
        }

        check[cnt] = true;
        turn(cnt + 1, N, sizes);
        check[cnt] = false;
        turn(cnt + 1, N, sizes);
    }

    public static void go(int[][] arr) {

        int a = 0;
        int b = 0;
        for (int i = 0; i < arr.length; i++) {
            a = Math.max(a, arr[i][0]);
            b = Math.max(b, arr[i][1]);
        }
        System.out.println("a:" + a + "b:" + b);
        answer = Math.min(answer, a * b);

    }

    public static void main(String[] args) {
        int[][] sizes = { { 60, 50 }, { 30, 70 }, { 60, 30 }, { 80, 40 } };
        solution(sizes);
    }

}
