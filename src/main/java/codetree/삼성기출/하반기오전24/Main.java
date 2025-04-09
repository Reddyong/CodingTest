package codetree.삼성기출.하반기오전24;

import java.util.*;
import java.io.*;

public class Main {
    private static int N, M, F, answer;
    private static int[] start, end;
    private static int[][] floor, top, east, west, south, north, copyFloor;
    private static Anomaly[] anomalies;
    private static int[] dr = new int[]{0, 0, 1, -1};
    private static int[] dc = new int[]{1, -1, 0, 0};
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        init();
        solve();
    }

    private static void solve(){
        // 이상현상 확산
        makeAnomaly();

        // TODO : 타임머신 bfs 진행


    }

    private static void makeAnomaly(){
        // 확산이 가능한 지점까지 이상현상 확산
        for(Anomaly anomaly : anomalies){
            int nr = anomaly.r;
            int nc = anomaly.c;
            int direction = anomaly.dir;
            int v = anomaly.v;
            int count = 0;

            while(true){
                if(!isInBoard(nr, nc)){
                    break;
                }

                if(floor[nr][nc] == 1){
                    break;
                }

                if(copyFloor[nr][nc] > v * count){
                    copyFloor[nr][nc] = v * count;
                }

                // TODO : 이동한 위치가 시간의 벽인 경우

                count++;

                nr = nr + dr[direction];
                nc = nc + dc[direction];

            }
        }
    }

    private static boolean isInBoard(int r, int c) {
        if (r < 0 || c < 0 || r >= N || c >= N) {
            return false;
        }

        return true;
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        F = Integer.parseInt(st.nextToken());

        floor = new int[N][N];
        copyFloor = new int[N][N];
        top = new int[M][M];
        east = new int[M][M];
        west = new int[M][M];
        south = new int[M][M];
        north = new int[M][M];
        anomalies = new Anomaly[F];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            Arrays.fill(copyFloor[i], Integer.MAX_VALUE);
            for(int j = 0; j < N; j++){
                floor[i][j] = Integer.parseInt(st.nextToken());
                if (floor[i][j] == 4) {
                    end = new int[]{i, j};
                }
            }
        }

        // east
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                east[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // west
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                west[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // south
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                south[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // north
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                north[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // top
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                top[i][j] = Integer.parseInt(st.nextToken());
                if (top[i][j] == 2) {
                    start = new int[]{i, j};
                }
            }
        }

        for(int i = 0; i < F; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            anomalies[i] = new Anomaly(r, c, dir, v);
        }
    }

    private static class Anomaly{
        int r;
        int c;
        int dir;
        int v;

        public Anomaly(int r, int c, int dir, int v){
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.v = v;
        }
    }
}