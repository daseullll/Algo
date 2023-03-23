
public class Solution_피로도 {

    static boolean[] check;
    static int[][] dg, num;
    static int limit, result;

    public static int solution(int k, int[][] dungeons) {

        dg = dungeons;
        num = new int[dg.length][2];
        check = new boolean[dg.length];
        limit = k;
        result = 0;

        perm(0);
        System.out.println(result);

        return result;
    }

    public static void perm(int cnt) {

        if (cnt == dg.length) {
            result = Math.max(go(num, limit), result);
            return;
        }

        for (int i = 0; i < dg.length; i++) {
            if (check[i])
                continue;

            num[cnt][0] = dg[i][0];
            num[cnt][1] = dg[i][1];
            check[i] = true;
            perm(cnt + 1);
            check[i] = false;
        }
    }

    public static int go(int[][] arr, int me) {

        int count = 0;
        for (int i = 0; i < arr.length; i++) {

            if (arr[i][0] > me)
                break;

            count++;
            me = me - arr[i][1];
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] dungeons = { { 40, 20 }, { 10, 10 }, { 10, 10 }, { 10, 10 }, { 10, 10 } };
        solution(40, dungeons);
    }

}
