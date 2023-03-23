
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.*;

public class Solution_메뉴리뉴얼 {

    static HashMap<String, Integer> hs;

    public static ArrayList<String> solution(String[] orders, int[] course) {
        ArrayList<String> answer = new ArrayList<>();

        for (int i = 0; i < orders.length; i++) {
            // 각 문자열을 문자형 배열로 변환.
            char[] charArr = orders[i].toCharArray();
            // 해당 문자형 배열을 정렬.
            Arrays.sort(charArr);
            // 정렬된 문자형 배열을 문자열로 변환해 저장.
            orders[i] = String.valueOf(charArr);
        }

        for (int i = 0; i < course.length; i++) {
            hs = new HashMap<>();
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < orders.length; j++) {
                StringBuilder sb = new StringBuilder();
                if (course[i] <= orders[j].length())
                    comb(0, 0, course[i], orders[j], sb);
            }

            // hashMap 탐색하는 방법
            // entrySet() : 키 값 모아둔 것
            for (Entry<String, Integer> e : hs.entrySet()) {
                max = Math.max(max, e.getValue());
            }

            for (Entry<String, Integer> e : hs.entrySet()) {
                if (max >= 2 && e.getValue() == max) {
                    answer.add(e.getKey());
                }
            }

        }

        Collections.sort(answer);

        return answer;
    }

    // hashMap의 get or default => 지정된 키로 매핑된 값이 없는 경우 반환되어야 하는 기본값
    // 기존 key 값의 value를 계속 사용하고 싶을 경우 getOrDefault 메서드를 사용한다.
    public static void comb(int cnt, int start, int finish, String str, StringBuilder sb) {

        if (cnt == finish) {
            hs.put(sb.toString(), hs.getOrDefault(sb.toString(), 0) + 1);
            return;
        }

        for (int i = start; i < str.length(); i++) {
            sb.append(str.charAt(i));
            comb(cnt + 1, i + 1, finish, str, sb);
            sb.delete(cnt, cnt + 1);
        }

    }

    public static void main(String[] args) {
        String[] orders = { "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH" };
        int[] course = { 2, 3, 4 };
        System.out.println(solution(orders, course));
    }
}
