package Softeer;

import java.util.*;
import java.io.*;

public class Main_8단변속기 {
    static int[] asc = { 1, 2, 3, 4, 5, 6, 7, 8 };
    static int[] des = { 8, 7, 6, 5, 4, 3, 2, 1 };

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[8];

        for (int i = 0; i < 8; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // --input end--

        if (arr[0] < arr[7]) {
            if (compare(asc, arr))
                System.out.println("ascending");
            else
                System.out.println("mixed");
        }
        if (arr[0] >= arr[7]) {
            if (compare(des, arr))
                System.out.println("descending");
            else
                System.out.println("mixed");
        }

    }

    public static boolean compare(int[] arr, int[] temp) {
        for (int i = 0; i < 8; i++) {
            if (arr[i] != temp[i]) {
                return false;
            }
        }
        return true;
    }
}
