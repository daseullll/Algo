package Softeer;

import java.util.Scanner;

public class Main_지도자동구축 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        int start = 3;
        int sum = 1;
        for (int i = 2; i <= n; i++) {
            sum *= 2;
            start += sum;
        }

        System.out.println(start * start);

    }
}
