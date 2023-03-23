
import java.util.Arrays;
import java.util.HashMap;

public class Solution_주차요금계산 {
    static public int[] solution(int[] fees, String[] records) {

        HashMap<String, Integer> car = new HashMap<>();

        for (int i = 0; i < records.length; i++) {
            String time = records[i].split(" ")[0];
            String num = records[i].split(" ")[1];
            String state = records[i].split(" ")[2];
            int time2 = (Integer.parseInt(time.split(":")[0]) * 60 + Integer.parseInt(time.split(":")[1]));

            int realTime = -1;
            if (state.equals("IN")) {
                int j = i + 1;
                Loop: while (j < records.length) {
                    if (num.equals(records[j].split(" ")[1]) && records[j].split(" ")[2].equals("OUT")) {
                        // System.out.println("find " + num);
                        int time3 = (Integer.parseInt(records[j].split(" ")[0].split(":")[0]) * 60
                                + Integer.parseInt(records[j].split(" ")[0].split(":")[1]));
                        realTime = time3 - time2;
                        if (car.containsKey(num)) {
                            int temp = car.get(num);
                            car.put(num, realTime + temp);
                        } else {
                            car.put(num, realTime);
                        }
                        break Loop;
                    }
                    j++;
                }
                if (realTime == -1) { // 입차만 하고 출차는 하지 않았을 경우
                    // System.out.println("No Out " + num);
                    realTime = 1439 - time2;

                    if (car.containsKey(num)) {
                        int temp = car.get(num);
                        car.put(num, realTime + temp);
                    } else {
                        car.put(num, realTime);
                    }
                }

            }
        }

        Object[] mapKey = car.keySet().toArray();
        Arrays.sort(mapKey);

        int[] answer = new int[car.size()];

        for (int i = 0; i < mapKey.length; i++) {
            // System.out.println(mapKey[i]);
            double temp = car.get(mapKey[i]);
            System.out.println(temp);
            if (temp <= fees[0])
                answer[i] = fees[1];
            else {
                answer[i] = (int) (fees[1] + (Math.ceil((temp - fees[0]) / fees[2]) * fees[3]));
            }
        }

        for (int i : answer) {
            System.out.println(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        int fees[] = { 1, 461, 1, 10 };
        String records[] = { "00:00 1234 IN" };

        solution(fees, records);
    }
}