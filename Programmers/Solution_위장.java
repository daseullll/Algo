
import java.util.HashMap;
import java.util.Map.Entry;

public class Solution_위장 {

    public static int solution(String[][] clothes) {
        HashMap<String, Integer> wear = new HashMap<>();
        int answer = clothes.length;

        for (int i = 0; i < clothes.length; i++) {
            wear.put(clothes[i][1], wear.getOrDefault(clothes[i][1], 0) + 1);
        }

        int second = 1;
        if (wear.size() > 1) {
            for (Entry<String, Integer> e : wear.entrySet()) {
                second *= e.getValue() + 1;
            }
            answer = second - 1;
        }

        return answer;
    }

    public static void main(String[] args) {

        String[][] clothes = { { "yellow_hat", "face" }, { "blue_sunglasses", "ace" },
                { "green_turban", "face" } };
        solution(clothes);

    }

}
