package boj.dp.제곱수의합_1699;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static int N;
    private static int[] dp;
    public static void main(String[] args) {
        // N, dp 배열 초기화
        init();
        // 풀이과정
        solve();
    }

    private static void solve() {
        // dp[i] 는 현재 단계의 수를 만들기 위해 필요한 제곱수의 최소 갯수를 의미한다.
        // 제곱수의 갯수는 dp[i - j * j]에서 j * j 제곱수 항을 더하는 경우인, +1한 값이 되게 된다.

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        System.out.println(dp[N]);
    }

    private static void init() {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        dp = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
    }
}
