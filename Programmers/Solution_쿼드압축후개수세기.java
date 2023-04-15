public class Solution_쿼드압축후개수세기 {

    static int[][] map;
    static int[] answer;

    public static int[] solution(int[][] arr) {
        answer = new int[2];
        map = arr;

        dfs(0, 0, arr.length);

        return answer;
    }

    public static boolean check(int x, int y, int size) {

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (map[x][y] != map[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void dfs(int x, int y, int size) {

        if (check(x, y, size)) { // 모두 같은 경우
            System.out.println(x + " " + y);
            answer[map[x][y]]++;
            return;
        }

        dfs(x, y, size / 2);
        dfs(x + size / 2, y, size / 2);
        dfs(x, y + size / 2, size / 2);
        dfs(x + size / 2, y + size / 2, size / 2);

    }

    public static void main(String[] args) {
        int[][] arr = { { 1, 1, 0, 0 }, { 1, 0, 0, 0 }, { 1, 0, 0, 1 }, { 1, 1, 1, 1 } };
        solution(arr);
    }
}
