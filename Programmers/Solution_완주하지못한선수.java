package Programmers;

import java.util.*;
import java.io.*;

public class Solution_완주하지못한선수 {

    public static String solution(String[] participant, String[] completion) {
        String answer = " ";
        HashMap<String, Integer> par = new HashMap<>();

        for (int i = 0; i < participant.length; i++) {
            int cnt = 1;
            if (par.containsKey(participant[i])) {
                cnt = par.get(participant[i]) + 1;
            }
            par.put(participant[i], cnt);
        }

        for (int i = 0; i < completion.length; i++) {
            par.put(completion[i], par.get(completion[i]) - 1);

        }

        for (int i = 0; i < par.size(); i++) {
            if (par.get(participant[i]) != 0) {
                answer = participant[i];
            }
        }

        return answer;

    }

    public static void main(String[] args) {
        String[] par = { "marina", "josipa", "nikola", "vinko", "filipa" };
        String[] com = { "josipa", "filipa", "marina", "nikola" };

        System.out.println(solution(par, com));
    }

}
