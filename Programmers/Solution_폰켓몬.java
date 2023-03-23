
import java.util.HashMap;
import java.util.HashSet;

public class Solution_폰켓몬 {

    public static int solution(int[] nums) {
        int answer = 0;

        int max = nums.length / 2;

        // 중복 제거
        HashSet<Integer> num = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            num.add(nums[i]);
        }

        if (num.size() >= max)
            return max;

        else
            return num.size();
    }

    public static void main(String[] args) {
        int[] nums = { 3, 3, 3, 2, 2, 2 };
        System.out.println(solution(nums));
    }
}
