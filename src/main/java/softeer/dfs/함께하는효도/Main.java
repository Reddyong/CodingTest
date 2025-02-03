package softeer.dfs.함께하는효도;

import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static int m;
    private static int answer;
    private static int[][] map;
    private static int[][] friends;
    private static boolean[][] visited;
    private static int[] dr = new int[]{1, 0, -1, 0};
    private static int[] dc = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    private static void solve(){
        dfs(friends[0][0], friends[0][1], 0, 0, answer);

        System.out.println(answer);
    }

    private static void dfs(int r, int c, int idx, int depth, int sum){
        answer = Math.max(sum, answer);

        if(depth == 3){
            if(idx + 1 < m){
                dfs(friends[idx + 1][0], friends[idx + 1][1], idx + 1, 0, sum);
            }

            return;
        }

        for(int i = 0; i < 4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(isInBoard(nr, nc) && !visited[nr][nc]){
                visited[nr][nc] = true;
                dfs(nr, nc, idx, depth + 1, sum + map[nr][nc]);
                visited[nr][nc] = false;
            }
        }
    }

    private static boolean isInBoard(int r, int c){
        if(r < 0 || c < 0 || r >= n || c >= n){
            return false;
        }

        return true;
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        answer = 0;
        map = new int[n][n];
        friends = new int[m][2];
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;

            friends[i] = new int[]{r, c};
            visited[r][c] = true;
            answer += map[r][c];
        }
    }
}
