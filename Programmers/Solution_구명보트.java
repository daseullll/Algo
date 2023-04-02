import java.util.Arrays;

public class Solution_구명보트 {

    public static int solution(int[] people, int limit) {
        int answer = 0;

        /**
         * 1. people을 정렬한다.
         * 2. 제일 작은 값(left)와 제일 큰 값(right)를 비교한다.
         * 3. 만약 right+left 값이 limit을 넘게 된다면 right 값은 더이상 누구랑 타고 갈 수 없다.
         * 4. right 값을 -1 해주고 구명보트는 +1 한다.
         * 5. 만약 right+left 값이 limit을 넘지 않는다면 둘을 태우고 간다.
         * 6. right 값을 -1 해주고 left 값은 +1 해준 뒤 구명보트는 +1 한다.
         * 7. left>right가 된다면 끝.
         * 8. left=right가 된다면 +1 해주고 끝.
         */

        // 50 50 70 80
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        while (left <= right) {

            if (people[left] + people[right] <= limit) {
                left += 1;
            }
            right -= 1;
            answer++;
        }

        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        int[] people = { 70, 80, 50 };
        solution(people, 100);
    }
}
