import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Main_단어정렬 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> arr = new ArrayList<>();

        int N = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < N; i++) {
            arr.add(sc.nextLine());
        }

        Collections.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return o1.length() - o2.length();
            }
        });

        LinkedHashSet<String> result = new LinkedHashSet<>();
        for (int i = 0; i < arr.size(); i++) {
            result.add(arr.get(i));
        }

        for (String s : result) {
            System.out.println(s);
        }

    }
}
