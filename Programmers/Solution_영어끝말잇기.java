import java.util.HashSet;

public class Solution_영어끝말잇기 {

    public static int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        answer[0] = 0;
        answer[1] = 0;

        HashSet<String> word = new HashSet<>();
        char end = words[0].charAt(words[0].length() - 1);
        word.add(words[0]);

        for (int i = 1; i < words.length; i++) {

            System.out.println("end:" + end);
            if (words[i].charAt(0) != end) {
                answer[0] = (i % n) + 1;
                answer[1] = i / n + 1;
                break;
            }

            if (word.contains(words[i])) {
                answer[0] = (i % n) + 1;
                answer[1] = i / n + 1;
                break;
            }

            word.add(words[i]);
            end = words[i].charAt(words[i].length() - 1);

        }

        return answer;
    }

    public static void main(String[] args) {

        String[] words = { "tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank" };
        solution(3, words);
    }
}
