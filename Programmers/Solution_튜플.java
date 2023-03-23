
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Solution_튜플 {

    public static ArrayList<Integer> solution(String s) {

        ArrayList<Integer> list = new ArrayList<>();
        String temp = s.substring(2, s.length() - 2);
        String[] ss = temp.split("}\\,\\{");

        // 길이순으로 정렬
        Arrays.sort(ss, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });

        list.add(Integer.parseInt(ss[0]));

        for (int i = 1; i < ss.length; i++) {
            String[] stemp = ss[i].split(",");
            for (int j = 0; j < stemp.length; j++) {
                if (!list.contains(Integer.parseInt(stemp[j])))
                    list.add(Integer.parseInt(stemp[j]));
            }

        }

        for (int a : list) {
            System.out.print(a + " ");
        }

        return list;
    }

    public static void main(String[] args) {
        String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
        solution(s);
    }

}
