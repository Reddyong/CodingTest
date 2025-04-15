package boj.dp.정수삼각형_1932;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N, answer;
    private static int[][] board, dp;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        if (N == 1) {
            System.out.println(dp[0][0]);
            return;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + board[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + board[i][j];
                }
            }
        }

        for (int i = 0; i < N; i++) {
            answer = Math.max(dp[N - 1][i], answer);
        }

        System.out.println(answer);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        answer = 0;
        board = new int[N][N];
        dp = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = board[0][0];
    }
}
