import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.*;

public class Main_단어뒤집기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Character> st = new Stack<>();
        Queue<Character> q = new LinkedList<>();
        char[] word = br.readLine().toCharArray();
        boolean check = false;

        for (int i = 0; i < word.length; i++) {

            if (word[i] == '<') {
                check = true;
                while (!st.isEmpty()) {
                    sb.append(st.pop());
                }
                sb.append("<");
                continue;
            } else if (word[i] == '>') {
                check = false;
                while (!q.isEmpty()) {
                    sb.append(q.poll());
                }
                sb.append(">");
                continue;
            }

            if (word[i] == ' ' && !check) {
                while (!st.isEmpty()) {
                    sb.append(st.pop());
                }
                sb.append(" ");
                continue;
            } else if (check) {
                q.add(word[i]);
                continue;
            } else if (!check) {
                st.add(word[i]);
                continue;
            }

        }

        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        System.out.println(sb.toString());

    }
}
