package softeer.dfs.나무조경;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int answer;
    private static int[][] garden;
    private static boolean[][] visited;
    private static int[] dr = new int[]{1, 0, -1, 0};
    private static int[] dc = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        init();
        solve(0, 0);

        System.out.println(answer);
    }

    private static void solve(int sum, int depth){
        if(depth <= 4){
            answer = Math.max(answer, sum);
        }

        if(depth == 4){
            answer = Math.max(answer, sum);
            return;
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(visited[i][j]){
                    continue;
                }

                int temp = 0;

                visited[i][j] = true;
                temp += garden[i][j];

                for(int k = 0; k < 4; k++){
                    int nr = i + dr[k];
                    int nc = j + dc[k];

                    if(isInBoard(nr, nc) && !visited[nr][nc]){
                        visited[nr][nc] = true;
                        temp += garden[nr][nc];
                        solve(sum + temp, depth + 1);
                        visited[nr][nc] = false;
                        temp -= garden[nr][nc];
                    }
                }

                visited[i][j] = false;
                temp -= garden[i][j];
            }
        }
    }

    private static boolean isInBoard(int nr, int nc){
        if(nr < 0 || nc < 0 || nr >= n || nc >= n){
            return false;
        }

        return true;
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        answer = 0;
        garden = new int[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                garden[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}