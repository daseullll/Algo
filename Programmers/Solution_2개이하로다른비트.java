import java.util.*;

class Solution_2개이하로다른비트 {

    public ArrayList<Long> solution(long[] numbers) {
        ArrayList<Long> answer = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {

            if (numbers[i] % 2 == 0) { // 짝수일 경우 바로 다음 수가 무조건 답
                answer.add(numbers[i] + 1);
                continue;
            }

            // 홀수일 경우
            // 모두 1일 경우
            String cur = Long.toString(numbers[i], 2);
            String temp = Long.toString(numbers[i], 2);
            int zero = cur.lastIndexOf("0");
            if (zero == -1) {
                cur = "10" + cur.substring(1, cur.length());
            } else {

                cur = cur.substring(0, zero) + "10" + cur.substring(zero + 2, cur.length());

            }

            answer.add(Long.parseLong(cur, 2));
        }

        return answer;
    }
    // public ArrayList<Long> solution(long[] numbers) {
    // ArrayList<Long> answer = new ArrayList<>();

    // for (int i = 0; i < numbers.length; i++) {

    // long cur = numbers[i];
    // long next = cur + 1;
    // while (true) {
    // long result = cur ^ next;
    // // String two = Long.toString(result, 2);
    // // int size = two.length()-two.replaceAll("1","").length();

    // int size = Long.bitCount(result);
    // String s;

    // if (size <= 2)
    // break;

    // next++;

    // }

    // answer.add(next);
    // }

    // return answer;
    // }

}