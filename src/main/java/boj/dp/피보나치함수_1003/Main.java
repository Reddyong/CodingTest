package boj.dp.피보나치함수_1003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int T, N;
    private static int[][] dp;
    private static BufferedReader br;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() throws IOException {
        // dp 배열 채워넣기
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        for (int i = 2; i <= 40; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());

            System.out.println(dp[N][0] + " " + dp[N][1]);
        }

    }

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        dp = new int[41][2];
    }
}
