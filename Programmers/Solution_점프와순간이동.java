public class Solution_점프와순간이동 {

    public static int solution(int n) {

        int ans = 0;

        while (n != 0) {
            if (n % 2 == 0) {
                n /= 2;
            }

            else {
                n--;
                ans++;
            }
        }

        System.out.println(ans);
        return ans;
    }

    public static void main(String[] args) {
        solution(5000);
    }
}
