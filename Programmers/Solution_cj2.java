import java.util.HashSet;

public class Solution_cj2 {

    static String[] inc;

    public static int solution(String[] kor, String[] usa, String[] incs) {
        int answer = 0;

        inc = incs;
        for (int i = 0; i < kor.length; i++) {
            for (int j = 0; j < usa.length; j++) {
                answer = Math.max(answer, go(kor[i], usa[j]));
            }
        }

        System.out.println(answer);

        return answer;
    }

    public static int go(String k, String u) {
        int cnt = 0;

        for (int i = 0; i < inc.length; i++) {
            HashSet<String> temp = new HashSet<>();
            String[] cur = inc[i].split(" ");
            for (int j = 0; j < cur.length; j++) {
                temp.add(cur[j]);
            }

            if (temp.contains(k) && temp.contains(u)) {
                cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {

        // String[] kor = { "AAA", "BCD", "AAAAA", "ZY" };
        // String[] usa = { "AB", "AA", "TTTT" };

        // String[] incs = { "AB BCD AA TTTT AAAAA", "BCD AAA", "AB AAA TTTT BCD", "AA
        // AAAAA AB", "AAA AB BCD" };

        String[] kor = { "CCC", "BCDF" };
        String[] usa = { "XXXX" };

        String[] incs = { "BCDF CCC", "XXXX" };

        solution(kor, usa, incs);

    }
}
