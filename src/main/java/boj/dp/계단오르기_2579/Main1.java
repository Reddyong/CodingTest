package boj.dp.계단오르기_2579;

import java.util.Scanner;

public class Main1 {
    static int N;
    static int[] stairs;
    static int[][] dp;
    public static void main(String[] args) {
        init();
        solve();
    }

    private static void solve() {
        for (int i = 3; i < N + 1; i++) {
            dp[i][1] = Math.max(dp[i - 2][1], dp[i - 2][2]) + stairs[i];
            dp[i][2] = dp[i - 1][1] + stairs[i];
        }

        System.out.println(Math.max(dp[N][1], dp[N][2]));
    }

    private static void init() {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        stairs = new int[N + 1];
        dp = new int[N + 1][3];

        for (int i = 1; i <= N; i++) {
            stairs[i] = scanner.nextInt();
        }

        dp[1][1] = stairs[1];
        dp[1][2] = 0;

        if (N >= 2) {
            dp[2][1] = stairs[2];
            dp[2][2] = stairs[1] + stairs[2];
        }
    }
}
