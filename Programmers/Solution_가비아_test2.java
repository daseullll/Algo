package Programmers;

import java.util.Arrays;

public class Solution_가비아_test2 {

    public static int solution(int[] dots, int[] lines) {
        int answer = 0;
        Arrays.sort(dots);
        int idx = 0;
        while (idx < dots.length) {
            int maxLen = 0;
            for (int i = idx; i < dots.length - 1; i++) {
                int len = dots[i + 1] - dots[i];
                if (len > maxLen) {
                    maxLen = len;
                }
            }
            int len = lines[0];
            for (int i = 1; i < lines.length; i++) {
                if (lines[i] > maxLen) {
                    break;
                }
                len = lines[i];
            }
            int i = idx;
            boolean found = false;
            while (i < dots.length - 1 && dots[i + 1] - dots[idx] <= len) {
                i++;
                found = true;
            }
            if (!found) {
                return answer;
            }
            idx = i;
            answer++;
        }

        return answer;

    }

    public static void main(String[] args) {
        int[] dots = { 1, 5, 8 };
        int[] lines = { 1, 3, 4, 6 };

        solution(dots, lines);
    }
}
