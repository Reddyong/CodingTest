package softeer.dfs.장애물인식프로그램;

import java.io.*;
import java.util.*;

public class Main1 {
    private static int N;
    private static int max;
    private static int[][] map;
    private static boolean[][] visited;
    private static List<Integer> list;
    private static int[] dr = new int[]{1, 0, -1, 0};
    private static int[] dc = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    private static void solve(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    max = 1;
                    visited[i][j] = true;
                    dfs(i, j);

                    list.add(max);
                }
            }
        }

        list.sort((o1, o2) -> o1 - o2);

        System.out.println(list.size());
        for(int num : list){
            System.out.println(num);
        }
    }

    private static void dfs(int r, int c){
        for(int i = 0; i < 4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(isInBoard(nr, nc) && !visited[nr][nc] && map[nr][nc] != 0){
                max++;
                visited[nr][nc] = true;
                dfs(nr, nc);
            }
        }
    }

    private static boolean isInBoard(int r, int c){
        if(r < 0 || c < 0 || r >= N || c >= N){
            return false;
        }

        return true;
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        list = new ArrayList<>();
        max = 0;

        for(int i = 0; i < N; i++){
            String[] temp = br.readLine().split("");
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(temp[j]);
            }

        }
    }
}
