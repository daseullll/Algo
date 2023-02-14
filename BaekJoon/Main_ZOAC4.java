import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_ZOAC4 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double h = Integer.parseInt(st.nextToken());
        double w = Integer.parseInt(st.nextToken());
        double n = Integer.parseInt(st.nextToken());
        double m = Integer.parseInt(st.nextToken());

        System.out.println((int) Math.ceil(h / (n + 1)) * (int) Math.ceil(w / (m + 1)));
    }
}
