import java.util.LinkedList;
import java.util.Scanner;
import java.util.*;

public class Main_숨바꼭질3 {

    static int k, n, result;
    static Queue<int[]> loc;
    static boolean[] check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        result = Integer.MAX_VALUE;
        loc = new LinkedList<>();
        check = new boolean[100001];

        int[] a = new int[2];
        a[0] = n;
        a[1] = 0;
        loc.add(a);

        while (!loc.isEmpty()) {
            go();
        }

        System.out.println(result);
    }

    public static void go() {

        int[] temp = loc.poll();
        int current = temp[0];
        int sum = temp[1];
        check[current] = true;

        if (current == k) {
            result = Math.min(result, sum);
            return;
        }

        if (current - 1 >= 0 && !check[current - 1]) {
            int[] next = new int[2];
            next[1] = sum + 1;
            next[0] = current - 1;
            loc.add(next);
        }

        if (current + 1 <= 100000 && !check[current + 1]) {
            int[] next = new int[2];
            next[1] = sum + 1;
            next[0] = current + 1;
            loc.add(next);
        }

        if (current * 2 <= 100000 && !check[current * 2]) {
            int[] next = new int[2];
            next[1] = sum;
            next[0] = current * 2;
            loc.add(next);
        }

    }

}
