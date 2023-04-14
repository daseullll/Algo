import java.util.*;

class Solution_스킬트리 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        // A:0, B:1 ...
        boolean[] check = new boolean[26];

        char[] temp = skill.toCharArray();
        ArrayList<Character> queue = new ArrayList<>();
        for (int i = 0; i < temp.length; i++) {
            check[(temp[i] - '0') - 17] = true;
            queue.add(temp[i]);
        }

        // --input end--

        Loop: for (int i = 0; i < skill_trees.length; i++) {
            char[] temp2 = skill_trees[i].toCharArray();
            int cnt = 0;
            for (int j = 0; j < temp2.length; j++) {
                // System.out.println((temp2[j]-'0')-17);
                if (check[(temp2[j] - '0') - 17]) {
                    if (temp2[j] != queue.get(cnt))
                        continue Loop;
                    else
                        cnt++;
                }

            }
            answer++;
        }

        return answer;
    }
}