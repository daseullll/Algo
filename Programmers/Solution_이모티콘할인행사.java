package Programmers;

public class Solution_이모티콘할인행사 {
    static int[] sale = { 40, 30, 20, 10 };
    static int emotiNum = 0;
    static int[][] user;
    static int[] emoticon, answer;

    public static int[] solution(int[][] users, int[] emoticons) {
        answer = new int[2];
        emotiNum = emoticons.length;

        int[] arr = new int[emoticons.length];
        user = users;
        emoticon = emoticons;

        go(0, arr);

        System.out.println(answer[0]);
        System.out.println(answer[1]);

        return answer;
    }

    public static void go(int cnt, int[] arr) {

        if (cnt == emotiNum) {
            int[] temp = buy(arr);

            if (temp[0] > answer[0]) {
                answer[0] = temp[0];
                answer[1] = temp[1];
            } else if (temp[0] == answer[0]) {
                if (temp[1] > answer[1]) {
                    answer[1] = temp[1];
                }
            }

            return;
        }

        for (int i = 0; i < 4; i++) {
            arr[cnt] = sale[i];
            go(cnt + 1, arr);
        }
    }

    public static int[] buy(int[] arr) {

        int people = 0;
        int money = 0;

        int[] temp = new int[2];
        for (int i = 0; i < user.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (user[i][0] <= arr[j]) {
                    count += emoticon[j] * ((100 - arr[j]) / (double) 100);
                }
            }

            if (count >= user[i][1]) {
                people++;
                continue;
            }

            money += count;
        }

        temp[0] = people;
        temp[1] = money;

        return temp;

    }

    public static void main(String[] args) {

        int[][] users = { { 40, 2900 }, { 23, 10000 }, { 11, 5200 }, { 5, 5900 }, { 40, 3100 }, { 27, 9200 },
                { 32, 6900 } };
        int[] emoticons = { 1300, 1500, 1600, 4900 };
        solution(users, emoticons);
    }
}
