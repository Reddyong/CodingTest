package boj.dp.nx2타일링_11726;

import java.util.Scanner;

public class Main {
    static int N;
    static int[] dp;
    public static void main(String[] args) {
        init();
        solve();
    }

    private static void solve() {
        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1] % 10007 + dp[i - 2] % 10007;
        }

        System.out.println(dp[N] % 10007);
    }

    private static void init() {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        dp = new int[N + 1];

        dp[1] = 1;
        if (N >= 2) {
            dp[2] = 2;
        }
    }
}
