public class Solution_n2배열자르기 {

    public static int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];

        for (int i = 0; i < answer.length; i++) {
            int c = (int) (left % n);
            int r = (int) (left / n);
            left++;
            answer[i] = Math.max(r, c) + 1;
        }
        return answer;
    }

    public static void main(String[] args) {
        solution(3, 2, 5);
    }
}
