package Softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_금고털이 {

    static class Node implements Comparable<Node> {
        int m, p;

        public Node(int m, int p) {
            this.m = m;
            this.p = p;
        }

        public int compareTo(Node node) {
            return this.p < node.p ? 1 : -1;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> arr = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr.offer(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        // --input end--
        int result = 0;

        while (!arr.isEmpty()) {
            Node node = arr.poll();
            if (W < node.m) {
                result = result + W * node.p;
                break;
            } else {
                result = result + node.m * node.p;
                W = W - node.m;
            }

        }

        System.out.println(result);

    }

}
