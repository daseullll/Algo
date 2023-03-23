
import java.util.LinkedList;

public class Solution_캐시 {
    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;

        LinkedList<String> cache = new LinkedList<String>();
        if (cacheSize == 0) {
            answer = cities.length * 5;
            System.out.println(answer);
            return answer;
        }
        Loop: for (int i = 0; i < cities.length; i++) {
            for (int j = 0; j < cache.size(); j++) {
                if (cities[i].toLowerCase().equals(cache.get(j).toLowerCase())) { // 같은 값이 있을 경우
                    cache.remove(j);
                    cache.add(cities[i]);
                    System.out.println(cities[i] + " " + j);
                    answer += 1;
                    continue Loop;
                }
            }

            // 같은 값이 없을 경우 > 제일 앞에 있는 거 빼기
            if (cache.size() < cacheSize) { // 아직 캐시가 다 차지 않았을 경우
                cache.add(cities[i]);
                answer += 5;
            } else {
                cache.remove(0);
                cache.add(cities[i]);
                answer += 5;
            }
        }
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        String[] cities = { "Jeju", "Pangyo", "Seoul", "NewYork", "LA" };

        solution(0, cities);
    }
}