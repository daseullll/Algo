
public class Solution_방문길이 {

    public static int solution(String dirs) {
        int answer = 0;

        int[][] arr = new int[11][11];
        boolean[][][] visited = new boolean[11][11][5];

        char[] dir = dirs.toCharArray();

        int curX = 5;
        int curY = 5;
        for (int i = 0; i < dir.length; i++) {

            char curDir = dir[i];
            int nx = 0;
            int ny = 0;
            int num = 0;
            if (curDir == 'U') { // 위
                nx = curX;
                ny = curY + 1;
                num = 1;
            } else if (curDir == 'D') { // 아래
                nx = curX;
                ny = curY - 1;
                num = 2;
            } else if (curDir == 'R') { // 오른쪽
                nx = curX + 1;
                ny = curY;
                num = 3;
            } else if (curDir == 'L') { // 왼쪽
                nx = curX - 1;
                ny = curY;
                num = 4;
            }

            if (nx < 0 || nx >= 11 || ny < 0 || ny >= 11)
                continue;

            if (!visited[nx][ny][num]) {
                visited[nx][ny][num] = true;
                if (num == 1 || num == 3) {
                    visited[curX][curY][num + 1] = true;
                } else if (num == 2 || num == 4) {
                    visited[curX][curY][num - 1] = true;
                }
                answer++;
            }

            curX = nx;
            curY = ny;
            System.out.println("nx:" + nx + " ny:" + ny + " answer:" + answer);
        }

        return answer;
    }

    public static void main(String[] args) {
        String dirs = "UDU";
        System.out.println(solution(dirs));
    }

}
