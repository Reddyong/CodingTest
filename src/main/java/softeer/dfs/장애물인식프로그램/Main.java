package softeer.dfs.장애물인식프로그램;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int ans;
    static int[][] board;
    static int[][] check;
    static int[] dr = new int[]{1, 0, -1, 0};
    static int[] dc = new int[]{0, 1, 0, -1};
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        init();
        solve();
    }

    private static void solve(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(check[i][j] == 0 && board[i][j] == 1){
                    bfs(i, j);
                }
            }
        }

        System.out.println(ans);
        Collections.sort(list);
        for(int num : list){
            System.out.println(num);
        }
    }

    private static void bfs(int r, int c){
        Stack<Pos> stack = new Stack<>();
        stack.push(new Pos(r, c));
        check[r][c] = ans + 1;

        int temp = 1;

        while(!stack.isEmpty()){
            Pos pop = stack.pop();

            for(int i = 0; i < 4; i++){
                int nr = pop.r + dr[i];
                int nc = pop.c + dc[i];

                if(isInBoard(nr, nc) && board[nr][nc] == 1 && check[nr][nc] == 0){
                    stack.push(new Pos(nr, nc));
                    check[nr][nc] = ans + 1;
                    temp++;
                }
            }
        }

        if(temp != 0){
            ans++;
            list.add(temp);
        }
    }

    private static boolean isInBoard(int r, int c){
        if(r < 0 || c < 0 || r >= N || c >= N){
            return false;
        }

        return true;
    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        check = new int[N][N];
        ans = 0;

        for(int i = 0; i < N; i++){
            String[] split = br.readLine().split("");
            for(int j = 0; j < N; j++){
                board[i][j] = Integer.parseInt(split[j]);
            }
        }
    }

    private static class Pos{
        int r;
        int c;

        public Pos(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}

