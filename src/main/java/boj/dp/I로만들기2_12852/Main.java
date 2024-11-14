package boj.dp.I로만들기2_12852;

import java.util.Scanner;

public class Main {
    static int N;
    static int[] dp;
    static int[] temp;
    public static void main(String[] args) {
        init();
        solve();
    }

    private static void solve() {
        for (int i = 2; i <= N; i++) {
            if (i % 2 == 0 && i % 3 == 0) {
                dp[i] = Math.min(Math.min(dp[i / 2], dp[i / 3]), dp[i - 1]) + 1;

                int min = Math.min(Math.min(dp[i / 2], dp[i / 3]), dp[i - 1]);
                if (min == dp[i / 2]) {
                    temp[i] = i / 2;
                } else if (min == dp[i / 3]) {
                    temp[i] = i / 3;
                } else {
                    temp[i] = i - 1;
                }
            } else if (i % 2 == 0) {
                dp[i] = Math.min(dp[i / 2], dp[i - 1]) + 1;

                if (dp[i / 2] > dp[i - 1]) {
                    temp[i] = i - 1;
                } else {
                    temp[i] = i / 2;
                }
            } else if (i % 3 == 0) {
                dp[i] = Math.min(dp[i / 3], dp[i - 1]) + 1;

                if (dp[i / 3] > dp[i - 1]) {
                    temp[i] = i - 1;
                } else {
                    temp[i] = i / 3;
                }
            } else {
                dp[i] = dp[i - 1] + 1;
                temp[i] = i - 1;
            }
        }

        System.out.println(dp[N]);

        int num = N;
        StringBuilder sb = new StringBuilder();
        while (true) {
            sb.append(num + " ");
            if (num == 1) {
                break;
            }
            num = temp[num];
        }

        System.out.println(sb);
    }

    private static void init() {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        dp = new int[N + 1];
        temp = new int[N + 1];
    }
}
