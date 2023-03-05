import java.util.Scanner;

public class Main_홀수홀릭호석 {

    static int min, max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] c = sc.nextLine().toCharArray();
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        go(c, 0);

        System.out.println(min + " " + max);
    }

    public static void go(char[] num, int sum) {

        for (int cnt = 0; cnt < num.length; cnt++) {
            if (num[cnt] % 2 != 0)
                sum++;
        }

        // 한자리 수
        if (num.length == 1) {
            min = Math.min(min, sum);
            max = Math.max(max, sum);
            return;
        }

        // 두자리 수
        else if (num.length == 2) {
            int n = (Integer.parseInt(num[0] + "") + Integer.parseInt(num[1] + ""));
            String ss = Integer.toString(n);
            char[] temp = ss.toCharArray();

            go(temp, sum);
        }

        // 세자리 이상 수
        // 임의의 위치에서 끊어서 3개의 수로 분할하기
        // --> 2번 자르기
        else {

            // 첫번째 가위는 숫자 끝 두개는 무조건 남겨야 됨
            // a = 0 ~ n.length-2

            // 두번째 가위는 숫자 끝 한개는 무조건 남겨야 됨
            // b = i+1 ~ n.length-1
            StringBuilder sb1 = new StringBuilder();

            for (int a = 0; a < num.length - 2; a++) {
                sb1.append(num[a]);
                StringBuilder sb2 = new StringBuilder();
                for (int b = a + 1; b < num.length - 1; b++) {
                    sb2.append(num[b]);
                    StringBuilder sb3 = new StringBuilder();
                    for (int c = b + 1; c < num.length; c++) {
                        sb3.append(num[c]);
                    }
                    String one = sb1.toString();
                    String two = sb2.toString();
                    String three = sb3.toString();

                    int current = Integer.parseInt(one) + Integer.parseInt(two)
                            + Integer.parseInt(three);
                    char[] next = Integer.toString(current).toCharArray();

                    go(next, sum);
                }
            }

        }

    }
}
