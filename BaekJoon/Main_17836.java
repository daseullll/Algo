package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main_17836{

    static int N, M, limit, gramX, gramY, result;
    static boolean[][] check;
    static int[][] map;

    class Node{
        int r, c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        limit = Integer.parseInt(st.nextToken());
        result = 0;

        map = new int[N][M];
        check = new boolean[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==2){
                    gramX = i;
                    gramY = j;
                }
            }
        }

        //---input end---
        Queue<Node> queue = new LinkedList<Node>();

    }

    static int[][] delta = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    public static void bfs(int r, int c){

        if(r==N-1 && c==M-1){
        }

        for(int dir=0; dir<4; dir++){
            int rn = r + delta[dir][0];
            int cn = c + delta[0][dir];


        }

    }
}
