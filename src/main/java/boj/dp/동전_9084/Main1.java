package boj.dp.동전_9084;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main1 {
    private static int T, N, M;
    private static int[][] dp;
    private static int[] coins;
    private static BufferedReader br;
    private static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        solve();
    }

    private static void solve() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            // 변수 초기화
            init();
            // 단계별 풀이 진행
            coin();
        }
    }

    private static void coin() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (j < coins[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i]];
                }
            }
        }

        System.out.println(dp[N][M]);
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        coins = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        dp = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            dp[i][0] = 1;
        }
    }
}
