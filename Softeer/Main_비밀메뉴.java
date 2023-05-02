package Softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_비밀메뉴 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if (m > n) {
            System.out.println("normal");
            return;
        }

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            sb.append(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb2.append(Integer.parseInt(st.nextToken()));
        }

        // --input end--

        if (sb2.toString().contains(sb))
            System.out.println("secret");
        else
            System.out.println("normal");

    }
}
