package boj.dp.돌게임_9655;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static int N;
    private static int[] dp;
    private static int[] rocks = new int[]{1, 3};
    public static void main(String[] args) {
        // dp 배열 초기화
        init();
        // 풀이 과정
        solve();
    }

    private static void solve() {
        // dp 배열 채우기
        // dp[i]는 i개의 돌을 만들기 위해 수행한 게임의 최소 횟수
        for (int i = 1; i <= N; i++) {
            for(int rock : rocks){
                if (i - rock >= 0) {
                    dp[i] = Math.min(dp[i - rock] + 1, dp[i]);
                }
            }
        }

        // 게임 횟수가 홀수이면 상근이 승, 짝수이면 창영이 승
        if (dp[N] % 2 != 0) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }
    }

    private static void init() {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        dp = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
    }
}
