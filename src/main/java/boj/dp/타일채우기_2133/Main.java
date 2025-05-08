package boj.dp.타일채우기_2133;

import java.util.Scanner;

public class Main {
    private static int N;
    private static int[] dp;
    public static void main(String[] args) {
        // dp 배열 초기화
        init();
        // 풀이 과정
        solve();
    }

    private static void solve() {
        if (N % 2 != 0) {
            System.out.println(0);
            return;
        }
        for (int i = 2; i <= N; i += 2) {
            dp[i] = dp[i - 2] * 3;
            for (int j = i - 4; j >= 0; j -= 2) {
                dp[i] += dp[j] * 2;
            }
        }

        System.out.println(dp[N]);
    }

    private static void init() {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();

        dp = new int[N + 1];
        dp[0] = 1;
    }
}
