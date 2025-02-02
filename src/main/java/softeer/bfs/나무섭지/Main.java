package softeer.bfs.나무섭지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int n;
    private static int m;
    private static int[][] ghost;
    private static String[][] map;
    private static boolean[][] visited;
    private static int[] start;
    private static int[] end;
    private static int[] dr = new int[]{1, 0, -1, 0};
    private static int[] dc = new int[]{0, 1, 0, -1};
    private static List<int[]> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    private static void solve(){
        fillGhost();
        bfs();
    }

    private static void bfs(){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;

        while(!queue.isEmpty()){
            int[] poll = queue.poll();

            if(end[0] == poll[0] && end[1] == poll[1]){
                System.out.println("Yes");
                return;
            }

            for(int i = 0; i < 4; i++){
                int nr = poll[0] + dr[i];
                int nc = poll[1] + dc[i];
                int nLen = poll[2] + 1;

                if(isInBoard(nr, nc) && !map[nr][nc].equals("#") && ghost[nr][nc] > nLen && !visited[nr][nc]){
                    queue.add(new int[]{nr, nc, nLen});
                    visited[nr][nc] = true;
                }
            }
        }

        System.out.println("No");
    }

    private static void fillGhost(){
        Queue<int[]> queue = new LinkedList<>();

        for(int[] l : list){
            queue.add(new int[]{l[0], l[1], 0});
        }

        while(!queue.isEmpty()){
            int[] poll = queue.poll();

            for(int i = 0; i < 4; i++){
                int nr = poll[0] + dr[i];
                int nc = poll[1] + dc[i];
                int nLen = poll[2] + 1;

                if(isInBoard(nr, nc) && nLen < ghost[nr][nc]){
                    queue.add(new int[]{nr, nc, nLen});
                    ghost[nr][nc] = nLen;
                }
            }
        }
    }

    private static boolean isInBoard(int r, int c){
        if(r < 0 || c < 0 || r >= n || c >= m){
            return false;
        }

        return true;
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        ghost = new int[n][m];
        map = new String[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++){
            map[i] = br.readLine().split("");
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                ghost[i][j] = Integer.MAX_VALUE;

                if(map[i][j].equals("D")){
                    end = new int[]{i, j};
                }

                if(map[i][j].equals("N")){
                    start = new int[]{i, j};
                }

                if(map[i][j].equals("G")){
                    list.add(new int[]{i, j});
                }
            }
        }
    }
}
