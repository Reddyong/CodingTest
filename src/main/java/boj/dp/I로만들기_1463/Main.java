package boj.dp.I로만들기_1463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        if (N == 1) {
            System.out.println(0);
            return;
        }

        if (N == 2) {
            System.out.println(1);
            return;
        }

        if (N == 3) {
            System.out.println(1);
            return;
        }
        for (int i = 4; i < N + 1; i++) {
            if (i % 2 == 0 && i % 3 == 0) {
                dp[i] = Math.min(Math.min(dp[i / 2], dp[i / 3]), dp[i - 1]) + 1;
                continue;
            } else if (i % 2 == 0) {
                dp[i] = Math.min(dp[i / 2], dp[i - 1]) + 1;
            } else if (i % 3 == 0) {
                dp[i] = Math.min(dp[i / 3], dp[i - 1]) + 1;
            } else {
                dp[i] = dp[i - 1] + 1;
            }
        }

        System.out.println(dp[N]);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];

        if (N > 3) {
            dp[2] = 1;
            dp[3] = 1;
        }
    }
}
