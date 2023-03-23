
public class Solution_최소직사각형2 {

    public static int solution(int[][] sizes) {

        int answer = 0;

        int maxh = 0;
        int minm = 0;
        for (int i = 0; i < sizes.length; i++) {
            int h = Math.max(sizes[i][0], sizes[i][1]);
            int m = Math.min(sizes[i][0], sizes[i][1]);

            maxh = Math.max(maxh, h);
            minm = Math.max(minm, m);
        }

        return answer = maxh * minm;
    }

    public static void main(String[] args) {
        int[][] sizes = { { 60, 50 }, { 30, 70 }, { 60, 30 }, { 80, 40 } };
        solution(sizes);
    }

}
