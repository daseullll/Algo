import java.util.ArrayList;
import java.util.HashSet;

public class Solution_마이다스 {

    public static String solution(String[] Dir, String[][] Cmd) {

        HashSet<String> folder = new HashSet<>();

        String start = Dir[0];
        folder.add(start);
        for (int i = 1; i < Dir.length; i++) {
            // if (Dir[i].contains(".")) {
            // // folder.add(Dir[i].split("/")[2]);

            // }
            folder.add(Dir[i]);
        }

        String cur = "";
        for (int i = 0; i < Cmd.length; i++) {
            String cmd2 = Cmd[i][1];
            if (!cmd2.startsWith("c") && !cmd2.startsWith("C")) {
                cmd2 = cur.concat(start + "/").concat(Cmd[i][1]);
            }

            if (Cmd[i][0].equalsIgnoreCase("CD")) {
                if (folder.contains(cmd2))
                    cur = cmd2;

            } else if (Cmd[i][0].equalsIgnoreCase("mkdir")) {
                if (!folder.contains(cmd2)) {
                    folder.add(cmd2);
                }
            }
        }

        // for (String s : folder) {
        // System.out.println(s);
        // }

        System.out.println(cur);
        return cur;
    }

    public static void main(String[] args) {
        String[] Dir = { "C:/root", "C:/root/folder1", "C:/root/folder2/file1.txt", "C:/root/folder2/file2.txt" };
        String[][] Cmd = { { "mkdir", "C:/root/folder3" }, { "cd", "C:/root/folder3" } };

        // C:/root/folder1
        solution(Dir, Cmd);
    }
}
