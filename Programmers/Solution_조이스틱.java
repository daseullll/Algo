package Programmers;

public class Solution_조이스틱 {

    public int solution(String name) {
        int answer = 0;
        int length = name.length();

        int index; // 다음 값들을 확인할때 사용
        int move = length - 1; // 오르쪽으로 쭉 간 횟수

        for (int i = 0; i < name.length(); i++) {
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            index = i + 1;
            // 연속되는 A 개수 확인
            while (index < length && name.charAt(index) == 'A') {
                index++;
            }

            // 순서대로 가는 것과 뒤로 돌아가는 것 중 이동수가 적은 것을 선택
            // 오른쪽으로 갔다가 다시 왼쪽으로 가는 경우
            move = Math.min(move, i * 2 + length - index);
            // 왼쪽으로 갔다가 다시 오른쪽으로 가는 경우
            move = Math.min(move, (length - index) * 2 + i);
        }

        return answer + move;
    }

    public static void main(String[] args) {

    }
}
