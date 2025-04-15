package boj.dp.nx2타일링2;

import java.util.Scanner;

public class Main {
    private static int N;
    private static int[] dp;
    private static final int MOD = 10007;
    public static void main(String[] args) {
        init();
        solve();
    }

    private static void solve() {
        if (N <= 2) {
            System.out.println(dp[N]);
            return;
        }

        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1] % MOD + (dp[i - 2] * 2) % MOD;
        }

        System.out.println(dp[N] % MOD);
    }

    private static void init() {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();

        dp = new int[N + 1];
        dp[1] = 1;

        if (N > 1) {
            dp[2] = 3;
        }
    }
}
