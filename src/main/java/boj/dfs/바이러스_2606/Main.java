package boj.dfs.바이러스_2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int computer;
    static int road;
    static int[][] board;
    static boolean[] visited;
    static int ans;
    public static void main(String[] args) throws IOException {
        init();
        solve(1);
        System.out.println(ans);
    }

    private static void solve(int start) {
        visited[start] = true;

        for (int i = 1; i <= computer; i++) {
            if (!visited[i] && board[start][i] == 1) {
                solve(i);
                ans++;
            }
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ans = 0;
        computer = Integer.parseInt(st.nextToken());
        visited = new boolean[computer + 1];
        board = new int[computer + 1][computer + 1];

        st = new StringTokenizer(br.readLine());
        road = Integer.parseInt(st.nextToken());

        for (int i = 0; i < road; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            board[start][end] = 1;
            board[end][start] = 1;
        }
    }
}
