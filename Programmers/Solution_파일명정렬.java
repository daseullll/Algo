
import java.util.Arrays;

public class Solution_파일명정렬 {

    static class Node implements Comparable<Node> {
        String head;
        int num;
        int index;

        public Node(String head, int num, int index) {
            this.head = head;
            this.num = num;
            this.index = index;
        }

        @Override
        public int compareTo(Node o) {

            if (head.compareToIgnoreCase(o.head) > 0) {
                return 1;
            }

            else if (head.compareToIgnoreCase(o.head) < 0) {
                return -1;
            }

            else {
                if (num > o.num) {
                    return 1;
                } else if (num < o.num) {
                    return -1;
                }

                else {
                    if (index > o.index) {
                        return 1;
                    } else if (index < o.index) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            }
        }

    }

    public static String[] solution(String[] files) {
        String[] answer = new String[files.length];

        Node[] file = new Node[files.length];
        for (int i = 0; i < files.length; i++) {
            file[i] = change(files[i], i);
        }

        Arrays.sort(file);
        for (int i = 0; i < files.length; i++) {
            int n = file[i].index;
            answer[i] = files[n];
            System.out.println(answer[i]);
        }
        return answer;
    }

    // 문자열을 head, num로 바꿔줌
    public static Node change(String s, int a) {

        String head = null;
        int num = 0;

        int index = 0;
        for (int i = 1; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                index = i;
                head = s.substring(0, index).toLowerCase();
                System.out.println("head: " + head);
                break;
            }
        }

        for (int i = index; i < s.length(); i++) {

            if (i == s.length() - 1) {
                num = Integer.parseInt(s.substring(index, i + 1));
                break;
            }
            if (i - index == 5 || !Character.isDigit(s.charAt(i))) {
                num = Integer.parseInt(s.substring(index, i));
                break;
            }
        }

        Node current = new Node(head, num, a);
        return current;
    }

    public static void main(String[] args) {
        String[] s = { "O010", "O49qcGPHuRLR5FEfoO00321" };

        solution(s);
    }
}
