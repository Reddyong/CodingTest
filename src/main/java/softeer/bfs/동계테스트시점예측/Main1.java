package softeer.bfs.동계테스트시점예측;

import java.io.*;
import java.util.*;

public class Main1 {
    private static int N;
    private static int M;
    private static int time;
    private static int[][] map;
    private static boolean[][] visited;
    private static List<Pos> melting = new ArrayList<>();
    private static int[] dr = new int[]{1, 0, -1, 0};
    private static int[] dc = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    private static void solve(){
        int time = 0;

        while(true){
            bfs(0, 0);

            melting = new ArrayList<>();
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(map[i][j] == 1 && isCurMelting(i, j)){
                        melting.add(new Pos(i, j));
                    }
                }
            }

            if(melting.isEmpty()){
                break;
            }

            for(Pos cur : melting){
                map[cur.r][cur.c] = 0;
            }

            time++;
        }

        System.out.println(time);
    }

    private static boolean isCurMelting(int r, int c){
        int count = 0;

        if(map[r - 1][c] == 0 && visited[r - 1][c]){
            count++;
        }

        if(map[r][c - 1] == 0 && visited[r][c - 1]){
            count++;
        }

        if(map[r + 1][c] == 0 && visited[r + 1][c]){
            count++;
        }

        if(map[r][c + 1] == 0 && visited[r][c + 1]){
            count++;
        }

        if(count >= 2){
            return true;
        }

        return false;
    }

    private static void bfs(int r, int c){
        Queue<Pos> queue = new LinkedList<>();
        visited = new boolean[N][M];
        queue.add(new Pos(r, c));
        visited[r][c] = true;

        while(!queue.isEmpty()){
            Pos poll = queue.poll();

            for(int i = 0; i < 4; i++){
                int nr = poll.r + dr[i];
                int nc = poll.c + dc[i];

                if(isInBoard(nr, nc) && !visited[nr][nc] && map[nr][nc] == 0){
                    visited[nr][nc] = true;
                    queue.add(new Pos(nr, nc));
                }
            }
        }
    }

    private static boolean isInBoard(int r, int c){
        if(r < 0 || c < 0 || r >= N || c >= M){
            return false;
        }

        return true;
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        time = 0;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static class Pos {
        int r;
        int c;

        public Pos(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}
