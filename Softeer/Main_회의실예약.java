package Softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_회의실예약 {

    static class Room implements Comparable<Room> {
        String roomName;
        boolean[] time;

        public Room(String roomName, boolean[] time) {
            this.roomName = roomName;
            this.time = time;
        }

        @Override
        public int compareTo(Room o) {
            return this.roomName.compareToIgnoreCase(o.roomName);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Room> room = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            room.add(new Room(br.readLine(), new boolean[10]));
        }

        Collections.sort(room);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String roomName = st.nextToken();
            int start = Integer.parseInt(st.nextToken()) - 9;
            int end = Integer.parseInt(st.nextToken()) - 9;

            for (int j = 0; j < room.size(); j++) {
                if (room.get(j).roomName.equals(roomName)) {
                    for (int k = start; k < end; k++) {
                        room.get(j).time[k] = true;
                    }
                }
            }

        }

        // --input end--

        for (int i = 0; i < room.size(); i++) {
            System.out.println("Room " + room.get(i).roomName + ":");
            boolean na = true;
            StringBuilder sb = new StringBuilder();
            int cnt = 0;
            for (int j = 0; j < room.get(i).time.length - 1; j++) {
                if (!room.get(i).time[j]) {
                    if (j == 0)
                        sb.append("09-");
                    else
                        sb.append((j + 9) + "-");
                    na = false;
                    cnt++;
                    int cnt2 = j;
                    while (true) {
                        if (cnt2 >= 9 || room.get(i).time[cnt2]) {
                            if (cnt2 == 0)
                                sb.append("09" + "\n");
                            else
                                sb.append((cnt2 + 9) + "\n");

                            j = cnt2;
                            break;
                        }

                        cnt2++;
                    }
                }
            }

            if (na)
                System.out.println("Not available");
            else {
                System.out.println(cnt + " available:");
                System.out.print(sb.toString());
            }

            if (i < room.size() - 1)
                System.out.println("-----");
        }

    }
}
